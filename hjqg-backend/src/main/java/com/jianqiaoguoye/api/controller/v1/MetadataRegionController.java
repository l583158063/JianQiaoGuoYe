package com.jianqiaoguoye.api.controller.v1;

import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.MetadataRegion;
import com.jianqiaoguoye.domain.repository.MetadataRegionRepository;
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
 * 地区定义 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Api(tags = SwaggerTags.METADATA_REGION)
@RestController("metadataRegionController.v1")
@RequestMapping("/v1/metadata-regions")
public class MetadataRegionController extends BaseController {

    @Autowired
    private MetadataRegionRepository metadataRegionRepository;

    @ApiOperation(value = "地区定义列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(MetadataRegion metadataRegion, @ApiIgnore @SortDefault(value = MetadataRegion.FIELD_REGION_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<MetadataRegion> list = metadataRegionRepository.pageAndSort(pageRequest, metadataRegion);
        return Results.success(list);
    }

    @ApiOperation(value = "地区定义明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{regionId}")
    public ResponseEntity<?> detail(@PathVariable Long regionId) {
        MetadataRegion metadataRegion = metadataRegionRepository.selectByPrimaryKey(regionId);
        return Results.success(metadataRegion);
    }

    @ApiOperation(value = "创建地区定义")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody MetadataRegion metadataRegion) {
        metadataRegionRepository.insertSelective(metadataRegion);
        return Results.success(metadataRegion);
    }

    @ApiOperation(value = "修改地区定义")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MetadataRegion metadataRegion) {
        SecurityTokenHelper.validToken(metadataRegion);
        metadataRegionRepository.updateByPrimaryKeySelective(metadataRegion);
        return Results.success(metadataRegion);
    }

    @ApiOperation(value = "删除地区定义")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody MetadataRegion metadataRegion) {
        SecurityTokenHelper.validToken(metadataRegion);
        metadataRegionRepository.deleteByPrimaryKey(metadataRegion);
        return Results.success();
    }

}
