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
}
