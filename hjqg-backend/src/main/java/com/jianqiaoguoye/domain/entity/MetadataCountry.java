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
 * 国家定义
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("国家定义")
@VersionAudit
@ModifyAudit
@Table(name = "metadata_country")
public class MetadataCountry extends AuditDomain {

    public static final String FIELD_COUNTRY_ID = "countryId";
    public static final String FIELD_COUNTRY_CODE = "countryCode";
    public static final String FIELD_COUNTRY_NAME = "countryName";
    public static final String FIELD_IS_ENABLED = "isEnabled";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long countryId;
    @ApiModelProperty(value = "国家编码")
    @NotBlank
    private String countryCode;
    @ApiModelProperty(value = "国家名称")
    @NotBlank
    private String countryName;
    @ApiModelProperty(value = "启用标识")
    @NotNull
    private Integer isEnabled;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return
     */
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(final Long countryId) {
        this.countryId = countryId;
    }

    /**
     * @return 国家编码
     */
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return 国家名称
     */
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
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

}
