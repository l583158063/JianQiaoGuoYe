package com.jianqiaoguoye.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付信息明细
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@ApiModel("支付信息明细")
@VersionAudit
@ModifyAudit
@Table(name = "pay_info")
public class PayInfo extends AuditDomain {

    public static final String FIELD_PAY_ID = "payId";
    public static final String FIELD_ORDER_ID = "orderId";
    public static final String FIELD_PAY_TIME = "payTime";
    public static final String FIELD_PAY_AMOUNT = "payAmount";
    public static final String FIELD_PAY_WAY_CODE = "payWayCode";
    public static final String FIELD_PAY_TYPE_CODE = "payTypeCode";
    public static final String FIELD_PAY_DETAIL = "payDetail";
    public static final String FIELD_PAY_ACCOUNT = "payAccount";
    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_SERIAL_NUMBER = "serialNumber";
    public static final String FIELD_RECEIVE_ACCOUNT = "receiveAccount";
    public static final String FIELD_PAY_ORDER_NUMBER = "payOrderNumber";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long payId;
    @ApiModelProperty(value = "订单ID，关联order.order_id", required = true)
    @NotNull
    private Long orderId;
    @ApiModelProperty(value = "支付时间")
    private Date payTime;
    @ApiModelProperty(value = "支付金额")
    private BigDecimal payAmount;
    @ApiModelProperty(value = "支付方式，值集：O2OT.PAYMENT_WAY")
    private String payWayCode;
    @ApiModelProperty(value = "支付类型，值集：O2OT.PAYMENT_TYPE")
    private String payTypeCode;
    @ApiModelProperty(value = "支付明细")
    private String payDetail;
    @ApiModelProperty(value = "付款账户")
    private String payAccount;
    @ApiModelProperty(value = "付款ID")
    private Long customerId;
    @ApiModelProperty(value = "流水号")
    private String serialNumber;
    @ApiModelProperty(value = "收款账户")
    private String receiveAccount;
    @ApiModelProperty(value = "支付订单号")
    private String payOrderNumber;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getPayId() {
        return payId;
    }

    public void setPayId(final Long payId) {
        this.payId = payId;
    }

    /**
     * @return 订单ID，关联order.order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(final Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return 支付金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(final BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * @return 支付方式，值集：O2OT.PAYMENT_WAY
     */
    public String getPayWayCode() {
        return payWayCode;
    }

    public void setPayWayCode(final String payWayCode) {
        this.payWayCode = payWayCode;
    }

    /**
     * @return 支付类型，值集：O2OT.PAYMENT_TYPE
     */
    public String getPayTypeCode() {
        return payTypeCode;
    }

    public void setPayTypeCode(final String payTypeCode) {
        this.payTypeCode = payTypeCode;
    }

    /**
     * @return 支付明细
     */
    public String getPayDetail() {
        return payDetail;
    }

    public void setPayDetail(final String payDetail) {
        this.payDetail = payDetail;
    }

    /**
     * @return 付款账户
     */
    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(final String payAccount) {
        this.payAccount = payAccount;
    }

    /**
     * @return 付款ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return 流水号
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(final String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * @return 收款账户
     */
    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(final String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    /**
     * @return 支付订单号
     */
    public String getPayOrderNumber() {
        return payOrderNumber;
    }

    public void setPayOrderNumber(final String payOrderNumber) {
        this.payOrderNumber = payOrderNumber;
    }

}
