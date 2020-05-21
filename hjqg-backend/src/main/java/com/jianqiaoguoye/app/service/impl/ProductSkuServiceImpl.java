package com.jianqiaoguoye.app.service.impl;

import com.jianqiaoguoye.app.service.ProductSkuService;
import com.jianqiaoguoye.domain.entity.ProductSku;
import com.jianqiaoguoye.domain.repository.ProductSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 商品sku应用服务默认实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
@Service
public class ProductSkuServiceImpl implements ProductSkuService {

    @Autowired
    private ProductSkuRepository productSkuRepository;

    @Override
    public List<ProductSku> list(ProductSku productSku) {
        productSku = (Objects.isNull(productSku)) ? new ProductSku() : productSku;
        return productSkuRepository.list(productSku);
    }
}
