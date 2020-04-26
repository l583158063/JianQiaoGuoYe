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

/**
 * 订单行
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("订单行")
@VersionAudit
@ModifyAudit
@Table(name = "order_entry")
public class OrderEntry extends AuditDomain {

    public static final String FIELD_ORDER_ENTRY_ID = "orderEntryId";
    public static final String FIELD_ORDER_ID = "orderId";
    public static final String FIELD_ENTRY_NUMBER = "entryNumber";
    public static final String FIELD_QUANTITY = "quantity";
    public static final String FIELD_UNIT_PRICE = "unitPrice";
    public static final String FIELD_ADJUST_AMOUNT = "adjustAmount";
    public static final String FIELD_DISCOUNT_AMOUNT = "discountAmount";
    public static final String FIELD_PRODUCT_SKU_ID = "productSkuId";
    public static final String FIELD_IS_GIFT = "isGift";
    public static final String FIELD_RETAIL_AMOUNT = "retailAmount";
    public static final String FIELD_ACTUAL_PAID_AMOUNT = "actualPaidAmount";
    public static final String FIELD_RETURN_ORDER_ENTRY_ID = "returnOrderEntryId";
    public static final String FIELD_IS_RETURNED = "isReturned";
    public static final String FIELD_COST_PRICE = "costPrice";
    public static final String FIELD_STATUS_CODE = "statusCode";
    public static final String FIELD_IS_DISCOUNT_PRICE = "isDiscountPrice";
    public static final String FIELD_REMARKS = "remarks";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long orderEntryId;
    @ApiModelProperty(value = "订单ID，关联order.order_id")
    @NotNull
    private Long orderId;
    @ApiModelProperty(value = "订单行序号")
    @NotNull
    private Long entryNumber;
    @ApiModelProperty(value = "商品数量")
    @NotNull
    private Long quantity;
    @ApiModelProperty(value = "商品单价")
    @NotNull
    private BigDecimal unitPrice;
    @ApiModelProperty(value = "卖家手工调整行总金额")
    private BigDecimal adjustAmount;
    @ApiModelProperty(value = "行优惠金额")
    private BigDecimal discountAmount;
    @ApiModelProperty(value = "SKU平台商品ID，关联表product_sku")
    @NotNull
    private Long productSkuId;
    @ApiModelProperty(value = "是否赠品")
    @NotNull
    private Integer isGift;
    @ApiModelProperty(value = "销售金额")
    private BigDecimal retailAmount;
    @ApiModelProperty(value = "顾客实际支付金额")
    private BigDecimal actualPaidAmount;
    @ApiModelProperty(value = "退货单行id，关联return_order_entry.return_order_entry_id")
    private Long returnOrderEntryId;
    @ApiModelProperty(value = "是否退货")
    @NotNull
    private Integer isReturned;
    @ApiModelProperty(value = "成本价")
    private BigDecimal costPrice;
    @ApiModelProperty(value = "订单行状态,值集O2OF.ORDER_ENTRY_STATUS")
    @NotBlank
    private String statusCode;
    @ApiModelProperty(value = "是否折扣价")
    @NotNull
    private Integer isDiscountPrice;
    @ApiModelProperty(value = "备注")
    private String remarks;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getOrderEntryId() {
        return orderEntryId;
    }

    public void setOrderEntryId(final Long orderEntryId) {
        this.orderEntryId = orderEntryId;
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
     * @return 订单行序号
     */
    public Long getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(final Long entryNumber) {
        this.entryNumber = entryNumber;
    }

    /**
     * @return 商品数量
     */
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(final Long quantity) {
        this.quantity = quantity;
    }

    /**
     * @return 商品单价
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(final BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return 卖家手工调整行总金额
     */
    public BigDecimal getAdjustAmount() {
        return adjustAmount;
    }

    public void setAdjustAmount(final BigDecimal adjustAmount) {
        this.adjustAmount = adjustAmount;
    }

    /**
     * @return 行优惠金额
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(final BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * @return SKU平台商品ID，关联表product_sku
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(final Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * @return 是否赠品
     */
    public Integer getIsGift() {
        return isGift;
    }

    public void setIsGift(final Integer isGift) {
        this.isGift = isGift;
    }

    /**
     * @return 销售金额
     */
    public BigDecimal getRetailAmount() {
        return retailAmount;
    }

    public void setRetailAmount(final BigDecimal retailAmount) {
        this.retailAmount = retailAmount;
    }

    /**
     * @return 顾客实际支付金额
     */
    public BigDecimal getActualPaidAmount() {
        return actualPaidAmount;
    }

    public void setActualPaidAmount(final BigDecimal actualPaidAmount) {
        this.actualPaidAmount = actualPaidAmount;
    }

    /**
     * @return 退货单行id，关联return_order_entry.return_order_entry_id
     */
    public Long getReturnOrderEntryId() {
        return returnOrderEntryId;
    }

    public void setReturnOrderEntryId(final Long returnOrderEntryId) {
        this.returnOrderEntryId = returnOrderEntryId;
    }

    /**
     * @return 是否退货
     */
    public Integer getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(final Integer isReturned) {
        this.isReturned = isReturned;
    }

    /**
     * @return 成本价
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(final BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * @return 订单行状态, 值集O2OF.ORDER_ENTRY_STATUS
     */
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return 是否折扣价
     */
    public Integer getIsDiscountPrice() {
        return isDiscountPrice;
    }

    public void setIsDiscountPrice(final Integer isDiscountPrice) {
        this.isDiscountPrice = isDiscountPrice;
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

}
