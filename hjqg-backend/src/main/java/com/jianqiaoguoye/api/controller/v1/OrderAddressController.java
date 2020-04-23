package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.OrderAddress;
import com.jianqiaoguoye.domain.repository.OrderAddressRepository;
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
 * 订单地址表 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@RestController("orderAddressController.v1")
@RequestMapping("/v1/order-addresss")
public class OrderAddressController extends BaseController {

    @Autowired
    private OrderAddressRepository orderAddressRepository;

    @ApiOperation(value = "订单地址表列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(OrderAddress orderAddress, @ApiIgnore @SortDefault(value = OrderAddress.FIELD_ORDER_ADDRESS_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<OrderAddress> list = orderAddressRepository.pageAndSort(pageRequest, orderAddress);
        return Results.success(list);
    }

    @ApiOperation(value = "订单地址表明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{orderAddressId}")
    public ResponseEntity<?> detail(@PathVariable Long orderAddressId) {
        OrderAddress orderAddress = orderAddressRepository.selectByPrimaryKey(orderAddressId);
        return Results.success(orderAddress);
    }

    @ApiOperation(value = "创建订单地址表")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderAddress orderAddress) {
        orderAddressRepository.insertSelective(orderAddress);
        return Results.success(orderAddress);
    }

    @ApiOperation(value = "修改订单地址表")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody OrderAddress orderAddress) {
        SecurityTokenHelper.validToken(orderAddress);
        orderAddressRepository.updateByPrimaryKeySelective(orderAddress);
        return Results.success(orderAddress);
    }

    @ApiOperation(value = "删除订单地址表")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody OrderAddress orderAddress) {
        SecurityTokenHelper.validToken(orderAddress);
        orderAddressRepository.deleteByPrimaryKey(orderAddress);
        return Results.success();
    }

}
