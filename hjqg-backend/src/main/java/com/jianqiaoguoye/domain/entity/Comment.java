package com.jianqiaoguoye.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 订单评价
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@ApiModel("订单评价")
@VersionAudit
@ModifyAudit
@Table(name = "comment")
public class Comment extends AuditDomain {

    public static final String FIELD_COMMENT_ID = "commentId";
    public static final String FIELD_ORDER_ID = "orderId";
    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_PRODUCT_SPU_ID = "productSpuId";
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_IMAGE_URL = "imageUrl";
    public static final String FIELD_IS_ENABLED = "isEnabled";
    public static final String FIELD_ORDER_SEQ = "orderSeq";
    public static final String FIELD_GRADE = "grade";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long commentId;
    @ApiModelProperty(value = "关联order", required = true)
    @NotNull
    private Long orderId;
    @ApiModelProperty(value = "关联customer", required = true)
    @NotNull
    private Long customerId;
    @ApiModelProperty(value = "关联商品spu", required = true)
    @NotNull
    private Long productSpuId;
    @ApiModelProperty(value = "评价内容", required = true)
    @NotBlank
    private String content;
    @ApiModelProperty(value = "评价插图")
    private String imageUrl;
    @ApiModelProperty(value = "启用标识", required = true)
    @NotNull
    private Integer isEnabled;
    @ApiModelProperty(value = "排序号")
    private Long orderSeq;
    @ApiModelProperty(value = "用户评分", required = true)
    @NotNull
    private Long grade;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(final Long commentId) {
        this.commentId = commentId;
    }

    /**
     * @return 关联order
     */
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 关联customer
     */
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return 关联商品spu
     */
    public Long getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(final Long productSpuId) {
        this.productSpuId = productSpuId;
    }

    /**
     * @return 评价内容
     */
    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    /**
     * @return 评价插图
     */
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return 启用标识
     */
    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(final Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * @return 排序号
     */
    public Long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(final Long orderSeq) {
        this.orderSeq = orderSeq;
    }

    /**
     * @return 用户评分
     */
    public Long getGrade() {
        return grade;
    }

    public void setGrade(final Long grade) {
        this.grade = grade;
    }

}
