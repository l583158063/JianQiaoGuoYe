package com.jianqiaoguoye.app.service;

import com.jianqiaoguoye.domain.entity.Consignment;

import java.util.List;

/**
 * 配货单应用服务
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ConsignmentService {

    /**
     * 列表查询
     *
     * @param consignment 查询条件
     * @return 查询结果
     */
    List<Consignment> list(Consignment consignment);

    /**
     * 操作处理
     *
     * @param consignment 更新数据
     */
    void handleOperation(Consignment consignment);

    /**
     * 自提处理
     *
     * @param consignment 数据
     */
    void handlePickup(Consignment consignment);
}
