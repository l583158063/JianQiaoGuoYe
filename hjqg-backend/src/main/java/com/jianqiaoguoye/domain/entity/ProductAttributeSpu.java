package com.jianqiaoguoye.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 商品SPU属性
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("商品SPU属性")
@VersionAudit
@ModifyAudit
@Table(name = "product_attribute_spu")
public class ProductAttributeSpu extends AuditDomain {

    public static final String FIELD_ATTRIBUTE_SPU_ID = "attributeSpuId";
    public static final String FIELD_PRODUCT_SPU_ID = "productSpuId";
    public static final String FIELD_ATTRIBUTE_CODE = "attributeCode";
    public static final String FIELD_ATTRIBUTE_NAME = "attributeName";
    public static final String FIELD_ATTRIBUTE_VALUE = "attributeValue";
    public static final String FIELD_IS_ENABLED = "isEnabled";
    public static final String FIELD_START_DATE = "startDate";
    public static final String FIELD_END_DATE = "endDate";
    public static final String FIELD_ORDER_SEQ = "orderSeq";
    public static final String FIELD_REMARK = "remark";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long attributeSpuId;
    @ApiModelProperty(value = "商品SPU编号")
    private Long productSpuId;
    @ApiModelProperty(value = "属性编码")
    @NotBlank
    private String attributeCode;
    @ApiModelProperty(value = "属性名称")
    @NotBlank
    private String attributeName;
    @ApiModelProperty(value = "属性值")
    @NotBlank
    private String attributeValue;
    @ApiModelProperty(value = "启用标识")
    @NotNull
    private Integer isEnabled;
    @ApiModelProperty(value = "有效期从")
    private Date startDate;
    @ApiModelProperty(value = "有效期至")
    private Date endDate;
    @ApiModelProperty(value = "排序号")
    private Long orderSeq;
    @ApiModelProperty(value = "备注说明")
    private String remark;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getAttributeSpuId() {
        return attributeSpuId;
    }

    public void setAttributeSpuId(final Long attributeSpuId) {
        this.attributeSpuId = attributeSpuId;
    }

    /**
     * @return 商品SPU编号
     */
    public Long getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(final Long productSpuId) {
        this.productSpuId = productSpuId;
    }

    /**
     * @return 属性编码
     */
    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(final String attributeCode) {
        this.attributeCode = attributeCode;
    }

    /**
     * @return 属性名称
     */
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(final String attributeName) {
        this.attributeName = attributeName;
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
     * @return 有效期从
     */
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return 有效期至
     */
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
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
     * @return 备注说明
     */
    public String getRemark() {
        return remark;
    }

    public void setRemark(final String remark) {
        this.remark = remark;
    }

}
