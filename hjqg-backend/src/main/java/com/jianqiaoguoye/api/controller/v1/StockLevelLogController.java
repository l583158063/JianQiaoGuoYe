package com.jianqiaoguoye.api.controller.v1;

import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.StockLevelLog;
import com.jianqiaoguoye.domain.repository.StockLevelLogRepository;
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
 * 库存变动日志 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Api(tags = SwaggerTags.STOCK_LEVEL_LOG)
@RestController("stockLevelLogController.v1")
@RequestMapping("/v1/stock-level-logs")
public class StockLevelLogController extends BaseController {

    @Autowired
    private StockLevelLogRepository stockLevelLogRepository;

    @ApiOperation(value = "库存变动日志列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(StockLevelLog stockLevelLog, @ApiIgnore @SortDefault(value = StockLevelLog.FIELD_STOCK_LEVEL_LOG_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<StockLevelLog> list = stockLevelLogRepository.pageAndSort(pageRequest, stockLevelLog);
        return Results.success(list);
    }

    @ApiOperation(value = "库存变动日志明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{stockLevelLogId}")
    public ResponseEntity<?> detail(@PathVariable Long stockLevelLogId) {
        StockLevelLog stockLevelLog = stockLevelLogRepository.selectByPrimaryKey(stockLevelLogId);
        return Results.success(stockLevelLog);
    }

    @ApiOperation(value = "创建库存变动日志")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody StockLevelLog stockLevelLog) {
        stockLevelLogRepository.insertSelective(stockLevelLog);
        return Results.success(stockLevelLog);
    }

    @ApiOperation(value = "修改库存变动日志")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody StockLevelLog stockLevelLog) {
        SecurityTokenHelper.validToken(stockLevelLog);
        stockLevelLogRepository.updateByPrimaryKeySelective(stockLevelLog);
        return Results.success(stockLevelLog);
    }

    @ApiOperation(value = "删除库存变动日志")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody StockLevelLog stockLevelLog) {
        SecurityTokenHelper.validToken(stockLevelLog);
        stockLevelLogRepository.deleteByPrimaryKey(stockLevelLog);
        return Results.success();
    }

}
