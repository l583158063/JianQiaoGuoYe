package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.ProductCategory;
import com.jianqiaoguoye.domain.repository.ProductCategoryRepository;
import com.jianqiaoguoye.infra.mapper.ProductCategoryMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品类型 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Component
public class ProductCategoryRepositoryImpl extends BaseRepositoryImpl<ProductCategory> implements ProductCategoryRepository {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public void submit(List<ProductCategory> productCategoryList) {
        CommonRepositoryImpl.handleSubmit(this, productCategoryList);
    }

    @Override
    public List<ProductCategory> queryCategorySkus(ProductCategory productCategory) {
        return productCategoryMapper.queryCategorySkus(productCategory);
    }
}
