package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.OrderEntry;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单行Mapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
public interface OrderEntryMapper extends BaseMapper<OrderEntry> {

    /**
     * 查询订单行列表
     *
     * @param orderEntry 查询条件
     * @return 订单行列表
     */
    List<OrderEntry> list(@Param("orderEntry") OrderEntry orderEntry);

    /**
     * 查询订单行列表
     *
     * @param orderId 查询条件
     * @return 订单行列表
     */
    List<OrderEntry> listByOrderId(@Param("orderId") Long orderId);
}
