package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.ProductSpu;
import com.jianqiaoguoye.domain.repository.ProductSpuRepository;
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
 * 商品spu 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@RestController("productSpuController.v1")
@RequestMapping("/v1/product-spus")
public class ProductSpuController extends BaseController {

    @Autowired
    private ProductSpuRepository productSpuRepository;

    @ApiOperation(value = "商品spu列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(ProductSpu productSpu, @ApiIgnore @SortDefault(value = ProductSpu.FIELD_PRODUCT_SPU_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ProductSpu> list = productSpuRepository.pageAndSort(pageRequest, productSpu);
        return Results.success(list);
    }

    @ApiOperation(value = "商品spu明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{productSpuId}")
    public ResponseEntity<?> detail(@PathVariable Long productSpuId) {
        ProductSpu productSpu = productSpuRepository.selectByPrimaryKey(productSpuId);
        return Results.success(productSpu);
    }

    @ApiOperation(value = "创建商品spu")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductSpu productSpu) {
        productSpuRepository.insertSelective(productSpu);
        return Results.success(productSpu);
    }

    @ApiOperation(value = "修改商品spu")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductSpu productSpu) {
        SecurityTokenHelper.validToken(productSpu);
        productSpuRepository.updateByPrimaryKeySelective(productSpu);
        return Results.success(productSpu);
    }

    @ApiOperation(value = "删除商品spu")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ProductSpu productSpu) {
        SecurityTokenHelper.validToken(productSpu);
        productSpuRepository.deleteByPrimaryKey(productSpu);
        return Results.success();
    }

}
