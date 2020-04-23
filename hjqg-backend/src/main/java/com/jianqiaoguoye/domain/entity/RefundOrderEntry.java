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

/**
 * 退款单行
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("退款单行")
@VersionAudit
@ModifyAudit
@Table(name = "refund_order_entry")
public class RefundOrderEntry extends AuditDomain {

    public static final String FIELD_REFUND_ORDER_ENTRY_ID = "refundOrderEntryId";
    public static final String FIELD_ENTRY_NUMBER = "entryNumber";
    public static final String FIELD_REFUND_ORDER_ID = "refundOrderId";
    public static final String FIELD_ORDER_ENTRY_ID = "orderEntryId";
    public static final String FIELD_REFUND_QUANTITY = "refundQuantity";
    public static final String FIELD_REFUND_NOTE = "refundNote";
    public static final String FIELD_REFUND_AMOUNT = "refundAmount";
    public static final String FIELD_REFUND_REASON_CODE = "refundReasonCode";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long refundOrderEntryId;
    @ApiModelProperty(value = "订单行序号", required = true)
    @NotNull
    private Long entryNumber;
    @ApiModelProperty(value = "退款单头,关联refund_order.refund_order_id", required = true)
    @NotNull
    private Long refundOrderId;
    @ApiModelProperty(value = "订单行,关联order_entry.order_entry_id", required = true)
    @NotNull
    private Long orderEntryId;
    @ApiModelProperty(value = "退款数量")
    private Long refundQuantity;
    @ApiModelProperty(value = "退款备注")
    private String refundNote;
    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundAmount;
    @ApiModelProperty(value = "退款原因,值集：O2RF.REFUND_REASON")
    private String refundReasonCode;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getRefundOrderEntryId() {
        return refundOrderEntryId;
    }

    public void setRefundOrderEntryId(final Long refundOrderEntryId) {
        this.refundOrderEntryId = refundOrderEntryId;
    }

    /**
     * @return 订单行序号
     */
    public Long getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(final Long entryNumber) {
        this.entryNumber = entryNumber;
    }

    /**
     * @return 退款单头, 关联refund_order.refund_order_id
     */
    public Long getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(final Long refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    /**
     * @return 订单行, 关联order_entry.order_entry_id
     */
    public Long getOrderEntryId() {
        return orderEntryId;
    }

    public void setOrderEntryId(final Long orderEntryId) {
        this.orderEntryId = orderEntryId;
    }

    /**
     * @return 退款数量
     */
    public Long getRefundQuantity() {
        return refundQuantity;
    }

    public void setRefundQuantity(final Long refundQuantity) {
        this.refundQuantity = refundQuantity;
    }

    /**
     * @return 退款备注
     */
    public String getRefundNote() {
        return refundNote;
    }

    public void setRefundNote(final String refundNote) {
        this.refundNote = refundNote;
    }

    /**
     * @return 退款金额
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(final BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * @return 退款原因, 值集：O2RF.REFUND_REASON
     */
    public String getRefundReasonCode() {
        return refundReasonCode;
    }

    public void setRefundReasonCode(final String refundReasonCode) {
        this.refundReasonCode = refundReasonCode;
    }

}
