package com.jianqiaoguoye.infra.util;

/**
 * @author Luwx
 */
public interface StringConstant {
    /**
     * 路由映射
     */
    interface Route {
        String DEV_HZERO_ORG = "192.168.1.5";
    }

    /**
     * 商品模块
     */
    interface Product {

        /**
         * 上下架状态
         */
        interface ShelfStatus {
            String LOV_CODE = "JIANQIAO.PRODUCT_SHELF_STATUS";
            // 已上架
            String ON = "ON";
            // 已下架
            String OFF = "OFF";
            // 待上架
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
            String LOV_CODE = "JIANQIAO.ORDER_STATUS";
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

        /**
         * 订单行状态
         */
        interface EntryStatus {
            String LOV_CODE = "JIANQIAO.ORDER_ENTRY_STATUS";
            // 待支付
            String WAITING_PAY = "WAITING_PAY";
            // 已支付
            String PAID = "PAID";
            // 退款中
            String REFUNDING = "REFUNDING";
            // 已退款
            String REFUNDED = "REFUNDED";
        }

        /**
         * 地址
         */
        interface Address {
            String CHINA = "中国";
        }

        /**
         * 编码规则
         */
        String ORDER_CODE = "JIANQIAO.ORDER_CODE";

        /**
         * 配送方式
         */
        interface DeliveryType {
            String LOV_CODE = "JIANQIAO.DELIVERY_TYPE";
            // 快递
            String DELIVERY = "DELIVERY";
            // 自提
            String PICKUP = "PICKUP";
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
            String LOV_CODE = "JIANQIAO.CONSIGNMENT_STATUS";
            // 待审核
            String WAITING_APPROVE = "WAITING_APPROVE";
            // 配货中
            String CONSIGNING = "CONSIGNING";
            // 待发货
            String WAITING_DELIVERY = "WAITING_DELIVERY";
            // 已发货
            String DELIVERED = "DELIVERED";
        }

        /**
         * 承运商
         */
        interface DeliveryCarrier {
            String LOV_CODE = "JIANQIAO.DELIVERY_CARRIER";
            String SHUN_FENG = "SHUN_FENG";
            String ZHONG_TONG = "ZHONG_TONG";
            String YUAN_TONG = "YUAN_TONG";
            String YUN_DA = "YUN_DA";
            String SHEN_TONG = "SHEN_TONG";
            String ZHAI_JI_SONG = "ZHAI_JI_SONG";
        }
    }

    /**
     * 会员
     */
    interface Customer {

        long DEFAULT_CUSTOMER_ID = 1;
    }
}
