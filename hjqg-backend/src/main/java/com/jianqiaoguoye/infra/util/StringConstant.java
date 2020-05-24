package com.jianqiaoguoye.infra.util;

/**
 * @author Luwx
 */
public interface StringConstant {

    /**
     * 商品模块
     */
    interface Product {

        /**
         * 上下架状态
         */
        interface ShelfStatus {
            String ON = "ON";
            String OFF = "OFF";
            String PENDING = "PENDING";
        }

        /**
         * 图片相关
         */
        interface ImageFile {
            String BUCKET = "product-sku-images";
        }
    }

    /**
     * 订单模块
     */
    interface Order {

        /**
         * 订单状态
         */
        interface OrderStatus {
            // 待支付
            String WAITING_PAY = "WAITING_PAY";
            // 待确认
            String WAITING_CONFIRM = "WAITING_CONFIRM";
            // 配货中
            String CONSIGNING = "CONSIGNING";
            // 运送中
            String DELIVERING = "DELIVERING";
            // 待评价
            String WAITING_COMMENT = "WAITING_COMMENT";
            // 已完成
            String COMPLETE = "COMPLETE";
            // 退款中
            String REFUNDING = "REFUNDING";
        }
    }

    /**
     * 配货单模块
     */
    interface Consignment {

        /**
         * 配货单状态
         */
        interface ConsignmentStatus {
            // 待审核
            String WAITING_APPROVE = "WAITING_APPROVE";
            // 配货中
            String CONSIGNING = "CONSIGNING";
            // 待发货
            String WAITING_DELIVERY = "WAITING_DELIVERY";
            // 已发货
            String DELIVERED = "DELIVERED";
        }
    }
}
