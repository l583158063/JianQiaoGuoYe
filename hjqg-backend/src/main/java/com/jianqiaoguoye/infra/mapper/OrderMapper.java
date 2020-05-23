package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.Order;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单头Mapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 列表查询
     *
     * @param order 查询条件
     * @return 查询结果列表
     */
    List<Order> list(@Param("order") Order order);
}
