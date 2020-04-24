package com.jianqiaoguoye.api.controller.v1;

import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.OrderEntry;
import com.jianqiaoguoye.domain.repository.OrderEntryRepository;
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
 * 订单行 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Api(tags = SwaggerTags.ORDER_ENTRY)
@RestController("orderEntryController.v1")
@RequestMapping("/v1/order-entrys")
public class OrderEntryController extends BaseController {

    @Autowired
    private OrderEntryRepository orderEntryRepository;

    @ApiOperation(value = "订单行列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(OrderEntry orderEntry, @ApiIgnore @SortDefault(value = OrderEntry.FIELD_ORDER_ENTRY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<OrderEntry> list = orderEntryRepository.pageAndSort(pageRequest, orderEntry);
        return Results.success(list);
    }

    @ApiOperation(value = "订单行明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{orderEntryId}")
    public ResponseEntity<?> detail(@PathVariable Long orderEntryId) {
        OrderEntry orderEntry = orderEntryRepository.selectByPrimaryKey(orderEntryId);
        return Results.success(orderEntry);
    }

    @ApiOperation(value = "创建订单行")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderEntry orderEntry) {
        orderEntryRepository.insertSelective(orderEntry);
        return Results.success(orderEntry);
    }

    @ApiOperation(value = "修改订单行")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody OrderEntry orderEntry) {
        SecurityTokenHelper.validToken(orderEntry);
        orderEntryRepository.updateByPrimaryKeySelective(orderEntry);
        return Results.success(orderEntry);
    }

    @ApiOperation(value = "删除订单行")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody OrderEntry orderEntry) {
        SecurityTokenHelper.validToken(orderEntry);
        orderEntryRepository.deleteByPrimaryKey(orderEntry);
        return Results.success();
    }

}
