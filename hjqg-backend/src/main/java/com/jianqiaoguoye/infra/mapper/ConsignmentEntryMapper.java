package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.ConsignmentEntry;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 配货单行Mapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ConsignmentEntryMapper extends BaseMapper<ConsignmentEntry> {

    /**
     * 根据配货单ID查询行列表
     *
     * @param consignmentId ID
     * @return 行列表
     */
    List<ConsignmentEntry> listByConsignmentId(@Param("consignmentId") Long consignmentId);
}
