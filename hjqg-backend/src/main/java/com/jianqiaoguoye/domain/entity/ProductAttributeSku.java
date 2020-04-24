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
import java.util.Date;

/**
 * 商品SKU属性
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@ApiModel("商品SKU属性")
@VersionAudit
@ModifyAudit
@Table(name = "product_attribute_sku")
public class ProductAttributeSku extends AuditDomain {

    public static final String FIELD_ATTRIBUTE_SKU_ID = "attributeSkuId";
    public static final String FIELD_PRODUCT_SKU_ID = "productSkuId";
    public static final String FIELD_ATTRIBUTE_CODE = "attributeCode";
    public static final String FIELD_ATTRIBUTE_NAME = "attributeName";
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
    private Long attributeSkuId;
    @ApiModelProperty(value = "商品SKU编号")
    private Long productSkuId;
    @ApiModelProperty(value = "属性编码", required = true)
    @NotBlank
    private String attributeCode;
    @ApiModelProperty(value = "属性名称", required = true)
    @NotBlank
    private String attributeName;
    @ApiModelProperty(value = "启用标识", required = true)
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
    public Long getAttributeSkuId() {
        return attributeSkuId;
    }

    public void setAttributeSkuId(final Long attributeSkuId) {
        this.attributeSkuId = attributeSkuId;
    }

    /**
     * @return 商品SKU编号
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(final Long productSkuId) {
        this.productSkuId = productSkuId;
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