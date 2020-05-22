package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.ProductAttributeSpu;
import com.jianqiaoguoye.domain.repository.ProductAttributeSpuRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品SPU属性 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Component
public class ProductAttributeSpuRepositoryImpl extends BaseRepositoryImpl<ProductAttributeSpu> implements ProductAttributeSpuRepository {

    @Override
    public void submit(List<ProductAttributeSpu> productAttributeSpuList) {
        CommonRepositoryImpl.handleSubmit(this, productAttributeSpuList);
    }
}
