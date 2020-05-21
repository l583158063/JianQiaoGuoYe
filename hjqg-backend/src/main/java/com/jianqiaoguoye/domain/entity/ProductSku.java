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

/**
 * 商品sku
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("商品sku")
@VersionAudit
@ModifyAudit
@Table(name = "product_sku")
public class ProductSku extends AuditDomain {

    public static final String FIELD_PRODUCT_SKU_ID = "productSkuId";
    public static final String FIELD_PRODUCT_SKU_CODE = "productSkuCode";
    public static final String FIELD_CATEGORY_ID = "categoryId";
    public static final String FIELD_ATTRIBUTE_SKU_ID = "attributeSkuId";
    public static final String FIELD_PRODUCT_SPU_ID = "productSpuId";
    public static final String FIELD_STATUS_CODE = "statusCode";
    public static final String FIELD_ONLINE_DATE = "onlineDate";
    public static final String FIELD_OFFLINE_DATE = "offlineDate";
    public static final String FIELD_SHELF_STATUS = "shelfStatus";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_RECOMMENDATION = "recommendation";
    public static final String FIELD_IS_ELIMINATE_PRICE = "isEliminatePrice";
    public static final String FIELD_IS_ELIMINATE_STOCK_LEVEL = "isEliminateStockLevel";
    public static final String FIELD_IS_EXIST_STOCK = "isExistStock";
    public static final String FIELD_IS_CALCULATE_STOCK_LEVEL = "isCalculateStockLevel";
    public static final String FIELD_COUNTRY_ID = "countryId";
    public static final String FIELD_REGION_ID = "regionId";
    public static final String FIELD_IMAGE_URL = "imageUrl";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long productSkuId;
    @ApiModelProperty(value = "sku编码")
    private String productSkuCode;
    @ApiModelProperty(value = "关联商品spuId,product_spu.product_spu_id")
    private Long productSpuId;
    @ApiModelProperty(value = "商品状态,值集：O2PCM.PRODUCT_STATUS")
    private String statusCode;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "推荐语")
    private String recommendation;
    @ApiModelProperty(value = "是否排除价格")
    private Integer isEliminatePrice;
    @ApiModelProperty(value = "是否排除库存")
    private Integer isEliminateStockLevel;
    @ApiModelProperty(value = "是否有库存")
    private Integer isExistStock;
    @ApiModelProperty(value = "上下架是否已出发库存计算")
    private Integer isCalculateStockLevel;
    @ApiModelProperty(value = "产地，国家")
    private Long countryId;
    @ApiModelProperty(value = "产地，地区")
    private Long regionId;
    @ApiModelProperty(value = "图片url")
    private String imageUrl;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    @Transient
    private String statusMeaning;
    @Transient
    @ApiModelProperty(value = "国家名称")
    private String countryName;

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(final Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * @return sku编码
     */
    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(final String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    /**
     * @return 图片url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return 关联商品spuId, product_spu.product_spu_id
     */
    public Long getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(final Long productSpuId) {
        this.productSpuId = productSpuId;
    }

    /**
     * @return 商品状态, 值集：O2PCM.PRODUCT_STATUS
     */
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return 标题
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return 推荐语
     */
    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(final String recommendation) {
        this.recommendation = recommendation;
    }

    /**
     * @return 是否排除价格
     */
    public Integer getIsEliminatePrice() {
        return isEliminatePrice;
    }

    public void setIsEliminatePrice(final Integer isEliminatePrice) {
        this.isEliminatePrice = isEliminatePrice;
    }

    /**
     * @return 是否排除库存
     */
    public Integer getIsEliminateStockLevel() {
        return isEliminateStockLevel;
    }

    public void setIsEliminateStockLevel(final Integer isEliminateStockLevel) {
        this.isEliminateStockLevel = isEliminateStockLevel;
    }

    /**
     * @return 是否有库存
     */
    public Integer getIsExistStock() {
        return isExistStock;
    }

    public void setIsExistStock(final Integer isExistStock) {
        this.isExistStock = isExistStock;
    }

    /**
     * @return 上下架是否已出发库存计算
     */
    public Integer getIsCalculateStockLevel() {
        return isCalculateStockLevel;
    }

    public void setIsCalculateStockLevel(final Integer isCalculateStockLevel) {
        this.isCalculateStockLevel = isCalculateStockLevel;
    }

    /**
     * @return 产地，国家
     */
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(final Long countryId) {
        this.countryId = countryId;
    }

    /**
     * @return 产地，地区
     */
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(final Long regionId) {
        this.regionId = regionId;
    }

}
