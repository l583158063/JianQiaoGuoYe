package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.ProductCategory;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品类型Mapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    /**
     * 查询商品类型对应sku
     *
     * @param productCategory 商品类型
     * @return sku列表
     */
    List<ProductCategory> queryCategorySkus(@Param("productCategory") ProductCategory productCategory);
}
