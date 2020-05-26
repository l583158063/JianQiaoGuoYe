package com.jianqiaoguoye.app.service;

import com.jianqiaoguoye.api.dto.OrderCreateDTO;
import com.jianqiaoguoye.domain.entity.Order;
import org.springframework.http.ResponseEntity;

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

    /**
     * 商城创建订单
     *
     * @param orderCreateDTO 订单数据
     * @return 响应结果
     */
    ResponseEntity<?> createOrder(OrderCreateDTO orderCreateDTO);

    /**
     * 商城查询个人订单列表
     *
     * @param customerId 会员ID
     * @return 订单列表
     */
    List<Order> queryOrderList(Long customerId);

}
