package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.ProductCategory;
import com.jianqiaoguoye.domain.repository.ProductCategoryRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品类型 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Component
public class ProductCategoryRepositoryImpl extends BaseRepositoryImpl<ProductCategory> implements ProductCategoryRepository {


    @Override
    public void submit(List<ProductCategory> productCategoryList) {
        List<ProductCategory> createList = new ArrayList<>();
        List<ProductCategory> deleteList = new ArrayList<>();
        List<ProductCategory> updateList = new ArrayList<>();
        for (ProductCategory category : productCategoryList) {
            switch (category.get_status()) {
                case create:
                    createList.add(category);
                    break;
                case delete:
                    deleteList.add(category);
                    break;
                case update:
                    updateList.add(category);
                    break;
                default:
                    break;
            }
        }
        if (CollectionUtils.isNotEmpty(createList)) {
            this.batchInsertSelective(createList);
        }
        if (CollectionUtils.isNotEmpty(deleteList)) {
            this.batchDeleteByPrimaryKey(deleteList);
        }
        if (CollectionUtils.isNotEmpty(updateList)) {
            this.batchUpdateByPrimaryKeySelective(updateList);
        }
    }
}
