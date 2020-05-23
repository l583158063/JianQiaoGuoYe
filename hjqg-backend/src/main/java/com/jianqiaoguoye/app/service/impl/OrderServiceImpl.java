package com.jianqiaoguoye.app.service.impl;

import com.jianqiaoguoye.app.service.OrderService;
import com.jianqiaoguoye.domain.entity.Order;
import com.jianqiaoguoye.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 订单头应用服务默认实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> list(Order order) {
        order = (Objects.isNull(order)) ? new Order() : order;
        return orderRepository.list(order);
    }
}
