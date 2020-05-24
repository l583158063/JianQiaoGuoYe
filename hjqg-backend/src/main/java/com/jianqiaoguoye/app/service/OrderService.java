package com.jianqiaoguoye.app.service;

import com.jianqiaoguoye.domain.entity.Order;

import java.util.List;

/**
 * 订单头应用服务
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
public interface OrderService {

    /**
     * 列表查询
     *
     * @param order 查询条件
     * @return 查询结果列表
     */
    List<Order> list(Order order);

    /**
     * 确认订单并生成配货单
     *
     * @param orderId 订单ID
     * @return 配货单号
     */
    String confirmOrder(Long orderId);
}
