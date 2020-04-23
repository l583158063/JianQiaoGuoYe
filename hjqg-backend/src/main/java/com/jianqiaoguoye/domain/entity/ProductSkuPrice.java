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
import java.util.Date;

/**
 * 价格表
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("价格表")
@VersionAudit
@ModifyAudit
@Table(name = "product_sku_price")
public class ProductSkuPrice extends AuditDomain {

    public static final String FIELD_PRICE_ID = "priceId";
    public static final String FIELD_PRODUCT_SKU_ID = "productSkuId";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_CURRENCY_TYPE_CODE = "currencyTypeCode";
    public static final String FIELD_DATE_FROM = "dateFrom";
    public static final String FIELD_DATE_TO = "dateTo";
    public static final String FIELD_IS_DELETE = "isDelete";
    public static final String FIELD_VERSION_NUMBER = "versionNumber";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long priceId;
    @ApiModelProperty(value = "sku商品id，关联product_sku.product_sku_id", required = true)
    @NotNull
    private Long productSkuId;
    @ApiModelProperty(value = "价格", required = true)
    @NotNull
    private BigDecimal price;
    @ApiModelProperty(value = "货币类型,值集：O2PCM.CURRENCY_TYPE", required = true)
    @NotBlank
    private String currencyTypeCode;
    @ApiModelProperty(value = "开始日期", required = true)
    @NotNull
    private Date dateFrom;
    @ApiModelProperty(value = "结束日期", required = true)
    @NotNull
    private Date dateTo;
    @ApiModelProperty(value = "是否删除", required = true)
    @NotNull
    private Integer isDelete;
    @ApiModelProperty(value = "价格版本号", required = true)
    @NotNull
    private Long versionNumber;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(final Long priceId) {
        this.priceId = priceId;
    }

    /**
     * @return sku商品id，关联product_sku.product_sku_id
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(final Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * @return 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    /**
     * @return 货币类型, 值集：O2PCM.CURRENCY_TYPE
     */
    public String getCurrencyTypeCode() {
        return currencyTypeCode;
    }

    public void setCurrencyTypeCode(final String currencyTypeCode) {
        this.currencyTypeCode = currencyTypeCode;
    }

    /**
     * @return 开始日期
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(final Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * @return 结束日期
     */
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(final Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * @return 是否删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(final Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return 价格版本号
     */
    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(final Long versionNumber) {
        this.versionNumber = versionNumber;
    }

}
