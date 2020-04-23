package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.ConsignmentEntry;
import com.jianqiaoguoye.domain.repository.ConsignmentEntryRepository;
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
 * 配货单行 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@RestController("consignmentEntryController.v1")
@RequestMapping("/v1/consignment-entrys")
public class ConsignmentEntryController extends BaseController {

    @Autowired
    private ConsignmentEntryRepository consignmentEntryRepository;

    @ApiOperation(value = "配货单行列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(ConsignmentEntry consignmentEntry, @ApiIgnore @SortDefault(value = ConsignmentEntry.FIELD_CONSIGNMENT_ENTRY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ConsignmentEntry> list = consignmentEntryRepository.pageAndSort(pageRequest, consignmentEntry);
        return Results.success(list);
    }

    @ApiOperation(value = "配货单行明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{consignmentEntryId}")
    public ResponseEntity<?> detail(@PathVariable Long consignmentEntryId) {
        ConsignmentEntry consignmentEntry = consignmentEntryRepository.selectByPrimaryKey(consignmentEntryId);
        return Results.success(consignmentEntry);
    }

    @ApiOperation(value = "创建配货单行")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ConsignmentEntry consignmentEntry) {
        consignmentEntryRepository.insertSelective(consignmentEntry);
        return Results.success(consignmentEntry);
    }

    @ApiOperation(value = "修改配货单行")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ConsignmentEntry consignmentEntry) {
        SecurityTokenHelper.validToken(consignmentEntry);
        consignmentEntryRepository.updateByPrimaryKeySelective(consignmentEntry);
        return Results.success(consignmentEntry);
    }

    @ApiOperation(value = "删除配货单行")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ConsignmentEntry consignmentEntry) {
        SecurityTokenHelper.validToken(consignmentEntry);
        consignmentEntryRepository.deleteByPrimaryKey(consignmentEntry);
        return Results.success();
    }

}
