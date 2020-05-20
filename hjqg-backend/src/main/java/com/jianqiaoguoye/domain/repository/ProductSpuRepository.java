package com.jianqiaoguoye.domain.repository;

import com.jianqiaoguoye.domain.entity.ProductSpu;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 商品spu资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
public interface ProductSpuRepository extends BaseRepository<ProductSpu> {


    /**
     * 响应提交
     *
     * @param productSpuList 接收提交数据
     */
    void submit(List<ProductSpu> productSpuList);

    /**
     * 列表查询
     *
     * @param productSpu 查询条件
     * @return 查询结果列表
     */
    List<ProductSpu> list(ProductSpu productSpu);
}
