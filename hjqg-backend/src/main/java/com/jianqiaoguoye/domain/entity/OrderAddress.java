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
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

/**
 * 订单地址表
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("订单地址表")
@VersionAudit
@ModifyAudit
@Table(name = "order_address")
public class OrderAddress extends AuditDomain {

    public static final String FIELD_ORDER_ADDRESS_ID = "orderAddressId";
    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_COUNTRY = "country";
    public static final String FIELD_REGION = "region";
    public static final String FIELD_CITY = "city";
    public static final String FIELD_DISTRICT = "district";
    public static final String FIELD_STREET_NAME = "streetName";
    public static final String FIELD_PHONE_NUMBER = "phoneNumber";
    public static final String FIELD_POSTCODE = "postcode";
    public static final String FIELD_CONTACT = "contact";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------


    /**
     * @return 组合地址
     */
    public String combineAddress() {
        addressCombine = region + city + district + streetName;
        return addressCombine;
    }

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long orderAddressId;
    @ApiModelProperty(value = "关联会员")
    private Long customerId;
    @ApiModelProperty(value = "国家")
    @NotBlank
    private String country;
    @ApiModelProperty(value = "省")
    @NotBlank
    private String region;
    @ApiModelProperty(value = "市")
    @NotBlank
    private String city;
    @ApiModelProperty(value = "区")
    @NotBlank
    private String district;
    @ApiModelProperty(value = "街道,门牌号")
    @NotBlank
    private String streetName;
    @ApiModelProperty(value = "电话")
    @NotBlank
    private String phoneNumber;
    @ApiModelProperty(value = "邮编")
    private String postcode;
    @ApiModelProperty(value = "联系人")
    @NotBlank
    private String contact;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    @Transient
    private String addressCombine;

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

}
