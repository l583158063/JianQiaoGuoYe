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

/**
 * 订单行
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
    @ApiModelProperty(value = "商品skuId，关联表product_sku")
    @NotNull
    private Long productSkuId;
    @ApiModelProperty(value = "是否赠品")
    @NotNull
    private Integer isGift;
    @ApiModelProperty(value = "会员实际支付金额")
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

    @Transient
    @ApiModelProperty(value = "商品sku名称")
    private String title;
    @Transient
    @ApiModelProperty(value = "商品sku编码")
    private String productSkuCode;

    //
    // getter/setter
    // ------------------------------------------------------------------------------

}
