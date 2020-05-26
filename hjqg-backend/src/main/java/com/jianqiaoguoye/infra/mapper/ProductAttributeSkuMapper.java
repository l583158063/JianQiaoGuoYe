package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.ProductAttributeSku;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品SKU属性Mapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ProductAttributeSkuMapper extends BaseMapper<ProductAttributeSku> {

    List<ProductAttributeSku> listBySkuId(@Param("productSkuId") Long productSkuId);
}
