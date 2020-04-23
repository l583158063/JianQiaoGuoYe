package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.PayInfo;
import com.jianqiaoguoye.domain.repository.PayInfoRepository;
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
 * 支付信息明细 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@RestController("payInfoController.v1")
@RequestMapping("/v1/pay-infos")
public class PayInfoController extends BaseController {

    @Autowired
    private PayInfoRepository payInfoRepository;

    @ApiOperation(value = "支付信息明细列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(PayInfo payInfo, @ApiIgnore @SortDefault(value = PayInfo.FIELD_PAY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<PayInfo> list = payInfoRepository.pageAndSort(pageRequest, payInfo);
        return Results.success(list);
    }

    @ApiOperation(value = "支付信息明细明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{payId}")
    public ResponseEntity<?> detail(@PathVariable Long payId) {
        PayInfo payInfo = payInfoRepository.selectByPrimaryKey(payId);
        return Results.success(payInfo);
    }

    @ApiOperation(value = "创建支付信息明细")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PayInfo payInfo) {
        payInfoRepository.insertSelective(payInfo);
        return Results.success(payInfo);
    }

    @ApiOperation(value = "修改支付信息明细")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody PayInfo payInfo) {
        SecurityTokenHelper.validToken(payInfo);
        payInfoRepository.updateByPrimaryKeySelective(payInfo);
        return Results.success(payInfo);
    }

    @ApiOperation(value = "删除支付信息明细")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody PayInfo payInfo) {
        SecurityTokenHelper.validToken(payInfo);
        payInfoRepository.deleteByPrimaryKey(payInfo);
        return Results.success();
    }

}
