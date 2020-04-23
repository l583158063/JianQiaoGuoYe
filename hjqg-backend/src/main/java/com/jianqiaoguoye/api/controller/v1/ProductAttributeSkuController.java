package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.ProductAttributeSku;
import com.jianqiaoguoye.domain.repository.ProductAttributeSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 商品SKU属性 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
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

}
