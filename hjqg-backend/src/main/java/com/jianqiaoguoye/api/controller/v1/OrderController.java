package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.Order;
import com.jianqiaoguoye.domain.repository.OrderRepository;
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
 * 订单头 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@RestController("orderController.v1")
@RequestMapping("/v1/orders")
public class OrderController extends BaseController {

    @Autowired
    private OrderRepository orderRepository;

    @ApiOperation(value = "订单头列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(Order order, @ApiIgnore @SortDefault(value = Order.FIELD_ORDER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Order> list = orderRepository.pageAndSort(pageRequest, order);
        return Results.success(list);
    }

    @ApiOperation(value = "订单头明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{orderId}")
    public ResponseEntity<?> detail(@PathVariable Long orderId) {
        Order order = orderRepository.selectByPrimaryKey(orderId);
        return Results.success(order);
    }

    @ApiOperation(value = "创建订单头")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Order order) {
        orderRepository.insertSelective(order);
        return Results.success(order);
    }

    @ApiOperation(value = "修改订单头")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Order order) {
        SecurityTokenHelper.validToken(order);
        orderRepository.updateByPrimaryKeySelective(order);
        return Results.success(order);
    }

    @ApiOperation(value = "删除订单头")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Order order) {
        SecurityTokenHelper.validToken(order);
        orderRepository.deleteByPrimaryKey(order);
        return Results.success();
    }

}
