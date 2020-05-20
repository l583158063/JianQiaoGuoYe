package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.ProductSpu;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品spuMapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
public interface ProductSpuMapper extends BaseMapper<ProductSpu> {

    /**
     * 列表查询
     *
     * @param productSpu 查询条件
     * @return 查询结果列表
     */
    List<ProductSpu> list(@Param("productSpu") ProductSpu productSpu);
}
