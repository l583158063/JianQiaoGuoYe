package com.jianqiaoguoye.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@ApiModel("购物车行")
@Data
public class CartEntry {
    public static final String FIELD_USER_ID = "userId";
    public static final String FIELD_SKU_ID = "skuId";
    public static final String FIELD_CART_ENTRY_CODE = "cartEntryCode";
    public static final String FIELD_DELIVERY_TYPE_CODE = "deliveryTypeCode";
    public static final String FIELD_POS_ID = "posId";
    public static final String FIELD_SHOP_ID = "shopId";
    public static final String FIELD_SHOP_CODE = "shopCode";

    @ApiModelProperty("购物车行编码")
    private String cartEntryCode;

    @ApiModelProperty("会员ID")
    private Long userId;

    @ApiModelProperty("商品skuId")
    private Long skuId;

    @ApiModelProperty("商品sku编码")
    private String skuCode;

    @ApiModelProperty("商品名称")
    private String title;

    @ApiModelProperty("商品单价")
    private BigDecimal unitPrice;

    @ApiModelProperty("商品数量")
    private Long quantity;

    @ApiModelProperty("物流方式编码")
    private String deliveryTypeCode;

    @ApiModelProperty("物流方式含义")
    private String deliveryTypeMeaning;

    @ApiModelProperty("图片url")
    private String mediaUrl;

    @ApiModelProperty("新增时间")
    private Date addTime;

    @ApiModelProperty("商品spuId")
    private Long spuId;

    @ApiModelProperty("商品spuCode")
    private String spuCode;

    private Integer isValid;

    @ApiModelProperty("商品库存")
    private Long stock;

    @ApiModelProperty("购物车唯一标识")
    private String cartCode;

    @ApiModelProperty(value = "是否选中")
    private Integer isSelected;

    @ApiModelProperty(value = "行总价")
    private BigDecimal paidAmount;

    public CartEntry() {
        this.setQuantity(0L);
        this.unitPrice = new BigDecimal("0");
    }


}
