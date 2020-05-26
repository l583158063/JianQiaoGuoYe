package com.jianqiaoguoye.app.service;

import com.jianqiaoguoye.domain.entity.ProductSku;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 商品sku应用服务
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
public interface ProductSkuService {

    /**
     * 列表查询
     *
     * @param productSku 查询条件
     * @return 查询结果列表
     */
    List<ProductSku> list(ProductSku productSku);

    /**
     * 上传商品图片
     *
     * @param image        图片
     * @param productSkuId skuId
     * @return url
     */
    String uploadImage(MultipartFile image, Long productSkuId);

    /**
     * 商城查询所有sku
     *
     * @param productSku 条件
     * @return sku列表
     */
    List<ProductSku> queryForMall(ProductSku productSku);
}
