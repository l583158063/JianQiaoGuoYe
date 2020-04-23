package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.MetadataCarrier;
import com.jianqiaoguoye.domain.repository.MetadataCarrierRepository;
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
 * 承运商定义 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
@RestController("metadataCarrierController.v1")
@RequestMapping("/v1/metadata-carriers")
public class MetadataCarrierController extends BaseController {

    @Autowired
    private MetadataCarrierRepository metadataCarrierRepository;

    @ApiOperation(value = "承运商定义列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(MetadataCarrier metadataCarrier, @ApiIgnore @SortDefault(value = MetadataCarrier.FIELD_CARRIER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<MetadataCarrier> list = metadataCarrierRepository.pageAndSort(pageRequest, metadataCarrier);
        return Results.success(list);
    }

    @ApiOperation(value = "承运商定义明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{carrierId}")
    public ResponseEntity<?> detail(@PathVariable Long carrierId) {
        MetadataCarrier metadataCarrier = metadataCarrierRepository.selectByPrimaryKey(carrierId);
        return Results.success(metadataCarrier);
    }

    @ApiOperation(value = "创建承运商定义")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody MetadataCarrier metadataCarrier) {
        metadataCarrierRepository.insertSelective(metadataCarrier);
        return Results.success(metadataCarrier);
    }

    @ApiOperation(value = "修改承运商定义")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MetadataCarrier metadataCarrier) {
        SecurityTokenHelper.validToken(metadataCarrier);
        metadataCarrierRepository.updateByPrimaryKeySelective(metadataCarrier);
        return Results.success(metadataCarrier);
    }

    @ApiOperation(value = "删除承运商定义")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody MetadataCarrier metadataCarrier) {
        SecurityTokenHelper.validToken(metadataCarrier);
        metadataCarrierRepository.deleteByPrimaryKey(metadataCarrier);
        return Results.success();
    }

}
