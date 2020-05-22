package com.jianqiaoguoye.api.controller.v1;

import com.alibaba.fastjson.JSON;
import com.jianqiaoguoye.app.service.ProductSpuService;
import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.ProductSpu;
import com.jianqiaoguoye.domain.repository.ProductAttributeSpuRepository;
import com.jianqiaoguoye.domain.repository.ProductSpuRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.base.BaseConstants;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 商品spu 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Slf4j
@Api(tags = SwaggerTags.PRODUCT_SPU)
@RestController("productSpuController.v1")
@RequestMapping("/v1/product-spus")
public class ProductSpuController extends BaseController {

    @Autowired
    private ProductSpuRepository productSpuRepository;
    @Autowired
    private ProductSpuService productSpuService;
    @Autowired
    private ProductAttributeSpuRepository productAttributeSpuRepository;

    @ApiOperation(value = "商品spu列表")
    @Permission(level = ResourceLevel.SITE)
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    @GetMapping
    public ResponseEntity<?> list(ProductSpu productSpu, @ApiIgnore @SortDefault(value = ProductSpu.FIELD_ORDER_SEQ,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ProductSpu> list = PageHelper.doPageAndSort(pageRequest, () -> productSpuService.list(productSpu));
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

    @ApiOperation(value = "响应提交")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody List<ProductSpu> productSpuList) {
        if (log.isDebugEnabled()) {
            log.debug(JSON.toJSONString(productSpuList));
        }
        productSpuRepository.submit(productSpuList);
        return Results.success();
    }

    @ApiOperation(value = "商品上下架, isOnShelf = 1 为上架")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/on-shelf")
    public ResponseEntity<?> onShelf(@RequestBody List<ProductSpu> productSpuList,
                                     @RequestParam Integer isOnShelf) {
        if (log.isDebugEnabled()) {
            log.debug(JSON.toJSONString(productSpuList));
            log.debug("isOnShelf: {}", isOnShelf);
        }
        productSpuService.onShelf(productSpuList, isOnShelf);
        return Results.success();
    }
}
