package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.OrderEntry;
import com.jianqiaoguoye.domain.repository.OrderEntryRepository;
import com.jianqiaoguoye.infra.mapper.OrderEntryMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单行 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Component
public class OrderEntryRepositoryImpl extends BaseRepositoryImpl<OrderEntry> implements OrderEntryRepository {

    @Autowired
    private OrderEntryMapper orderEntryMapper;

    /**
     * 查询订单行列表
     *
     * @param orderEntry 查询条件
     * @return 订单行列表
     */
    @Override
    public List<OrderEntry> list(OrderEntry orderEntry) {
        return orderEntryMapper.list(orderEntry);
    }

    /**
     * 查询订单行列表
     *
     * @param orderId 查询条件
     * @return 订单行列表
     */
    @Override
    public List<OrderEntry> listByOrderId(Long orderId) {
        return orderEntryMapper.listByOrderId(orderId);
    }
}
