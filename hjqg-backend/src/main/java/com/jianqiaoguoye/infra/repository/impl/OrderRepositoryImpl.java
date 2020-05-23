package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.Order;
import com.jianqiaoguoye.domain.repository.OrderRepository;
import com.jianqiaoguoye.infra.mapper.OrderMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单头 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Component
public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List list(Order order) {
        return orderMapper.list(order);
    }
}
