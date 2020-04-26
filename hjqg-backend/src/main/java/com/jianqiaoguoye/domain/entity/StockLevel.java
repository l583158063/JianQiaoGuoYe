package com.jianqiaoguoye.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 库存
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("库存")
@VersionAudit
@ModifyAudit
@Table(name = "stock_level")
public class StockLevel extends AuditDomain {

    public static final String FIELD_STOCK_LEVEL_ID = "stockLevelId";
    public static final String FIELD_PRODUCT_SKU_ID = "productSkuId";
    public static final String FIELD_INITIAL_QUANTITY = "initialQuantity";
    public static final String FIELD_IN_STOCK = "inStock";
    public static final String FIELD_RESERVED_QUANTITY = "reservedQuantity";
    public static final String FIELD_LAST_MODIFIED_TIME = "lastModifiedTime";
    public static final String FIELD_LAST_FULL_TIMESTAMP = "lastFullTimestamp";
    public static final String FIELD_SHELF_LIFE_TO = "shelfLifeTo";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long stockLevelId;
    @ApiModelProperty(value = "商品skuId")
    @NotNull
    private Long productSkuId;
    @ApiModelProperty(value = "初始量")
    @NotNull
    private Long initialQuantity;
    @ApiModelProperty(value = "现有量")
    @NotNull
    private Long inStock;
    @ApiModelProperty(value = "保留量")
    @NotNull
    private Long reservedQuantity;
    @ApiModelProperty(value = "上次修改时间")
    @NotNull
    private Date lastModifiedTime;
    @ApiModelProperty(value = "全量时间戳")
    private Long lastFullTimestamp;
    @ApiModelProperty(value = "保质期截止日期")
    @NotNull
    private Date shelfLifeTo;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return
     */
    public Long getStockLevelId() {
        return stockLevelId;
    }

    public void setStockLevelId(final Long stockLevelId) {
        this.stockLevelId = stockLevelId;
    }

    /**
     * @return 商品skuId
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(final Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * @return 初始量
     */
    public Long getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(final Long initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    /**
     * @return 现有量
     */
    public Long getInStock() {
        return inStock;
    }

    public void setInStock(final Long inStock) {
        this.inStock = inStock;
    }

    /**
     * @return 保留量
     */
    public Long getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(final Long reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    /**
     * @return 上次修改时间
     */
    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(final Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * @return 全量时间戳
     */
    public Long getLastFullTimestamp() {
        return lastFullTimestamp;
    }

    public void setLastFullTimestamp(final Long lastFullTimestamp) {
        this.lastFullTimestamp = lastFullTimestamp;
    }

    /**
     * @return 保质期截止日期
     */
    public Date getShelfLifeTo() {
        return shelfLifeTo;
    }

    public void setShelfLifeTo(final Date shelfLifeTo) {
        this.shelfLifeTo = shelfLifeTo;
    }

}
