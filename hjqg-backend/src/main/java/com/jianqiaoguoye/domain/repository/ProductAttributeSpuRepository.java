package com.jianqiaoguoye.domain.repository;

import com.jianqiaoguoye.domain.entity.ProductAttributeSpu;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 商品SPU属性资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface ProductAttributeSpuRepository extends BaseRepository<ProductAttributeSpu> {

    /**
     * 响应提交
     *
     * @param productAttributeSpuList 提交数据
     */
    void submit(List<ProductAttributeSpu> productAttributeSpuList);
}
