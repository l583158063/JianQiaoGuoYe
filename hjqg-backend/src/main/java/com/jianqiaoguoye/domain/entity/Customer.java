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
 * 当用户注册成功会将对应信息写入，当用户个人信息处修改个人信息后保存后写入
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("会员")
@VersionAudit
@ModifyAudit
@Table(name = "customer")
public class Customer extends AuditDomain {

    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_CUSTOMER_NAME = "customerName";
    public static final String FIELD_INTERNATIONAL_TEL_CODE = "internationalTelCode";
    public static final String FIELD_MOBILE_NUMBER = "mobileNumber";
    public static final String FIELD_NICK_NAME = "nickName";
    public static final String FIELD_BLACK_LIST_FLAG = "blackListFlag";
    public static final String FIELD_REMARK = "remark";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_GENDER_CODE = "genderCode";
    public static final String FIELD_BIRTH_DATE = "birthDate";
    public static final String FIELD_REGISTER_DATE = "registerDate";
    public static final String FIELD_STATUS_CODE = "statusCode";
    public static final String FIELD_LAST_LOGIN_DATE = "lastLoginDate";
    public static final String FIELD_HZERO_USER_ID = "hzeroUserId";
    public static final String FIELD_IS_FULL_INFO = "isFullInfo";
    public static final String FIELD_FIGURE_URL = "figureUrl";
    public static final String FIELD_CANCEL_DATE = "cancelDate";
    public static final String FIELD_ID_CARD = "idCard";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long customerId;
    @ApiModelProperty(value = "用户名")
    private String customerName;
    @ApiModelProperty(value = "国际电话区号")
    @NotBlank
    private String internationalTelCode;
    @ApiModelProperty(value = "手机号")
    private String mobileNumber;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "是否在黑名单")
    @NotNull
    private Integer blackListFlag;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "邮件地址")
    private String email;
    @ApiModelProperty(value = "性别，值集：HPFM.GENDER")
    private String genderCode;
    @ApiModelProperty(value = "生日")
    private Date birthDate;
    @ApiModelProperty(value = "注册时间")
    private Date registerDate;
    @ApiModelProperty(value = "会员状态，取自值集CUSTOMER.STATUS")
    @NotBlank
    private String statusCode;
    @ApiModelProperty(value = "最近一次登录时间")
    private Date lastLoginDate;
    @ApiModelProperty(value = "hzero的用户ID(iam_user.user_id)")
    private Long hzeroUserId;
    @ApiModelProperty(value = "是否已完善信息")
    @NotNull
    private Integer isFullInfo;
    @ApiModelProperty(value = "头像")
    private String figureUrl;
    @ApiModelProperty(value = "注销日期")
    private Date cancelDate;
    @ApiModelProperty(value = "身份证号")
    private String idCard;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return 用户名
     */
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return 国际电话区号
     */
    public String getInternationalTelCode() {
        return internationalTelCode;
    }

    public void setInternationalTelCode(final String internationalTelCode) {
        this.internationalTelCode = internationalTelCode;
    }

    /**
     * @return 手机号
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return 昵称
     */
    public String getNickName() {
        return nickName;
    }

    public void setNickName(final String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return 是否在黑名单
     */
    public Integer getBlackListFlag() {
        return blackListFlag;
    }

    public void setBlackListFlag(final Integer blackListFlag) {
        this.blackListFlag = blackListFlag;
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

    /**
     * @return 邮件地址
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return 性别
     */
    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(final String genderCode) {
        this.genderCode = genderCode;
    }

    /**
     * @return 生日
     */
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return 注册时间
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(final Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return 会员状态，取自值集CUSTOMER.STATUS
     */
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return 最近一次登录时间
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(final Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * @return hzero的用户ID(iam_user.user_id)
     */
    public Long getHzeroUserId() {
        return hzeroUserId;
    }

    public void setHzeroUserId(final Long hzeroUserId) {
        this.hzeroUserId = hzeroUserId;
    }

    /**
     * @return 是否已完善信息
     */
    public Integer getIsFullInfo() {
        return isFullInfo;
    }

    public void setIsFullInfo(final Integer isFullInfo) {
        this.isFullInfo = isFullInfo;
    }

    /**
     * @return 头像
     */
    public String getFigureUrl() {
        return figureUrl;
    }

    public void setFigureUrl(final String figureUrl) {
        this.figureUrl = figureUrl;
    }

    /**
     * @return 注销日期
     */
    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(final Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    /**
     * @return 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(final String idCard) {
        this.idCard = idCard;
    }

}
