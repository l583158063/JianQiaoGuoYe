package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.Consignment;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 配货单Mapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ConsignmentMapper extends BaseMapper<Consignment> {

    /**
     * 列表查询
     *
     * @param consignment 查询条件
     * @return 查询结果
     */
    List<Consignment> list(@Param("consignment") Consignment consignment);
}
