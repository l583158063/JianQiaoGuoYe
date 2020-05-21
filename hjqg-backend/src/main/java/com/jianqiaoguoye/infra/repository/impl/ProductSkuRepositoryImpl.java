package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.ProductSku;
import com.jianqiaoguoye.domain.repository.ProductSkuRepository;
import com.jianqiaoguoye.infra.mapper.ProductSkuMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品sku 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
@Component
public class ProductSkuRepositoryImpl extends BaseRepositoryImpl<ProductSku> implements ProductSkuRepository {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public List<ProductSku> list(ProductSku productSku) {
        return productSkuMapper.list(productSku);
    }

    @Override
    public void submit(List<ProductSku> productSkuList) {
        CommonRepositoryImpl.handleSubmit(this, productSkuList);
    }
}
