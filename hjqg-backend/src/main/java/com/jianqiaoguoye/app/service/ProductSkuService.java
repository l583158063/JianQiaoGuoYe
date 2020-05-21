package com.jianqiaoguoye.app.service;

import com.jianqiaoguoye.domain.entity.ProductSku;

import java.util.List;

/**
 * 商品sku应用服务
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
public interface ProductSkuService {

    /**
     * 列表查询
     *
     * @param productSku 查询条件
     * @return 查询结果列表
     */
    List<ProductSku> list(ProductSku productSku);
}
