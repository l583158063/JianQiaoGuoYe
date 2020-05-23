package com.jianqiaoguoye.app.service.impl;

import com.jianqiaoguoye.app.service.ProductSkuService;
import com.jianqiaoguoye.domain.entity.ProductSku;
import com.jianqiaoguoye.domain.repository.ProductSkuRepository;
import com.jianqiaoguoye.infra.util.StringConstant;
import io.choerodon.core.oauth.DetailsHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hzero.boot.file.FileClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * 商品sku应用服务默认实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
@Slf4j
@Service
public class ProductSkuServiceImpl implements ProductSkuService {

    @Autowired
    private ProductSkuRepository productSkuRepository;
    @Autowired
    private FileClient fileClient;

    @Override
    public List<ProductSku> list(ProductSku productSku) {
        productSku = (Objects.isNull(productSku)) ? new ProductSku() : productSku;
        return productSkuRepository.list(productSku);
    }

    @Override
    public String uploadImage(MultipartFile image, Long productSkuId) {
        ProductSku productSku = productSkuRepository.selectByPrimaryKey(productSkuId);

        String originalFilename = image.getOriginalFilename();
        Assert.isTrue(StringUtils.isNotBlank(originalFilename), "文件不存在");

        Long organizationId = DetailsHelper.getUserDetails().getTenantId();

        String responseUrl;
        try {
            responseUrl = fileClient.uploadFile(organizationId, StringConstant.Product.ImageFile.BUCKET,
                    productSkuId.toString(), fileName(productSku), image.getBytes());
        } catch (IOException e) {
            log.error("文件上传出错: ", e);
            return null;
        }
        responseUrl = responseUrl.replace("localhost", "dev.hzero.org");
        productSku.setImageUrl(responseUrl);
        productSkuRepository.updateByPrimaryKeySelective(productSku);

        return responseUrl;
    }

    private String fileName(ProductSku productSku) {
        return productSku.getProductSkuId() + "-" + productSku.getProductSkuCode();
    }
}
