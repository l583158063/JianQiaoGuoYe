package com.jianqiaoguoye.api.controller.v1;

import com.alibaba.fastjson.JSON;
import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.ProductAttributeSku;
import com.jianqiaoguoye.domain.repository.ProductAttributeSkuRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 商品SKU属性 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Slf4j
@Api(tags = SwaggerTags.PRODUCT_ATTRIBUTE_SKU)
@RestController("productAttributeSkuController.v1")
@RequestMapping("/v1/product-attribute-skus")
public class ProductAttributeSkuController extends BaseController {

    @Autowired
    private ProductAttributeSkuRepository productAttributeSkuRepository;

    @ApiOperation(value = "商品SKU属性列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(ProductAttributeSku productAttributeSku, @ApiIgnore @SortDefault(value = ProductAttributeSku.FIELD_ATTRIBUTE_SKU_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ProductAttributeSku> list = productAttributeSkuRepository.pageAndSort(pageRequest, productAttributeSku);
        return Results.success(list);
    }

    @ApiOperation(value = "商品SKU属性明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{attributeSkuId}")
    public ResponseEntity<?> detail(@PathVariable Long attributeSkuId) {
        ProductAttributeSku productAttributeSku = productAttributeSkuRepository.selectByPrimaryKey(attributeSkuId);
        return Results.success(productAttributeSku);
    }

    @ApiOperation(value = "创建商品SKU属性")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductAttributeSku productAttributeSku) {
        productAttributeSkuRepository.insertSelective(productAttributeSku);
        return Results.success(productAttributeSku);
    }

    @ApiOperation(value = "修改商品SKU属性")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductAttributeSku productAttributeSku) {
        SecurityTokenHelper.validToken(productAttributeSku);
        productAttributeSkuRepository.updateByPrimaryKeySelective(productAttributeSku);
        return Results.success(productAttributeSku);
    }

    @ApiOperation(value = "删除商品SKU属性")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ProductAttributeSku productAttributeSku) {
        SecurityTokenHelper.validToken(productAttributeSku);
        productAttributeSkuRepository.deleteByPrimaryKey(productAttributeSku);
        return Results.success();
    }

    @ApiOperation(value = "响应提交")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody List<ProductAttributeSku> productAttributeSkuList) {
        if (log.isDebugEnabled()) {
            log.debug(JSON.toJSONString(productAttributeSkuList));
        }
        productAttributeSkuRepository.submit(productAttributeSkuList);
        return Results.success();
    }

}
