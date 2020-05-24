package com.jianqiaoguoye.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 配货单
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("配货单")
@VersionAudit
@ModifyAudit
@Table(name = "consignment")
public class Consignment extends AuditDomain {

    public static final String FIELD_CONSIGNMENT_ID = "consignmentId";
    public static final String FIELD_ORDER_ID = "orderId";
    public static final String FIELD_CONSIGNMENT_CODE = "consignmentCode";
    public static final String FIELD_CONSIGNMENT_TYPE = "consignmentType";
    public static final String FIELD_DELIVERY_TYPE_CODE = "deliveryTypeCode";
    public static final String FIELD_CONSIGNMENT_STATUS_CODE = "consignmentStatusCode";
    public static final String FIELD_APPROVED_DATE = "approvedDate";
    public static final String FIELD_APPROVER_ID = "approverId";
    public static final String FIELD_IS_MANUAL_APPROVED = "isManualApproved";
    public static final String FIELD_CONSIGNER = "consigner";
    public static final String FIELD_DELIVERY_DATE = "deliveryDate";
    public static final String FIELD_DELIVERY_NUMBER = "deliveryNumber";
    public static final String FIELD_DELIVERY_CARRIER = "deliveryCarrier";
    public static final String FIELD_CARRIER_ID = "carrierId";
    public static final String FIELD_DELIVERY_COST = "deliveryCost";
    public static final String FIELD_ABNORMAL_REASON_CODE = "abnormalReasonCode";
    public static final String FIELD_ABNORMAL_TYPE_CODE = "abnormalTypeCode";
    public static final String FIELD_REMARKS = "remarks";
    public static final String FIELD_DISPATCH_STATUS_CODE = "dispatchStatusCode";
    public static final String FIELD_IS_DISTRIBUTED = "isDistributed";
    public static final String FIELD_DISTRIBUTED_STATUS_CODE = "distributedStatusCode";
    public static final String FIELD_REFUND_ORDER_ID = "refundOrderId";
    public static final String FIELD_IS_SMS_SEND = "isSmsSend";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long consignmentId;
    @ApiModelProperty(value = "关联订单,关联order.order_id")
    @NotNull
    private Long orderId;
    @ApiModelProperty(value = "配货单号")
    @NotBlank
    private String consignmentCode;
    @ApiModelProperty(value = "配送方式,值集o2of.DELIVERY_TYPE")
    private String deliveryTypeCode;
    @ApiModelProperty(value = "配货单状态,值集o2of.CONSIGNMENT_STATUS")
    private String consignmentStatusCode;
    @ApiModelProperty(value = "审核日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime approvedDate;
    @ApiModelProperty(value = "审核人ID")
    private Long approverId;
    @ApiModelProperty(value = "是否已手工审核")
    @NotNull
    private Integer isManualApproved;
    @ApiModelProperty(value = "配货人")
    private String consigner;
    @ApiModelProperty(value = "发货日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliveryDate;
    @ApiModelProperty(value = "物流单号")
    private String deliveryNumber;
    @ApiModelProperty(value = "承运商,关联metadata_carrier.carrier_id")
    private Long carrierId;
    @ApiModelProperty(value = "承运商")
    private String deliveryCarrier;
    @ApiModelProperty(value = "运费")
    private BigDecimal deliveryCost;
    @ApiModelProperty(value = "异常原因,值集o2of.ABNORMAL_REASON")
    private String abnormalReasonCode;
    @ApiModelProperty(value = "异常类型,值集o2of.ABNORMAL_TYPE")
    private String abnormalTypeCode;
    @ApiModelProperty(value = "备注")
    private String remarks;
    @ApiModelProperty(value = "发货回传状态，值集o2of.PROCESSING_STATUS")
    private String dispatchStatusCode;
    @ApiModelProperty(value = "是否派发配货人员")
    @NotNull
    private Integer isDistributed;
    @ApiModelProperty(value = "下发状态，值集o2of.PROCESSING_STATUS")
    private String distributedStatusCode;
    @ApiModelProperty(value = "退款单，关联refund_order.refund_order_id")
    private Long refundOrderId;
    @ApiModelProperty(value = "短信是否发送")
    @NotNull
    private Integer isSmsSend;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    @Transient
    private String combineAddress;
    @Transient
    private List<ConsignmentEntry> consignmentEntryList;
    @Transient
    private String orderCode;

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(final Long consignmentId) {
        this.consignmentId = consignmentId;
    }

    /**
     * @return 关联订单, 关联order.order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 配货单号
     */
    public String getConsignmentCode() {
        return consignmentCode;
    }

    public void setConsignmentCode(final String consignmentCode) {
        this.consignmentCode = consignmentCode;
    }

    /**
     * @return 配送方式, 值集o2of.DELIVERY_TYPE
     */
    public String getDeliveryTypeCode() {
        return deliveryTypeCode;
    }

    public void setDeliveryTypeCode(final String deliveryTypeCode) {
        this.deliveryTypeCode = deliveryTypeCode;
    }

    /**
     * @return 配货单状态, 值集o2of.CONSIGNMENT_STATUS
     */
    public String getConsignmentStatusCode() {
        return consignmentStatusCode;
    }

    public void setConsignmentStatusCode(final String consignmentStatusCode) {
        this.consignmentStatusCode = consignmentStatusCode;
    }

    /**
     * @return 审核日期
     */
    public LocalDateTime getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(final LocalDateTime approvedDate) {
        this.approvedDate = approvedDate;
    }

    /**
     * @return 审核人ID
     */
    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(final Long approverId) {
        this.approverId = approverId;
    }

    /**
     * @return 是否手工审核过
     */
    public Integer getIsManualApproved() {
        return isManualApproved;
    }

    public void setIsManualApproved(final Integer isManualApproved) {
        this.isManualApproved = isManualApproved;
    }

    /**
     * @return 配货人
     */
    public String getConsigner() {
        return consigner;
    }

    public void setConsigner(final String consigner) {
        this.consigner = consigner;
    }

    /**
     * @return 发货日期
     */
    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(final LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return 物流单号
     */
    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(final String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    /**
     * @return 承运商, 关联metadata_carrier.carrier_id
     */
    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(final Long carrierId) {
        this.carrierId = carrierId;
    }

    /**
     * @return 运费
     */
    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(final BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    /**
     * @return 异常原因, 值集o2of.ABNORMAL_REASON
     */
    public String getAbnormalReasonCode() {
        return abnormalReasonCode;
    }

    public void setAbnormalReasonCode(final String abnormalReasonCode) {
        this.abnormalReasonCode = abnormalReasonCode;
    }

    /**
     * @return 异常类型, 值集o2of.ABNORMAL_TYPE
     */
    public String getAbnormalTypeCode() {
        return abnormalTypeCode;
    }

    public void setAbnormalTypeCode(final String abnormalTypeCode) {
        this.abnormalTypeCode = abnormalTypeCode;
    }

    /**
     * @return 备注
     */
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(final String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return 发货回传状态，值集o2of.PROCESSING_STATUS
     */
    public String getDispatchStatusCode() {
        return dispatchStatusCode;
    }

    public void setDispatchStatusCode(final String dispatchStatusCode) {
        this.dispatchStatusCode = dispatchStatusCode;
    }

    /**
     * @return 是否派发配货人员
     */
    public Integer getIsDistributed() {
        return isDistributed;
    }

    public void setIsDistributed(final Integer isDistributed) {
        this.isDistributed = isDistributed;
    }

    /**
     * @return 下发状态，值集o2of.PROCESSING_STATUS
     */
    public String getDistributedStatusCode() {
        return distributedStatusCode;
    }

    public void setDistributedStatusCode(final String distributedStatusCode) {
        this.distributedStatusCode = distributedStatusCode;
    }

    /**
     * @return 退款单，关联refund_order.refund_order_id
     */
    public Long getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(final Long refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    /**
     * @return 短信是否发送
     */
    public Integer getIsSmsSend() {
        return isSmsSend;
    }

    public void setIsSmsSend(final Integer isSmsSend) {
        this.isSmsSend = isSmsSend;
    }

}
