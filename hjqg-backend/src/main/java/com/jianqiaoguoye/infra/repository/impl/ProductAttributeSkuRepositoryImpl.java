package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.ProductAttributeSku;
import com.jianqiaoguoye.domain.repository.ProductAttributeSkuRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品SKU属性 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Component
public class ProductAttributeSkuRepositoryImpl extends BaseRepositoryImpl<ProductAttributeSku> implements ProductAttributeSkuRepository {

    @Override
    public void submit(List<ProductAttributeSku> productAttributeSkuList) {
        CommonRepositoryImpl.handleSubmit(this, productAttributeSkuList);
    }
}
