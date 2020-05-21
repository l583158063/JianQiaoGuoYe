package com.jianqiaoguoye.app.service.impl;

import com.jianqiaoguoye.app.service.ProductSpuService;
import com.jianqiaoguoye.domain.entity.ProductSpu;
import com.jianqiaoguoye.domain.repository.ProductSpuRepository;
import com.jianqiaoguoye.infra.util.StringConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 商品spu应用服务默认实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Service
public class ProductSpuServiceImpl implements ProductSpuService {

    @Autowired
    private ProductSpuRepository productSpuRepository;

    @Override
    public List<ProductSpu> list(ProductSpu productSpu) {
        productSpu = (Objects.isNull(productSpu)) ? new ProductSpu() : productSpu;
        return productSpuRepository.list(productSpu);
    }

    @Override
    public void onShelf(List<ProductSpu> productSpuList, Integer isOnShelf) {
        switch (isOnShelf) {
            // 商品上架
            case 1:
                productSpuList.forEach(productSpu -> {
                    productSpu.setShelfStatus(StringConstant.Product.ShelfStatus.ON);
                    productSpu.setOnlineDate(LocalDateTime.now());
                });
                break;
            // 商品下架
            case 0:
                productSpuList.forEach(productSpu -> {
                    productSpu.setShelfStatus(StringConstant.Product.ShelfStatus.OFF);
                    productSpu.setOfflineDate(LocalDateTime.now());
                });
                break;
            default:
                break;
        }
        productSpuRepository.batchUpdateByPrimaryKeySelective(productSpuList);
    }
}
