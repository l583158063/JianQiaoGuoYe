package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.Consignment;
import com.jianqiaoguoye.domain.repository.ConsignmentRepository;
import com.jianqiaoguoye.infra.mapper.ConsignmentMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 配货单 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Component
public class ConsignmentRepositoryImpl extends BaseRepositoryImpl<Consignment> implements ConsignmentRepository {

    @Autowired
    private ConsignmentMapper consignmentMapper;

    @Override
    public List<Consignment> list(Consignment consignment) {
        return consignmentMapper.list(consignment);
    }
}
