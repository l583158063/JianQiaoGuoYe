package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.MetadataCountry;
import com.jianqiaoguoye.domain.repository.MetadataCountryRepository;
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
 * 国家定义 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@RestController("metadataCountryController.v1")
@RequestMapping("/v1/metadata-countrys")
public class MetadataCountryController extends BaseController {

    @Autowired
    private MetadataCountryRepository metadataCountryRepository;

    @ApiOperation(value = "国家定义列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(MetadataCountry metadataCountry, @ApiIgnore @SortDefault(value = MetadataCountry.FIELD_COUNTRY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<MetadataCountry> list = metadataCountryRepository.pageAndSort(pageRequest, metadataCountry);
        return Results.success(list);
    }

    @ApiOperation(value = "国家定义明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{countryId}")
    public ResponseEntity<?> detail(@PathVariable Long countryId) {
        MetadataCountry metadataCountry = metadataCountryRepository.selectByPrimaryKey(countryId);
        return Results.success(metadataCountry);
    }

    @ApiOperation(value = "创建国家定义")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody MetadataCountry metadataCountry) {
        metadataCountryRepository.insertSelective(metadataCountry);
        return Results.success(metadataCountry);
    }

    @ApiOperation(value = "修改国家定义")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MetadataCountry metadataCountry) {
        SecurityTokenHelper.validToken(metadataCountry);
        metadataCountryRepository.updateByPrimaryKeySelective(metadataCountry);
        return Results.success(metadataCountry);
    }

    @ApiOperation(value = "删除国家定义")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody MetadataCountry metadataCountry) {
        SecurityTokenHelper.validToken(metadataCountry);
        metadataCountryRepository.deleteByPrimaryKey(metadataCountry);
        return Results.success();
    }

}
