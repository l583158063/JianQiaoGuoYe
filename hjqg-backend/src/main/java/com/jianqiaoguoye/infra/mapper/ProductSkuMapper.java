package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.ProductSku;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品skuMapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
public interface ProductSkuMapper extends BaseMapper<ProductSku> {

    /**
     * 列表查询
     *
     * @param productSku 查询条件
     * @return 查询结果列表
     */
    List<ProductSku> list(@Param("productSku") ProductSku productSku);
}
