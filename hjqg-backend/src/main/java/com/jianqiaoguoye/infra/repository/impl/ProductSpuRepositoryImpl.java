package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.ProductSpu;
import com.jianqiaoguoye.domain.repository.ProductSpuRepository;
import com.jianqiaoguoye.infra.mapper.ProductSpuMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品spu 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Component
public class ProductSpuRepositoryImpl extends BaseRepositoryImpl<ProductSpu> implements ProductSpuRepository {

    @Autowired
    private ProductSpuMapper productSpuMapper;

    @Override
    public void submit(List<ProductSpu> productSpuList) {
        CommonRepositoryImpl.handleSubmit(this, productSpuList);
    }

    @Override
    public List<ProductSpu> list(ProductSpu productSpu) {
        return productSpuMapper.list(productSpu);
    }

}
