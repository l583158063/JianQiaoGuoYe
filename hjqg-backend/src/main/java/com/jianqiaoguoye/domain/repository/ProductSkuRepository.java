package com.jianqiaoguoye.domain.repository;

import com.jianqiaoguoye.domain.entity.ProductSku;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 商品sku资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
public interface ProductSkuRepository extends BaseRepository<ProductSku> {

    /**
     * 列表查询
     *
     * @param productSku 查询条件
     * @return 查询结果列表
     */
    List<ProductSku> list(ProductSku productSku);

    /**
     * 响应提交
     *
     * @param productSkuList 接收提交数据
     */
    void submit(List<ProductSku> productSkuList);
}
