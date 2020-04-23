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
    public static final String STOCK_LEVEL_LOG = "STOCK_LEVEL_LOG";

    @Autowired
    public SwaggerTags(final Docket docket) {
        docket.tags(
                new Tag(EXAMPLE, "EXAMPLE 案例"),
                new Tag(COMMENT, "评价模块")
        );
    }
}
