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
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单头
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
    public static final String FIELD_IS_MANUAL_RECORDING = "isManualRecording";
    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_IS_MAJOR_CUSTOMER = "isMajorCustomer";
    public static final String FIELD_REMARKS = "remarks";
    public static final String FIELD_IS_DELETE = "isDelete";
    public static final String FIELD_DELIVERY_TIME = "deliveryTime";
    public static final String FIELD_DELIVERY_NUMBER = "deliveryNumber";
    public static final String FIELD_DELIVERY_CARRIER = "deliveryCarrier";
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
    @ApiModelProperty(value = "订单状态,值集O2OF.ORDER_STATUS")
    private String orderStatusCode;
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
    @ApiModelProperty(value = "承运商")
    private String deliveryCarrier;
    @ApiModelProperty(value = "快递是否已发出")
    @NotNull
    private Integer isDeliveryDispatch;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty(value = "订单行列表", hidden = true)
    @Transient
    private List<OrderEntry> orderEntryList;
    @ApiModelProperty(value = "订单地址", hidden = true)
    @Transient
    private OrderAddress orderAddress;

    //
    // getter/setter
    // ------------------------------------------------------------------------------

}
