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
 * 订单头
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("订单头")
@VersionAudit
@ModifyAudit
@Table(name = "order")
public class Order extends AuditDomain {

    public static final String FIELD_ORDER_ID = "orderId";
    public static final String FIELD_ORDER_CODE = "orderCode";
    public static final String FIELD_ORDER_TYPE_CODE = "orderTypeCode";
    public static final String FIELD_ORDER_STATUS_CODE = "orderStatusCode";
    public static final String FIELD_ORDER_FROM_CODE = "orderFromCode";
    public static final String FIELD_BUYER_REMARKS = "buyerRemarks";
    public static final String FIELD_SELLER_REMARKS = "sellerRemarks";
    public static final String FIELD_PAID_TIME = "paidTime";
    public static final String FIELD_IS_PAID = "isPaid";
    public static final String FIELD_PAID_AMOUNT = "paidAmount";
    public static final String FIELD_DISCOUNT_AMOUNT = "discountAmount";
    public static final String FIELD_DELIVERY_COST = "deliveryCost";
    public static final String FIELD_ADDRESS_ID = "addressId";
    public static final String FIELD_DELIVERY_TYPE_CODE = "deliveryTypeCode";
    public static final String FIELD_TOTAL_AMOUNT = "totalAmount";
    public static final String FIELD_IS_MANUAL_APPROVED = "isManualApproved";
    public static final String FIELD_PROCESS_MESSAGE = "processMessage";
    public static final String FIELD_RETURN_ORDER_ID = "returnOrderId";
    public static final String FIELD_IS_COMMENTED = "isCommented";
    public static final String FIELD_INVOICE_STATUS_CODE = "invoiceStatusCode";
    public static final String FIELD_IS_POINT_ACCUMULATE = "isPointAccumulate";
    public static final String FIELD_ORDER_TEMP_CODE = "orderTempCode";
    public static final String FIELD_IS_MANUAL_RECORDING = "isManualRecording";
    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_IS_MAJOR_CUSTOMER = "isMajorCustomer";
    public static final String FIELD_REMARKS = "remarks";
    public static final String FIELD_IS_DELETE = "isDelete";
    public static final String FIELD_DELIVERY_TIME = "deliveryTime";
    public static final String FIELD_DELIVERY_NUMBER = "deliveryNumber";
    public static final String FIELD_IS_DELIVERY_DISPATCH = "isDeliveryDispatch";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long orderId;
    @ApiModelProperty(value = "订单编号")
    @NotBlank
    private String orderCode;
    @ApiModelProperty(value = "订单类型,值集O2OF.ORDER_TYPE")
    private String orderTypeCode;
    @ApiModelProperty(value = "订单状态,值集O2OF.ORDER_STATUS")
    private String orderStatusCode;
    @ApiModelProperty(value = "订单交易来源,值集O2OF.ORDER_FROM")
    private String orderFromCode;
    @ApiModelProperty(value = "买家备注")
    private String buyerRemarks;
    @ApiModelProperty(value = "卖家备注")
    private String sellerRemarks;
    @ApiModelProperty(value = "付款时间")
    private Date paidTime;
    @ApiModelProperty(value = "是否已付款")
    @NotNull
    private Integer isPaid;
    @ApiModelProperty(value = "实付金额,精度2")
    private BigDecimal paidAmount;
    @ApiModelProperty(value = "优惠金额（整单头优惠金额，不包含行优惠金额）")
    private BigDecimal discountAmount;
    @ApiModelProperty(value = "运费金额")
    private BigDecimal deliveryCost;
    @ApiModelProperty(value = "收货地址ID，表order_address.order_address_id")
    private Long addressId;
    @ApiModelProperty(value = "配送方式，值集O2OF.DELIVERY_TYPE")
    private String deliveryTypeCode;
    @ApiModelProperty(value = "总价")
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "是否手工审批")
    @NotNull
    private Integer isManualApproved;
    @ApiModelProperty(value = "日志")
    private String processMessage;
    @ApiModelProperty(value = "退货单id，关联return_order.return_order_id")
    private Long returnOrderId;
    @ApiModelProperty(value = "是否已评价")
    @NotNull
    private Integer isCommented;
    @ApiModelProperty(value = "开票状态,值集：LJOF.INVOICE_STATUS")
    private String invoiceStatusCode;
    @ApiModelProperty(value = "是否累计积分")
    @NotNull
    private Integer isPointAccumulate;
    @ApiModelProperty(value = "临时订单号")
    private String orderTempCode;
    @ApiModelProperty(value = "是否手工单")
    private Integer isManualRecording;
    @ApiModelProperty(value = "会员ID，指向customer_id")
    private Long customerId;
    @ApiModelProperty(value = "是否大客户订单")
    @NotNull
    private Integer isMajorCustomer;
    @ApiModelProperty(value = "备注")
    private String remarks;
    @ApiModelProperty(value = "是否删除")
    @NotNull
    private Integer isDelete;
    @ApiModelProperty(value = "快递配送时间")
    private Date deliveryTime;
    @ApiModelProperty(value = "快递单号")
    private String deliveryNumber;
    @ApiModelProperty(value = "快递是否已发出")
    @NotNull
    private Integer isDeliveryDispatch;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 订单编号
     */
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * @return 订单类型, 值集O2OF.ORDER_TYPE
     */
    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(final String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    /**
     * @return 订单状态, 值集O2OF.ORDER_STATUS
     */
    public String getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(final String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    /**
     * @return 订单交易来源, 值集O2OF.ORDER_FROM
     */
    public String getOrderFromCode() {
        return orderFromCode;
    }

    public void setOrderFromCode(final String orderFromCode) {
        this.orderFromCode = orderFromCode;
    }

    /**
     * @return 买家备注
     */
    public String getBuyerRemarks() {
        return buyerRemarks;
    }

    public void setBuyerRemarks(final String buyerRemarks) {
        this.buyerRemarks = buyerRemarks;
    }

    /**
     * @return 卖家备注
     */
    public String getSellerRemarks() {
        return sellerRemarks;
    }

    public void setSellerRemarks(final String sellerRemarks) {
        this.sellerRemarks = sellerRemarks;
    }

    /**
     * @return 付款时间
     */
    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(final Date paidTime) {
        this.paidTime = paidTime;
    }

    /**
     * @return 是否已付款
     */
    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(final Integer isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * @return 实付金额, 精度2
     */
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(final BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * @return 优惠金额（整单头优惠金额，不包含行优惠金额）
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(final BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * @return 运费金额
     */
    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(final BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    /**
     * @return 收货地址ID，表order_address.order_address_id
     */
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(final Long addressId) {
        this.addressId = addressId;
    }

    /**
     * @return 配送方式，值集O2OF.DELIVERY_TYPE
     */
    public String getDeliveryTypeCode() {
        return deliveryTypeCode;
    }

    public void setDeliveryTypeCode(final String deliveryTypeCode) {
        this.deliveryTypeCode = deliveryTypeCode;
    }

    /**
     * @return 总价
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return 是否手工审批
     */
    public Integer getIsManualApproved() {
        return isManualApproved;
    }

    public void setIsManualApproved(final Integer isManualApproved) {
        this.isManualApproved = isManualApproved;
    }

    /**
     * @return 日志
     */
    public String getProcessMessage() {
        return processMessage;
    }

    public void setProcessMessage(final String processMessage) {
        this.processMessage = processMessage;
    }

    /**
     * @return 退货单id，关联return_order.return_order_id
     */
    public Long getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(final Long returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    /**
     * @return 是否已评价
     */
    public Integer getIsCommented() {
        return isCommented;
    }

    public void setIsCommented(final Integer isCommented) {
        this.isCommented = isCommented;
    }

    /**
     * @return 开票状态, 值集：LJOF.INVOICE_STATUS
     */
    public String getInvoiceStatusCode() {
        return invoiceStatusCode;
    }

    public void setInvoiceStatusCode(final String invoiceStatusCode) {
        this.invoiceStatusCode = invoiceStatusCode;
    }

    /**
     * @return 是否累计积分
     */
    public Integer getIsPointAccumulate() {
        return isPointAccumulate;
    }

    public void setIsPointAccumulate(final Integer isPointAccumulate) {
        this.isPointAccumulate = isPointAccumulate;
    }

    /**
     * @return 临时订单号
     */
    public String getOrderTempCode() {
        return orderTempCode;
    }

    public void setOrderTempCode(final String orderTempCode) {
        this.orderTempCode = orderTempCode;
    }

    /**
     * @return 是否手工单
     */
    public Integer getIsManualRecording() {
        return isManualRecording;
    }

    public void setIsManualRecording(final Integer isManualRecording) {
        this.isManualRecording = isManualRecording;
    }

    /**
     * @return 会员ID，指向customer_id
     */
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return 是否大客户订单
     */
    public Integer getIsMajorCustomer() {
        return isMajorCustomer;
    }

    public void setIsMajorCustomer(final Integer isMajorCustomer) {
        this.isMajorCustomer = isMajorCustomer;
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
     * @return 是否删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(final Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return 快递配送时间
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(final Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * @return 快递单号
     */
    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(final String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    /**
     * @return 快递是否已发出
     */
    public Integer getIsDeliveryDispatch() {
        return isDeliveryDispatch;
    }

    public void setIsDeliveryDispatch(final Integer isDeliveryDispatch) {
        this.isDeliveryDispatch = isDeliveryDispatch;
    }

}
