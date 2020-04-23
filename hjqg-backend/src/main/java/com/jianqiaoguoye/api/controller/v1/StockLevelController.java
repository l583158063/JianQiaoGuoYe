package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.StockLevel;
import com.jianqiaoguoye.domain.repository.StockLevelRepository;
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
 * 库存 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@RestController("stockLevelController.v1")
@RequestMapping("/v1/stock-levels")
public class StockLevelController extends BaseController {

    @Autowired
    private StockLevelRepository stockLevelRepository;

    @ApiOperation(value = "库存列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(StockLevel stockLevel, @ApiIgnore @SortDefault(value = StockLevel.FIELD_STOCK_LEVEL_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<StockLevel> list = stockLevelRepository.pageAndSort(pageRequest, stockLevel);
        return Results.success(list);
    }

    @ApiOperation(value = "库存明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{stockLevelId}")
    public ResponseEntity<?> detail(@PathVariable Long stockLevelId) {
        StockLevel stockLevel = stockLevelRepository.selectByPrimaryKey(stockLevelId);
        return Results.success(stockLevel);
    }

    @ApiOperation(value = "创建库存")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody StockLevel stockLevel) {
        stockLevelRepository.insertSelective(stockLevel);
        return Results.success(stockLevel);
    }

    @ApiOperation(value = "修改库存")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody StockLevel stockLevel) {
        SecurityTokenHelper.validToken(stockLevel);
        stockLevelRepository.updateByPrimaryKeySelective(stockLevel);
        return Results.success(stockLevel);
    }

    @ApiOperation(value = "删除库存")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody StockLevel stockLevel) {
        SecurityTokenHelper.validToken(stockLevel);
        stockLevelRepository.deleteByPrimaryKey(stockLevel);
        return Results.success();
    }

}
