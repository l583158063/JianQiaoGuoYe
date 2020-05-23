package com.jianqiaoguoye.domain.repository;

import com.jianqiaoguoye.domain.entity.Order;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 订单头资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
public interface OrderRepository extends BaseRepository<Order> {

    /**
     * 列表查询
     *
     * @param order 查询条件
     * @return 查询结果列表
     */
    List list(Order order);
}
