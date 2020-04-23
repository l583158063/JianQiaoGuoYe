package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.RefundOrder;
import com.jianqiaoguoye.domain.repository.RefundOrderRepository;
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
 * 退款单 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@RestController("refundOrderController.v1")
@RequestMapping("/v1/refund-orders")
public class RefundOrderController extends BaseController {

    @Autowired
    private RefundOrderRepository refundOrderRepository;

    @ApiOperation(value = "退款单列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(RefundOrder refundOrder, @ApiIgnore @SortDefault(value = RefundOrder.FIELD_REFUND_ORDER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<RefundOrder> list = refundOrderRepository.pageAndSort(pageRequest, refundOrder);
        return Results.success(list);
    }

    @ApiOperation(value = "退款单明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{refundOrderId}")
    public ResponseEntity<?> detail(@PathVariable Long refundOrderId) {
        RefundOrder refundOrder = refundOrderRepository.selectByPrimaryKey(refundOrderId);
        return Results.success(refundOrder);
    }

    @ApiOperation(value = "创建退款单")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody RefundOrder refundOrder) {
        refundOrderRepository.insertSelective(refundOrder);
        return Results.success(refundOrder);
    }

    @ApiOperation(value = "修改退款单")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody RefundOrder refundOrder) {
        SecurityTokenHelper.validToken(refundOrder);
        refundOrderRepository.updateByPrimaryKeySelective(refundOrder);
        return Results.success(refundOrder);
    }

    @ApiOperation(value = "删除退款单")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody RefundOrder refundOrder) {
        SecurityTokenHelper.validToken(refundOrder);
        refundOrderRepository.deleteByPrimaryKey(refundOrder);
        return Results.success();
    }

}
