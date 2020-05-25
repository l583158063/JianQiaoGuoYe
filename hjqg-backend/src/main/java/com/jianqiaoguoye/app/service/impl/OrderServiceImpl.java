package com.jianqiaoguoye.app.service.impl;

import com.jianqiaoguoye.app.service.OrderService;
import com.jianqiaoguoye.domain.entity.Consignment;
import com.jianqiaoguoye.domain.entity.ConsignmentEntry;
import com.jianqiaoguoye.domain.entity.Order;
import com.jianqiaoguoye.domain.entity.OrderEntry;
import com.jianqiaoguoye.domain.repository.ConsignmentEntryRepository;
import com.jianqiaoguoye.domain.repository.ConsignmentRepository;
import com.jianqiaoguoye.domain.repository.OrderEntryRepository;
import com.jianqiaoguoye.domain.repository.OrderRepository;
import com.jianqiaoguoye.infra.util.StringConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.core.base.BaseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 订单头应用服务默认实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderEntryRepository orderEntryRepository;
    @Autowired
    private ConsignmentRepository consignmentRepository;
    @Autowired
    private ConsignmentEntryRepository consignmentEntryRepository;

    @Override
    public List<Order> list(Order order) {
        order = (Objects.isNull(order)) ? new Order() : order;
        return orderRepository.list(order);
    }

    @Override
    public String confirmOrder(Long orderId) {
        // 更新订单数据
        Order order = orderRepository.selectByPrimaryKey(orderId);
        Assert.isTrue(null != order, "订单不存在: " + orderId);

        order.setOrderStatusCode(StringConstant.Order.OrderStatus.CONSIGNING);
        order.setIsManualApproved(BaseConstants.Digital.ONE);
        order.appendProcessMsg("订单已确认");

        orderRepository.updateByPrimaryKeySelective(order);

        // 生成配货单
        Consignment consignment = new Consignment();
        // 校验是否已存在配货单
        consignment.setOrderId(orderId);
        List<Consignment> existConsignmentList = consignmentRepository.select(consignment);
        if (CollectionUtils.isNotEmpty(existConsignmentList)) {
            return null;
        }
        // 组装配货单数据
        installConsignment(consignment, order);
        // 生成配货单头，回填id
        consignmentRepository.insertSelective(consignment);

        // 组装配货单行数据
        installConsignmentEntry(consignment, order);
        // 生成配货单行
        consignmentEntryRepository.batchInsertSelective(consignment.getConsignmentEntryList());

        return consignment.getConsignmentCode();
    }

    private void installConsignment(Consignment consignment, Order order) {
        consignment.setConsignmentCode(order.getOrderCode());
        consignment.setDeliveryTypeCode(order.getDeliveryTypeCode());
        consignment.setConsignmentStatusCode(StringConstant.Consignment.ConsignmentStatus.WAITING_APPROVE);
        consignment.setRemarks(order.getRemarks());
    }

    private void installConsignmentEntry(Consignment consignment, Order order) {
        List<OrderEntry> orderEntryList = orderEntryRepository.listByOrderId(order.getOrderId());
        Assert.isTrue(CollectionUtils.isNotEmpty(orderEntryList), "订单行不存在: " + order.getOrderId());

        List<ConsignmentEntry> consignmentEntryList = new ArrayList<>();
        orderEntryList.forEach(orderEntry -> {
            ConsignmentEntry consignmentEntry = new ConsignmentEntry();
            consignmentEntry.setConsignmentId(consignment.getConsignmentId());
            consignmentEntry.setEntryNumber(orderEntry.getEntryNumber());
            consignmentEntry.setOrderEntryId(orderEntry.getOrderEntryId());
            consignmentEntry.setRemarks(orderEntry.getRemarks());
            consignmentEntryList.add(consignmentEntry);
        });

        consignment.setConsignmentEntryList(consignmentEntryList);
    }

}
