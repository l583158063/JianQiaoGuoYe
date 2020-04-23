package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.ProductCategory;
import com.jianqiaoguoye.domain.repository.ProductCategoryRepository;
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
 * 商品类型 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@RestController("productCategoryController.v1")
@RequestMapping("/v1/product-categorys")
public class ProductCategoryController extends BaseController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @ApiOperation(value = "商品类型列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(ProductCategory productCategory, @ApiIgnore @SortDefault(value = ProductCategory.FIELD_CATEGORY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ProductCategory> list = productCategoryRepository.pageAndSort(pageRequest, productCategory);
        return Results.success(list);
    }

    @ApiOperation(value = "商品类型明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{categoryId}")
    public ResponseEntity<?> detail(@PathVariable Long categoryId) {
        ProductCategory productCategory = productCategoryRepository.selectByPrimaryKey(categoryId);
        return Results.success(productCategory);
    }

    @ApiOperation(value = "创建商品类型")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductCategory productCategory) {
        productCategoryRepository.insertSelective(productCategory);
        return Results.success(productCategory);
    }

    @ApiOperation(value = "修改商品类型")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductCategory productCategory) {
        SecurityTokenHelper.validToken(productCategory);
        productCategoryRepository.updateByPrimaryKeySelective(productCategory);
        return Results.success(productCategory);
    }

    @ApiOperation(value = "删除商品类型")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ProductCategory productCategory) {
        SecurityTokenHelper.validToken(productCategory);
        productCategoryRepository.deleteByPrimaryKey(productCategory);
        return Results.success();
    }

}
