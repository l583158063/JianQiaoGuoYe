package com.jianqiaoguoye.app.service.impl;

import com.jianqiaoguoye.app.service.ConsignmentService;
import com.jianqiaoguoye.domain.entity.Consignment;
import com.jianqiaoguoye.domain.entity.Order;
import com.jianqiaoguoye.domain.repository.ConsignmentRepository;
import com.jianqiaoguoye.domain.repository.OrderRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 配货单应用服务默认实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
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
}
