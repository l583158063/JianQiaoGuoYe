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
 * 地区定义
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("地区定义")
@VersionAudit
@ModifyAudit
@Table(name = "metadata_region")
public class MetadataRegion extends AuditDomain {

    public static final String FIELD_REGION_ID = "regionId";
    public static final String FIELD_COUNTRY_ID = "countryId";
    public static final String FIELD_REGION_CODE = "regionCode";
    public static final String FIELD_REGION_NAME = "regionName";
    public static final String FIELD_PARENT_REGION_ID = "parentRegionId";
    public static final String FIELD_LEVEL_PATH = "levelPath";
    public static final String FIELD_IS_ENABLED = "isEnabled";
    public static final String FIELD_AREA_CODE = "areaCode";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long regionId;
    @ApiModelProperty(value = "国家id", required = true)
    @NotNull
    private Long countryId;
    @ApiModelProperty(value = "区域编码", required = true)
    @NotBlank
    private String regionCode;
    @ApiModelProperty(value = "区域名称", required = true)
    @NotBlank
    private String regionName;
    @ApiModelProperty(value = "父区域id")
    private Long parentRegionId;
    @ApiModelProperty(value = "等级路径", required = true)
    @NotBlank
    private String levelPath;
    @ApiModelProperty(value = "启用标识", required = true)
    @NotNull
    private Integer isEnabled;
    @ApiModelProperty(value = "大区，值集O2MD.AREA_CODE")
    private String areaCode;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return
     */
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(final Long regionId) {
        this.regionId = regionId;
    }

    /**
     * @return 国家id
     */
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(final Long countryId) {
        this.countryId = countryId;
    }

    /**
     * @return 区域编码
     */
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(final String regionCode) {
        this.regionCode = regionCode;
    }

    /**
     * @return 区域名称
     */
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(final String regionName) {
        this.regionName = regionName;
    }

    /**
     * @return 父区域id
     */
    public Long getParentRegionId() {
        return parentRegionId;
    }

    public void setParentRegionId(final Long parentRegionId) {
        this.parentRegionId = parentRegionId;
    }

    /**
     * @return 等级路径
     */
    public String getLevelPath() {
        return levelPath;
    }

    public void setLevelPath(final String levelPath) {
        this.levelPath = levelPath;
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
     * @return 大区，值集O2MD.AREA_CODE
     */
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(final String areaCode) {
        this.areaCode = areaCode;
    }

}
