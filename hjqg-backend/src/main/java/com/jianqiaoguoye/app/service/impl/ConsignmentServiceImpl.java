package com.jianqiaoguoye.app.service.impl;

import com.jianqiaoguoye.app.service.ConsignmentService;
import com.jianqiaoguoye.domain.entity.Consignment;
import com.jianqiaoguoye.domain.entity.Order;
import com.jianqiaoguoye.domain.repository.ConsignmentRepository;
import com.jianqiaoguoye.domain.repository.OrderRepository;
import com.jianqiaoguoye.infra.util.StringConstant;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.oauth.DetailsHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hzero.core.base.BaseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 配货单应用服务默认实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Slf4j
@Service
public class ConsignmentServiceImpl implements ConsignmentService {

    @Autowired
    private ConsignmentRepository consignmentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Consignment> list(Consignment consignment) {
        consignment = Objects.isNull(consignment) ? new Consignment() : consignment;

        // code 不为空说明是详情页查询，需要返回组合地址
        boolean isDetailQuery = false;
        if (StringUtils.isNotBlank(consignment.getConsignmentCode())) {
            isDetailQuery = true;
        }

        List<Consignment> consignmentList = consignmentRepository.list(consignment);

        if (isDetailQuery) {
            // consignmentList.size() = 1
            consignmentList.forEach(item -> {
                Order orderSelector = new Order();
                orderSelector.setOrderId(item.getOrderId());
                Order order = orderRepository.list(orderSelector).get(0);

                item.setCombineAddress(order.getAddressCombine());
            });
        }

        return consignmentList;
    }

    @Override
    public void handleOperation(Consignment consignment) {
        if (null == consignment) {
            throw new CommonException("数据为空，无法处理");
        }
        switch (consignment.getConsignmentStatusCode()) {
            // 审核
            case StringConstant.Consignment.ConsignmentStatus.CONSIGNING:
                handleApprove(consignment);
                break;

            // 配货完成
            case StringConstant.Consignment.ConsignmentStatus.WAITING_DELIVERY:
                handleConsign(consignment);
                break;

            // 发货
            case StringConstant.Consignment.ConsignmentStatus.DELIVERED:
                handleDelivery(consignment);
                break;
            default:
                throw new CommonException("非法参数: " + consignment.getConsignmentStatusCode());
        }
    }

    @Override
    public void handlePickup(Consignment consignment) {
        if (StringConstant.Order.DeliveryType.PICKUP.equals(consignment.getDeliveryTypeCode())) {
            consignment.setDeliveryDate(LocalDateTime.now());
            consignment.setConsignmentStatusCode(StringConstant.Consignment.ConsignmentStatus.DELIVERED);
            consignmentRepository.updateByPrimaryKeySelective(consignment);

            // 修改订单状态
            Long orderId = consignment.getOrderId();
            Order order = orderRepository.selectByPrimaryKey(orderId);
            Assert.isTrue(null != order, "无法匹配订单: " + orderId);
            order.appendProcessMsg("已自提");
            order.setOrderStatusCode(StringConstant.Order.OrderStatus.WAITING_COMMENT);
            order.setIsDeliveryDispatch(BaseConstants.Digital.ONE);
            order.setDeliveryTime(consignment.getDeliveryDate());
            orderRepository.updateByPrimaryKeySelective(order);
        } else {
            throw new CommonException("非自提配货单");
        }
    }

    private void handleApprove(Consignment consignment) {
        // 更新配货单数据
        consignment.setIsManualApproved(BaseConstants.Digital.ONE);
        consignment.setApprovedDate(LocalDateTime.now());
        consignment.setApproverId(DetailsHelper.getUserDetails().getUserId());

        consignmentRepository.updateByPrimaryKeySelective(consignment);

        updateOrderProcessMsg(consignment, "配货单已审核");
    }

    private void handleConsign(Consignment consignment) {
        if (StringUtils.isBlank(consignment.getConsigner())) {
            throw new CommonException("配货人不能为空");
        }

        consignmentRepository.updateByPrimaryKeySelective(consignment);

        updateOrderProcessMsg(consignment, "配货完成，准备发货");
    }

    private void handleDelivery(Consignment consignment) {
        StringBuilder errorString = new StringBuilder();
        if (null == consignment.getDeliveryCost()) {
            errorString.append(" 运费为空 ");
        }
        if (StringUtils.isBlank(consignment.getDeliveryCarrier())) {
            errorString.append(" 承运商为空 ");
        }
        if (StringUtils.isBlank(consignment.getDeliveryNumber())) {
            errorString.append(" 快递单号为空 ");
        }
        if (StringUtils.isNotBlank(errorString.toString())) {
            throw new CommonException(errorString.toString());
        }
        // 发货时间
        consignment.setDeliveryDate(LocalDateTime.now());

        consignmentRepository.updateByPrimaryKeySelective(consignment);

        // 修改订单状态
        Long orderId = consignment.getOrderId();
        Order order = orderRepository.selectByPrimaryKey(orderId);
        Assert.isTrue(null != order, "无法匹配订单: " + orderId);
        order.appendProcessMsg("已发货");
        order.setOrderStatusCode(StringConstant.Order.OrderStatus.DELIVERING);
        order.setIsDeliveryDispatch(BaseConstants.Digital.ONE);
        order.setDeliveryCarrier(consignment.getDeliveryCarrier());
        order.setDeliveryNumber(consignment.getDeliveryNumber());
        order.setDeliveryCost(consignment.getDeliveryCost());
        order.setDeliveryTime(consignment.getDeliveryDate());
        orderRepository.updateByPrimaryKeySelective(order);
    }

    /**
     * 更新订单处理信息
     *
     * @param consignment 配货单
     * @param processMsg  处理消息
     */
    private void updateOrderProcessMsg(Consignment consignment, String processMsg) {
        Long orderId = consignment.getOrderId();
        Order order = orderRepository.selectByPrimaryKey(orderId);
        Assert.isTrue(null != order, "无法匹配订单: " + orderId);
        order.appendProcessMsg(processMsg);
        orderRepository.updateOptional(order, Order.FIELD_PROCESS_MESSAGE);
    }
}
