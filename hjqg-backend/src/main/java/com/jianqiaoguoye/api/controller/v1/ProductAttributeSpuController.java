package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.ProductAttributeSpu;
import com.jianqiaoguoye.domain.repository.ProductAttributeSpuRepository;
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
 * 商品SPU属性 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@RestController("productAttributeSpuController.v1")
@RequestMapping("/v1/product-attribute-spus")
public class ProductAttributeSpuController extends BaseController {

    @Autowired
    private ProductAttributeSpuRepository productAttributeSpuRepository;

    @ApiOperation(value = "商品SPU属性列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(ProductAttributeSpu productAttributeSpu, @ApiIgnore @SortDefault(value = ProductAttributeSpu.FIELD_ATTRIBUTE_SPU_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ProductAttributeSpu> list = productAttributeSpuRepository.pageAndSort(pageRequest, productAttributeSpu);
        return Results.success(list);
    }

    @ApiOperation(value = "商品SPU属性明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{attributeSpuId}")
    public ResponseEntity<?> detail(@PathVariable Long attributeSpuId) {
        ProductAttributeSpu productAttributeSpu = productAttributeSpuRepository.selectByPrimaryKey(attributeSpuId);
        return Results.success(productAttributeSpu);
    }

    @ApiOperation(value = "创建商品SPU属性")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductAttributeSpu productAttributeSpu) {
        productAttributeSpuRepository.insertSelective(productAttributeSpu);
        return Results.success(productAttributeSpu);
    }

    @ApiOperation(value = "修改商品SPU属性")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductAttributeSpu productAttributeSpu) {
        SecurityTokenHelper.validToken(productAttributeSpu);
        productAttributeSpuRepository.updateByPrimaryKeySelective(productAttributeSpu);
        return Results.success(productAttributeSpu);
    }

    @ApiOperation(value = "删除商品SPU属性")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ProductAttributeSpu productAttributeSpu) {
        SecurityTokenHelper.validToken(productAttributeSpu);
        productAttributeSpuRepository.deleteByPrimaryKey(productAttributeSpu);
        return Results.success();
    }

}
