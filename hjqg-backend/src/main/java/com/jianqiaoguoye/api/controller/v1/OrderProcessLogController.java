package com.jianqiaoguoye.api.controller.v1;

import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.OrderProcessLog;
import com.jianqiaoguoye.domain.repository.OrderProcessLogRepository;
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
 * 订单处理日志 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Api(tags = SwaggerTags.ORDER_PROCESS_LOG)
@RestController("orderProcessLogController.v1")
@RequestMapping("/v1/order-process-logs")
public class OrderProcessLogController extends BaseController {

    @Autowired
    private OrderProcessLogRepository orderProcessLogRepository;

    @ApiOperation(value = "订单处理日志列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(OrderProcessLog orderProcessLog, @ApiIgnore @SortDefault(value = OrderProcessLog.FIELD_ORDER_PROCESS_LOG_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<OrderProcessLog> list = orderProcessLogRepository.pageAndSort(pageRequest, orderProcessLog);
        return Results.success(list);
    }

    @ApiOperation(value = "订单处理日志明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{orderProcessLogId}")
    public ResponseEntity<?> detail(@PathVariable Long orderProcessLogId) {
        OrderProcessLog orderProcessLog = orderProcessLogRepository.selectByPrimaryKey(orderProcessLogId);
        return Results.success(orderProcessLog);
    }

    @ApiOperation(value = "创建订单处理日志")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderProcessLog orderProcessLog) {
        orderProcessLogRepository.insertSelective(orderProcessLog);
        return Results.success(orderProcessLog);
    }

    @ApiOperation(value = "修改订单处理日志")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody OrderProcessLog orderProcessLog) {
        SecurityTokenHelper.validToken(orderProcessLog);
        orderProcessLogRepository.updateByPrimaryKeySelective(orderProcessLog);
        return Results.success(orderProcessLog);
    }

    @ApiOperation(value = "删除订单处理日志")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody OrderProcessLog orderProcessLog) {
        SecurityTokenHelper.validToken(orderProcessLog);
        orderProcessLogRepository.deleteByPrimaryKey(orderProcessLog);
        return Results.success();
    }

}
