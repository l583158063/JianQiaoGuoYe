package com.jianqiaoguoye.domain.repository;

import com.jianqiaoguoye.domain.entity.ProductAttributeSku;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 商品SKU属性资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ProductAttributeSkuRepository extends BaseRepository<ProductAttributeSku> {

    /**
     * 响应提交
     *
     * @param productAttributeSkuList 提交数据
     */
    void submit(List<ProductAttributeSku> productAttributeSkuList);
}
