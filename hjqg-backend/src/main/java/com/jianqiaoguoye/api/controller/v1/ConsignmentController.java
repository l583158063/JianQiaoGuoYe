package com.jianqiaoguoye.api.controller.v1;

import com.jianqiaoguoye.app.service.ConsignmentService;
import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.Consignment;
import com.jianqiaoguoye.domain.repository.ConsignmentRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.PageHelper;
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
 * 配货单 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Api(tags = SwaggerTags.CONSIGNMENT)
@RestController("consignmentController.v1")
@RequestMapping("/v1/consignments")
public class ConsignmentController extends BaseController {

    @Autowired
    private ConsignmentRepository consignmentRepository;
    @Autowired
    private ConsignmentService consignmentService;

    @ApiOperation(value = "配货单列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(Consignment consignment, @ApiIgnore @SortDefault(value = Consignment.FIELD_CONSIGNMENT_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Consignment> list = PageHelper.doPageAndSort(pageRequest, () -> consignmentService.list(consignment));
        return Results.success(list);
    }

    @ApiOperation(value = "配货单明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{consignmentId}")
    public ResponseEntity<?> detail(@PathVariable Long consignmentId) {
        Consignment consignment = consignmentRepository.selectByPrimaryKey(consignmentId);
        return Results.success(consignment);
    }

    @ApiOperation(value = "创建配货单")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Consignment consignment) {
        consignmentRepository.insertSelective(consignment);
        return Results.success(consignment);
    }

    @ApiOperation(value = "修改配货单")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Consignment consignment) {
        SecurityTokenHelper.validToken(consignment);
        consignmentRepository.updateByPrimaryKeySelective(consignment);
        return Results.success(consignment);
    }

    @ApiOperation(value = "删除配货单")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Consignment consignment) {
        SecurityTokenHelper.validToken(consignment);
        consignmentRepository.deleteByPrimaryKey(consignment);
        return Results.success();
    }

}
