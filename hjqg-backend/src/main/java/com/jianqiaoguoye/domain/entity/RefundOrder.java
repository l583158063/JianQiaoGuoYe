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
import java.math.BigDecimal;
import java.util.Date;

/**
 * 退款单
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("退款单")
@VersionAudit
@ModifyAudit
@Table(name = "refund_order")
public class RefundOrder extends AuditDomain {

    public static final String FIELD_REFUND_ORDER_ID = "refundOrderId";
    public static final String FIELD_REFUND_ORDER_CODE = "refundOrderCode";
    public static final String FIELD_ORDER_ID = "orderId";
    public static final String FIELD_REFUND_TYPE_CODE = "refundTypeCode";
    public static final String FIELD_REFUND_STATUS_CODE = "refundStatusCode";
    public static final String FIELD_REFUND_OPERATION_STATUS_CODE = "refundOperationStatusCode";
    public static final String FIELD_REFUND_REASON_CODE = "refundReasonCode";
    public static final String FIELD_INTERCEPT_STATUS_CODE = "interceptStatusCode";
    public static final String FIELD_REFUND_NOTE = "refundNote";
    public static final String FIELD_IMAGE_URL = "imageUrl";
    public static final String FIELD_INJURED_CONDITION_PERCENTAGE = "injuredConditionPercentage";
    public static final String FIELD_ACTUAL_AMOUNT = "actualAmount";
    public static final String FIELD_REFUND_APPROVER_ID = "refundApproverId";
    public static final String FIELD_REFUND_APPROVED_DATE = "refundApprovedDate";
    public static final String FIELD_REFUNDER_ID = "refunderId";
    public static final String FIELD_ABNORMAL_TYPE = "abnormalType";
    public static final String FIELD_PROCESS_MESSAGE = "processMessage";
    public static final String FIELD_TIMEOUT_PAID_AMOUNT = "timeoutPaidAmount";
    public static final String FIELD_REFUND_WAY = "refundWay";
    public static final String FIELD_IS_SEARCH_REFUND = "isSearchRefund";
    public static final String FIELD_SERVICE_NOTE = "serviceNote";
    public static final String FIELD_IS_NOTIFIED_SUCCESS = "isNotifiedSuccess";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long refundOrderId;
    @ApiModelProperty(value = "退款单编码")
    @NotBlank
    private String refundOrderCode;
    @ApiModelProperty(value = "关联订单")
    @NotNull
    private Long orderId;
    @ApiModelProperty(value = "退款类型,值集：O2RF.REFUND_TYPE")
    private String refundTypeCode;
    @ApiModelProperty(value = "退款状态,值集：O2RF.REFUND_STATUS")
    private String refundStatusCode;
    @ApiModelProperty(value = "退款操作状态,值集：O2RF.REFUND_OPERATION_STATUS")
    private String refundOperationStatusCode;
    @ApiModelProperty(value = "退款原因,值集：O2RF.REFUND_REASON")
    private String refundReasonCode;
    @ApiModelProperty(value = "拦截状态,值集：O2RF.INTERCEPT_STATUS")
    private String interceptStatusCode;
    @ApiModelProperty(value = "退款说明")
    @NotBlank
    private String refundNote;
    @ApiModelProperty(value = "凭证插图")
    private String imageUrl;
    @ApiModelProperty(value = "损坏程度百分数")
    private BigDecimal injuredConditionPercentage;
    @ApiModelProperty(value = "实际退款金额")
    private BigDecimal actualAmount;
    @ApiModelProperty(value = "退款审核人员，关联iam_user.user_id")
    private Long refundApproverId;
    @ApiModelProperty(value = "退款审核日期")
    private Date refundApprovedDate;
    @ApiModelProperty(value = "退款财务人员，关联iam_user.id")
    private Long refunderId;
    @ApiModelProperty(value = "退款异常类型,值集：O2RF.REFUND_ABNORMAL_TYPE")
    private String abnormalType;
    @ApiModelProperty(value = "流程消息")
    private String processMessage;
    @ApiModelProperty(value = "超时赔付金额")
    private BigDecimal timeoutPaidAmount;
    @ApiModelProperty(value = "退款方式")
    private String refundWay;
    @ApiModelProperty(value = "是否已查询退款单状态")
    @NotNull
    private Integer isSearchRefund;
    @ApiModelProperty(value = "客服备注")
    private String serviceNote;
    @ApiModelProperty(value = "是否通知退款成功")
    @NotNull
    private Integer isNotifiedSuccess;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(final Long refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    /**
     * @return 退款单编码
     */
    public String getRefundOrderCode() {
        return refundOrderCode;
    }

    public void setRefundOrderCode(final String refundOrderCode) {
        this.refundOrderCode = refundOrderCode;
    }

    /**
     * @return 关联订单
     */
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 退款类型, 值集：O2RF.REFUND_TYPE
     */
    public String getRefundTypeCode() {
        return refundTypeCode;
    }

    public void setRefundTypeCode(final String refundTypeCode) {
        this.refundTypeCode = refundTypeCode;
    }

    /**
     * @return 退款状态, 值集：O2RF.REFUND_STATUS
     */
    public String getRefundStatusCode() {
        return refundStatusCode;
    }

    public void setRefundStatusCode(final String refundStatusCode) {
        this.refundStatusCode = refundStatusCode;
    }

    /**
     * @return 退款操作状态, 值集：O2RF.REFUND_OPERATION_STATUS
     */
    public String getRefundOperationStatusCode() {
        return refundOperationStatusCode;
    }

    public void setRefundOperationStatusCode(final String refundOperationStatusCode) {
        this.refundOperationStatusCode = refundOperationStatusCode;
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

    /**
     * @return 拦截状态, 值集：O2RF.INTERCEPT_STATUS
     */
    public String getInterceptStatusCode() {
        return interceptStatusCode;
    }

    public void setInterceptStatusCode(final String interceptStatusCode) {
        this.interceptStatusCode = interceptStatusCode;
    }

    /**
     * @return 退款说明
     */
    public String getRefundNote() {
        return refundNote;
    }

    public void setRefundNote(final String refundNote) {
        this.refundNote = refundNote;
    }

    /**
     * @return 凭证插图
     */
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return 损坏程度百分数
     */
    public BigDecimal getInjuredConditionPercentage() {
        return injuredConditionPercentage;
    }

    public void setInjuredConditionPercentage(final BigDecimal injuredConditionPercentage) {
        this.injuredConditionPercentage = injuredConditionPercentage;
    }

    /**
     * @return 实际退款金额
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(final BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * @return 退款审核人员，关联iam_user.user_id
     */
    public Long getRefundApproverId() {
        return refundApproverId;
    }

    public void setRefundApproverId(final Long refundApproverId) {
        this.refundApproverId = refundApproverId;
    }

    /**
     * @return 退款审核日期
     */
    public Date getRefundApprovedDate() {
        return refundApprovedDate;
    }

    public void setRefundApprovedDate(final Date refundApprovedDate) {
        this.refundApprovedDate = refundApprovedDate;
    }

    /**
     * @return 退款财务人员，关联iam_user.id
     */
    public Long getRefunderId() {
        return refunderId;
    }

    public void setRefunderId(final Long refunderId) {
        this.refunderId = refunderId;
    }

    /**
     * @return 退款异常类型, 值集：O2RF.REFUND_ABNORMAL_TYPE
     */
    public String getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(final String abnormalType) {
        this.abnormalType = abnormalType;
    }

    /**
     * @return 流程消息
     */
    public String getProcessMessage() {
        return processMessage;
    }

    public void setProcessMessage(final String processMessage) {
        this.processMessage = processMessage;
    }

    /**
     * @return 超时赔付金额
     */
    public BigDecimal getTimeoutPaidAmount() {
        return timeoutPaidAmount;
    }

    public void setTimeoutPaidAmount(final BigDecimal timeoutPaidAmount) {
        this.timeoutPaidAmount = timeoutPaidAmount;
    }

    /**
     * @return 退款方式
     */
    public String getRefundWay() {
        return refundWay;
    }

    public void setRefundWay(final String refundWay) {
        this.refundWay = refundWay;
    }

    /**
     * @return 是否已查询退款单状态
     */
    public Integer getIsSearchRefund() {
        return isSearchRefund;
    }

    public void setIsSearchRefund(final Integer isSearchRefund) {
        this.isSearchRefund = isSearchRefund;
    }

    /**
     * @return 客服备注
     */
    public String getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(final String serviceNote) {
        this.serviceNote = serviceNote;
    }

    /**
     * @return 是否通知退款成功
     */
    public Integer getIsNotifiedSuccess() {
        return isNotifiedSuccess;
    }

    public void setIsNotifiedSuccess(final Integer isNotifiedSuccess) {
        this.isNotifiedSuccess = isNotifiedSuccess;
    }

}
