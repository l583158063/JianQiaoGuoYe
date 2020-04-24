package com.jianqiaoguoye.api.controller.v1;

import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.RefundOrderEntry;
import com.jianqiaoguoye.domain.repository.RefundOrderEntryRepository;
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
 * 退款单行 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Api(tags = SwaggerTags.REFUND_ORDER_ENTRY)
@RestController("refundOrderEntryController.v1")
@RequestMapping("/v1/refund-order-entrys")
public class RefundOrderEntryController extends BaseController {

    @Autowired
    private RefundOrderEntryRepository refundOrderEntryRepository;

    @ApiOperation(value = "退款单行列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(RefundOrderEntry refundOrderEntry, @ApiIgnore @SortDefault(value = RefundOrderEntry.FIELD_REFUND_ORDER_ENTRY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<RefundOrderEntry> list = refundOrderEntryRepository.pageAndSort(pageRequest, refundOrderEntry);
        return Results.success(list);
    }

    @ApiOperation(value = "退款单行明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{refundOrderEntryId}")
    public ResponseEntity<?> detail(@PathVariable Long refundOrderEntryId) {
        RefundOrderEntry refundOrderEntry = refundOrderEntryRepository.selectByPrimaryKey(refundOrderEntryId);
        return Results.success(refundOrderEntry);
    }

    @ApiOperation(value = "创建退款单行")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody RefundOrderEntry refundOrderEntry) {
        refundOrderEntryRepository.insertSelective(refundOrderEntry);
        return Results.success(refundOrderEntry);
    }

    @ApiOperation(value = "修改退款单行")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody RefundOrderEntry refundOrderEntry) {
        SecurityTokenHelper.validToken(refundOrderEntry);
        refundOrderEntryRepository.updateByPrimaryKeySelective(refundOrderEntry);
        return Results.success(refundOrderEntry);
    }

    @ApiOperation(value = "删除退款单行")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody RefundOrderEntry refundOrderEntry) {
        SecurityTokenHelper.validToken(refundOrderEntry);
        refundOrderEntryRepository.deleteByPrimaryKey(refundOrderEntry);
        return Results.success();
    }

}
