package com.jianqiaoguoye.domain.repository;

import com.jianqiaoguoye.domain.entity.OrderEntry;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 订单行资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
public interface OrderEntryRepository extends BaseRepository<OrderEntry> {

    /**
     * 查询订单行列表
     *
     * @param orderEntry 查询条件
     * @return 订单行列表
     */
    List<OrderEntry> list(OrderEntry orderEntry);

    /**
     * 查询订单行列表
     *
     * @param orderId 查询条件
     * @return 订单行列表
     */
    List<OrderEntry> listByOrderId(Long orderId);
}
