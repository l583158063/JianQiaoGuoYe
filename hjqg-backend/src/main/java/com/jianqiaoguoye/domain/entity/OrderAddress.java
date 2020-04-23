package com.jianqiaoguoye.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单地址表
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("订单地址表")
@VersionAudit
@ModifyAudit
@Table(name = "order_address")
public class OrderAddress extends AuditDomain {

    public static final String FIELD_ORDER_ADDRESS_ID = "orderAddressId";
    public static final String FIELD_COUNTRY_ID = "countryId";
    public static final String FIELD_REGION_ID = "regionId";
    public static final String FIELD_CITY_ID = "cityId";
    public static final String FIELD_DISTRICT_ID = "districtId";
    public static final String FIELD_STREET_NAME = "streetName";
    public static final String FIELD_PHONE_NUMBER = "phoneNumber";
    public static final String FIELD_POSTCODE = "postcode";
    public static final String FIELD_CONTACT = "contact";
    public static final String FIELD_MOBILE_PHONE = "mobilePhone";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long orderAddressId;
    @ApiModelProperty(value = "国家,")
    private Long countryId;
    @ApiModelProperty(value = "省,")
    private Long regionId;
    @ApiModelProperty(value = "市,")
    private Long cityId;
    @ApiModelProperty(value = "区,")
    private Long districtId;
    @ApiModelProperty(value = "街道,门牌号")
    private String streetName;
    @ApiModelProperty(value = "电话")
    private String phoneNumber;
    @ApiModelProperty(value = "邮编")
    private String postcode;
    @ApiModelProperty(value = "联系人")
    private String contact;
    @ApiModelProperty(value = "手机号")
    private String mobilePhone;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(final Long orderAddressId) {
        this.orderAddressId = orderAddressId;
    }

    /**
     * @return 国家,
     */
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(final Long countryId) {
        this.countryId = countryId;
    }

    /**
     * @return 省,
     */
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(final Long regionId) {
        this.regionId = regionId;
    }

    /**
     * @return 市,
     */
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(final Long cityId) {
        this.cityId = cityId;
    }

    /**
     * @return 区,
     */
    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(final Long districtId) {
        this.districtId = districtId;
    }

    /**
     * @return 街道, 门牌号
     */
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(final String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return 电话
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return 邮编
     */
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return 联系人
     */
    public String getContact() {
        return contact;
    }

    public void setContact(final String contact) {
        this.contact = contact;
    }

    /**
     * @return 手机号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(final String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

}
