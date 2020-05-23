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
    List list(Order order);
}
