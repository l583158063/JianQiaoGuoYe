package com.jianqiaoguoye.domain.repository;

import com.jianqiaoguoye.domain.entity.Consignment;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 配货单资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ConsignmentRepository extends BaseRepository<Consignment> {

    /**
     * 列表查询
     *
     * @param consignment 查询条件
     * @return 查询结果
     */
    List<Consignment> list(Consignment consignment);
}
