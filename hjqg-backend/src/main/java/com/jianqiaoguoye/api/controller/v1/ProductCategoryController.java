package com.jianqiaoguoye.api.controller.v1;

import com.alibaba.fastjson.JSON;
import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.ProductCategory;
import com.jianqiaoguoye.domain.repository.ProductCategoryRepository;
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
 * 商品类型 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Slf4j
@Api(tags = SwaggerTags.PRODUCT_CATEGORY)
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

    @ApiOperation(value = "响应提交")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody List<ProductCategory> productCategoryList) {
        if (log.isDebugEnabled()) {
            log.debug(JSON.toJSONString(productCategoryList));
        }
        productCategoryRepository.submit(productCategoryList);
        return Results.success();
    }

    @ApiOperation(value = "查询商品类型下的sku（商城）")
    @Permission(permissionPublic = true)
    @GetMapping("/query-category-skus")
    public ResponseEntity<?> queryCategorySkus(ProductCategory productCategory) {
        List<ProductCategory> productCategoryList = productCategoryRepository.queryCategorySkus(productCategory);
        return Results.success(productCategoryList);
    }

}
