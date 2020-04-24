package com.jianqiaoguoye.api.controller.v1;

import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.ProductSkuPrice;
import com.jianqiaoguoye.domain.repository.ProductSkuPriceRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

/**
 * 价格表 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Api(tags = SwaggerTags.PRODUCT_SKU_PRICE)
@RestController("productSkuPriceController.v1")
@RequestMapping("/v1/product-sku-prices")
public class ProductSkuPriceController extends BaseController {

    @Autowired
    private ProductSkuPriceRepository productSkuPriceRepository;

    @ApiOperation(value = "价格表列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(ProductSkuPrice productSkuPrice, @ApiIgnore @SortDefault(value = ProductSkuPrice.FIELD_PRICE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ProductSkuPrice> list = productSkuPriceRepository.pageAndSort(pageRequest, productSkuPrice);
        return Results.success(list);
    }

    @ApiOperation(value = "价格表明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{priceId}")
    public ResponseEntity<?> detail(@PathVariable Long priceId) {
        ProductSkuPrice productSkuPrice = productSkuPriceRepository.selectByPrimaryKey(priceId);
        return Results.success(productSkuPrice);
    }

    @ApiOperation(value = "创建价格表")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductSkuPrice productSkuPrice) {
        productSkuPriceRepository.insertSelective(productSkuPrice);
        return Results.success(productSkuPrice);
    }

    @ApiOperation(value = "修改价格表")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductSkuPrice productSkuPrice) {
        SecurityTokenHelper.validToken(productSkuPrice);
        productSkuPriceRepository.updateByPrimaryKeySelective(productSkuPrice);
        return Results.success(productSkuPrice);
    }

    @ApiOperation(value = "删除价格表")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ProductSkuPrice productSkuPrice) {
        SecurityTokenHelper.validToken(productSkuPrice);
        productSkuPriceRepository.deleteByPrimaryKey(productSkuPrice);
        return Results.success();
    }

}
