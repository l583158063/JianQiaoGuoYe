package com.jianqiaoguoye.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.jianqiaoguoye.domain.entity.Comment;
import com.jianqiaoguoye.domain.repository.CommentRepository;
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
 * 订单评价 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@RestController("commentController.v1")
@RequestMapping("/v1/comments")
public class CommentController extends BaseController {

    @Autowired
    private CommentRepository commentRepository;

    @ApiOperation(value = "订单评价列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(Comment comment, @ApiIgnore @SortDefault(value = Comment.FIELD_COMMENT_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Comment> list = commentRepository.pageAndSort(pageRequest, comment);
        return Results.success(list);
    }

    @ApiOperation(value = "订单评价明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{commentId}")
    public ResponseEntity<?> detail(@PathVariable Long commentId) {
        Comment comment = commentRepository.selectByPrimaryKey(commentId);
        return Results.success(comment);
    }

    @ApiOperation(value = "创建订单评价")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Comment comment) {
        commentRepository.insertSelective(comment);
        return Results.success(comment);
    }

    @ApiOperation(value = "修改订单评价")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Comment comment) {
        SecurityTokenHelper.validToken(comment);
        commentRepository.updateByPrimaryKeySelective(comment);
        return Results.success(comment);
    }

    @ApiOperation(value = "删除订单评价")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Comment comment) {
        SecurityTokenHelper.validToken(comment);
        commentRepository.deleteByPrimaryKey(comment);
        return Results.success();
    }

}
