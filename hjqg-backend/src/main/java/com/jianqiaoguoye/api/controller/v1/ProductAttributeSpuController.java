package com.jianqiaoguoye.api.controller.v1;

import com.alibaba.fastjson.JSON;
import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.ProductAttributeSpu;
import com.jianqiaoguoye.domain.repository.ProductAttributeSpuRepository;
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
 * 商品SPU属性 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Slf4j
@Api(tags = SwaggerTags.PRODUCT_ATTRIBUTE_SPU)
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

    @ApiOperation(value = "响应提交")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody List<ProductAttributeSpu> productAttributeSpuList) {
        if (log.isDebugEnabled()) {
            log.debug(JSON.toJSONString(productAttributeSpuList));
        }
        productAttributeSpuRepository.submit(productAttributeSpuList);
        return Results.success();
    }

}
