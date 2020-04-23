package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.ProductSku;
import com.jianqiaoguoye.domain.repository.ProductSkuRepository;
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
 * 商品sku 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
@RestController("productSkuController.v1")
@RequestMapping("/v1/product-skus")
public class ProductSkuController extends BaseController {

    @Autowired
    private ProductSkuRepository productSkuRepository;

    @ApiOperation(value = "商品sku列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(ProductSku productSku, @ApiIgnore @SortDefault(value = ProductSku.FIELD_PRODUCT_SKU_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ProductSku> list = productSkuRepository.pageAndSort(pageRequest, productSku);
        return Results.success(list);
    }

    @ApiOperation(value = "商品sku明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{productSkuId}")
    public ResponseEntity<?> detail(@PathVariable Long productSkuId) {
        ProductSku productSku = productSkuRepository.selectByPrimaryKey(productSkuId);
        return Results.success(productSku);
    }

    @ApiOperation(value = "创建商品sku")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductSku productSku) {
        productSkuRepository.insertSelective(productSku);
        return Results.success(productSku);
    }

    @ApiOperation(value = "修改商品sku")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductSku productSku) {
        SecurityTokenHelper.validToken(productSku);
        productSkuRepository.updateByPrimaryKeySelective(productSku);
        return Results.success(productSku);
    }

    @ApiOperation(value = "删除商品sku")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ProductSku productSku) {
        SecurityTokenHelper.validToken(productSku);
        productSkuRepository.deleteByPrimaryKey(productSku);
        return Results.success();
    }

}
