package com.jianqiaoguoye.domain.repository;

import com.jianqiaoguoye.domain.entity.ProductCategory;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 商品类型资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ProductCategoryRepository extends BaseRepository<ProductCategory> {

    /**
     * @param productCategoryList 接收提交数据
     */
    void submit(List<ProductCategory> productCategoryList);
}
