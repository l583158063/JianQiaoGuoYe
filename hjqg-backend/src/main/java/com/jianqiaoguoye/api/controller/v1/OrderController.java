package com.jianqiaoguoye.api.controller.v1;

import com.alibaba.fastjson.JSON;
import com.jianqiaoguoye.api.dto.OrderCreateDTO;
import com.jianqiaoguoye.app.service.OrderService;
import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.Order;
import com.jianqiaoguoye.domain.repository.OrderRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单头 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Slf4j
@Api(tags = SwaggerTags.ORDER)
@RestController("orderController.v1")
@RequestMapping("/v1/orders")
public class OrderController extends BaseController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "订单头列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(Order order, @ApiIgnore @SortDefault(value = Order.FIELD_ORDER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Order> list = PageHelper.doPageAndSort(pageRequest, () -> orderService.list(order));
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

    @ApiOperation(value = "确认订单并生成配货单")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/confirm-order")
    public ResponseEntity<?> confirmOrder(@RequestParam Long orderId) {
        String consignmentCode = orderService.confirmOrder(orderId);
        if (StringUtils.isBlank(consignmentCode)) {
            return Results.error("生成配货单失败");
        }
        return Results.success(consignmentCode);
    }

    @ApiOperation(value = "商城创建订单")
    @Permission(permissionPublic = true)
    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
        if (log.isDebugEnabled()) {
            log.debug("productSkuDtoList: {}", JSON.toJSONString(orderCreateDTO));
        }
        if (null == orderCreateDTO || CollectionUtils.isEmpty(orderCreateDTO.getProductSkuDtoList())) {
            return Results.invalid();
        }
        return orderService.createOrder(orderCreateDTO);
    }

    @ApiOperation(value = "查询个人订单列表")
    @Permission(permissionPublic = true)
    @GetMapping("/query-order-list/{customerId}")
    public ResponseEntity<?> queryOrderList(@PathVariable Long customerId) {
        List<Order> orderList = orderService.queryOrderList(customerId);
        return Results.success(orderList);
    }

    @ApiOperation(value = "确认收货")
    @Permission(permissionPublic = true)
    @PostMapping("/receive")
    public ResponseEntity<?> receive(@RequestBody Order order) {
        if (log.isDebugEnabled()) {
            log.debug("comment order: {}", JSON.toJSONString(order));
        }
        if (null == order) {
            return Results.invalid();
        }
        return orderService.receive(order);
    }

    @ApiOperation(value = "商城订单评价")
    @Permission(permissionPublic = true)
    @PostMapping("/comment-order")
    public ResponseEntity<?> commentOrder(@RequestBody Order order, @RequestParam BigDecimal grade) {
        if (log.isDebugEnabled()) {
            log.debug("comment order: {}", JSON.toJSONString(order));
            log.debug("comment grade: {}", grade);
        }
        if (null == order) {
            return Results.invalid();
        }
        return orderService.commentOrder(order, grade);
    }

}
