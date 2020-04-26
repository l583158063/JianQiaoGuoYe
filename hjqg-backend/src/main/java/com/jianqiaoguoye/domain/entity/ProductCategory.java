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
 * 商品类型
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@ApiModel("商品类型")
@VersionAudit
@ModifyAudit
@Table(name = "product_category")
public class ProductCategory extends AuditDomain {

    public static final String FIELD_CATEGORY_ID = "categoryId";
    public static final String FIELD_CATEGORY_CODE = "categoryCode";
    public static final String FIELD_CATEGORY_NAME = "categoryName";
    public static final String FIELD_IS_ACTIVE = "isActive";
    public static final String FIELD_ORDER_SEQ = "orderSeq";
    public static final String FIELD_REMARK = "remark";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long categoryId;
    @ApiModelProperty(value = "类型编码")
    @NotBlank
    private String categoryCode;
    @ApiModelProperty(value = "名称")
    @NotBlank
    private String categoryName;
    @ApiModelProperty(value = "启用标识")
    @NotNull
    private Integer isActive;
    @ApiModelProperty(value = "排序")
    private Long orderSeq;
    @ApiModelProperty(value = "备注")
    private String remark;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return
     */
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return 类型编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(final String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * @return 名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return 启用标识
     */
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(final Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * @return 排序
     */
    public Long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(final Long orderSeq) {
        this.orderSeq = orderSeq;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    public void setRemark(final String remark) {
        this.remark = remark;
    }

}
