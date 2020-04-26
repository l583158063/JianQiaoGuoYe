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
 * 承运商定义
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
@ApiModel("承运商定义")
@VersionAudit
@ModifyAudit
@Table(name = "metadata_carrier")
public class MetadataCarrier extends AuditDomain {

    public static final String FIELD_CARRIER_ID = "carrierId";
    public static final String FIELD_CARRIER_CODE = "carrierCode";
    public static final String FIELD_CARRIER_NAME = "carrierName";
    public static final String FIELD_CARRIER_TYPE_CODE = "carrierTypeCode";
    public static final String FIELD_IS_ACTIVE = "isActive";
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
    private Long carrierId;
    @ApiModelProperty(value = "编码")
    @NotBlank
    private String carrierCode;
    @ApiModelProperty(value = "名称")
    @NotBlank
    private String carrierName;
    @ApiModelProperty(value = "类型")
    @NotBlank
    private String carrierTypeCode;
    @ApiModelProperty(value = "是否可用")
    @NotNull
    private Integer isActive;
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
    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(final Long carrierId) {
        this.carrierId = carrierId;
    }

    /**
     * @return 编码
     */
    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(final String carrierCode) {
        this.carrierCode = carrierCode;
    }

    /**
     * @return 名称
     */
    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(final String carrierName) {
        this.carrierName = carrierName;
    }

    /**
     * @return 类型
     */
    public String getCarrierTypeCode() {
        return carrierTypeCode;
    }

    public void setCarrierTypeCode(final String carrierTypeCode) {
        this.carrierTypeCode = carrierTypeCode;
    }

    /**
     * @return 是否可用
     */
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(final Integer isActive) {
        this.isActive = isActive;
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
