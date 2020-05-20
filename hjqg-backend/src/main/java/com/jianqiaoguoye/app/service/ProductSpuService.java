package com.jianqiaoguoye.app.service;

import com.jianqiaoguoye.domain.entity.ProductSpu;

import java.util.List;

/**
 * 商品spu应用服务
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
public interface ProductSpuService {

    /**
     * 列表查询
     *
     * @param productSpu 查询条件
     * @return 查询结果列表
     */
    List<ProductSpu> list(ProductSpu productSpu);

    /**
     * 上下架处理
     *
     * @param productSpuList 只含 id 的对象集合
     * @param isOnShelf      为 1 上架，为 0 下架
     */
    void onShelf(List<ProductSpu> productSpuList, Integer isOnShelf);
}
