package com.jianqiaoguoye.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 */
@Configuration
public class SwaggerTags {

    public static final String EXAMPLE = "Example";
    public static final String COMMENT = "Comment";
    public static final String CONSIGNMENT = "Consignment";
    public static final String CONSIGNMENT_ENTRY = "Consignment Entry";
    public static final String CUSTOMER = "Customer";
    public static final String ORDER = "Order";
    public static final String ORDER_ENTRY = "Order Entry";
    public static final String ORDER_ADDRESS = "Order Address";
    public static final String ORDER_PROCESS_LOG = "Order Process Log";
    public static final String PAY_INFO = "Pay Info";
    public static final String PRODUCT_ATTRIBUTE_SKU = "Product Attribute Sku";
    public static final String PRODUCT_ATTRIBUTE_SPU = "Product Attribute Spu";
    public static final String PRODUCT_CATEGORY = "Product Category";
    public static final String PRODUCT_SKU = "Product Sku";
    public static final String PRODUCT_SKU_PRICE = "Product Spu Price";
    public static final String PRODUCT_SPU = "Product Spu";
    public static final String REFUND_ORDER = "Refund Order";
    public static final String REFUND_ORDER_ENTRY = "Refund Order Entry";
    public static final String STOCK_LEVEL = "Stock Level";
    public static final String STOCK_LEVEL_LOG = "Stock Level Log";
    public static final String METADATA_CARRIER = "Metadata Carrier";
    public static final String METADATA_COUNTRY = "Metadata Country";
    public static final String METADATA_REGION = "Metadata Region";

    @Autowired
    public SwaggerTags(final Docket docket) {
        docket.tags(
                new Tag(EXAMPLE, "EXAMPLE 案例"),
                new Tag(COMMENT, "会员评价"),
                new Tag(CONSIGNMENT, "配货单"),
                new Tag(CONSIGNMENT_ENTRY, "配货单行"),
                new Tag(CUSTOMER, "会员"),
                new Tag(ORDER, "订单"),
                new Tag(ORDER_ENTRY, "订单行"),
                new Tag(ORDER_ADDRESS, "订单地址"),
                new Tag(ORDER_PROCESS_LOG, "订单处理日志"),
                new Tag(PAY_INFO, "支付信息"),
                new Tag(PRODUCT_ATTRIBUTE_SKU, "商品 SKU 属性"),
                new Tag(PRODUCT_ATTRIBUTE_SPU, "商品 SPU 属性"),
                new Tag(PRODUCT_CATEGORY, "商品类别"),
                new Tag(PRODUCT_SKU, "商品 SKU"),
                new Tag(PRODUCT_SKU_PRICE, "商品价格"),
                new Tag(PRODUCT_SPU, "商品 SPU"),
                new Tag(REFUND_ORDER, "退款单"),
                new Tag(REFUND_ORDER_ENTRY, "退款单行"),
                new Tag(STOCK_LEVEL, "库存"),
                new Tag(STOCK_LEVEL_LOG, "库存日志"),
                new Tag(METADATA_CARRIER, "承运商定义"),
                new Tag(METADATA_COUNTRY, "国家定义"),
                new Tag(METADATA_REGION, "地区定义")
        );
    }
}
