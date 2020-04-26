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

/**
 * 商品spu
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@ApiModel("商品spu")
@VersionAudit
@ModifyAudit
@Table(name = "product_spu")
public class ProductSpu extends AuditDomain {

    public static final String FIELD_PRODUCT_SPU_ID = "productSpuId";
    public static final String FIELD_PRODUCT_SPU_CODE = "productSpuCode";
    public static final String FIELD_CATEGORY_ID = "categoryId";
    public static final String FIELD_ATTRIBUTE_SPU_ID = "attributeSpuId";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_POST_STATUS_CODE = "postStatusCode";
    public static final String FIELD_TAX_RATE = "taxRate";
    public static final String FIELD_ORDER_SEQ = "orderSeq";
    public static final String FIELD_IS_ENABLE_EXPRESSED = "isEnableExpressed";
    public static final String FIELD_IS_ENABLE_PICKED_UP = "isEnablePickedUp";
    public static final String FIELD_SHELF_STATUS = "shelfStatus";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_SALES_VOLUME = "salesVolume";
    public static final String FIELD_RECOMMENDATION = "recommendation";
    public static final String FIELD_KEY_WORDS = "keyWords";
    public static final String FIELD_IS_STOP_SELLING = "isStopSelling";
    public static final String FIELD_CUSTOMER_GRADE = "customerGrade";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long productSpuId;
    @ApiModelProperty(value = "商品编码")
    private String productSpuCode;
    @ApiModelProperty(value = "商品类型")
    @NotNull
    private Long categoryId;
    @ApiModelProperty(value = "spu属性")
    private Long attributeSpuId;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "发布状态，值集:O2PCM.POST_STATUS")
    private String postStatusCode;
    @ApiModelProperty(value = "税率")
    private BigDecimal taxRate;
    @ApiModelProperty(value = "排序权重")
    private Long orderSeq;
    @ApiModelProperty(value = "是否支持快递配送")
    @NotNull
    private Integer isEnableExpressed;
    @ApiModelProperty(value = "是否支持自提")
    @NotNull
    private Integer isEnablePickedUp;
    @ApiModelProperty(value = "上下架状态，值集 O2PCM.SHELF_STATUS")
    @NotBlank
    private String shelfStatus;
    @ApiModelProperty(value = "商品描述，支持长文本")
    private String description;
    @ApiModelProperty(value = "销量")
    private BigDecimal salesVolume;
    @ApiModelProperty(value = "推荐语")
    private String recommendation;
    @ApiModelProperty(value = "关键字")
    private String keyWords;
    @ApiModelProperty(value = "是否停止销售")
    @NotNull
    private Integer isStopSelling;
    @ApiModelProperty(value = "买家评分")
    private BigDecimal customerGrade;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(final Long productSpuId) {
        this.productSpuId = productSpuId;
    }

    /**
     * @return 商品编码
     */
    public String getProductSpuCode() {
        return productSpuCode;
    }

    public void setProductSpuCode(final String productSpuCode) {
        this.productSpuCode = productSpuCode;
    }

    /**
     * @return 商品类型
     */
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return spu属性
     */
    public Long getAttributeSpuId() {
        return attributeSpuId;
    }

    public void setAttributeSpuId(final Long attributeSpuId) {
        this.attributeSpuId = attributeSpuId;
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
     * @return 发布状态，值集:O2PCM.POST_STATUS
     */
    public String getPostStatusCode() {
        return postStatusCode;
    }

    public void setPostStatusCode(final String postStatusCode) {
        this.postStatusCode = postStatusCode;
    }

    /**
     * @return 税率
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(final BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return 排序权重
     */
    public Long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(final Long orderSeq) {
        this.orderSeq = orderSeq;
    }

    /**
     * @return 是否支持快递配送
     */
    public Integer getIsEnableExpressed() {
        return isEnableExpressed;
    }

    public void setIsEnableExpressed(final Integer isEnableExpressed) {
        this.isEnableExpressed = isEnableExpressed;
    }

    /**
     * @return 是否支持自提
     */
    public Integer getIsEnablePickedUp() {
        return isEnablePickedUp;
    }

    public void setIsEnablePickedUp(final Integer isEnablePickedUp) {
        this.isEnablePickedUp = isEnablePickedUp;
    }

    /**
     * @return 上下架状态，值集 O2PCM.SHELF_STATUS
     */
    public String getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(final String shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    /**
     * @return 商品描述，支持长文本
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return 销量
     */
    public BigDecimal getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(final BigDecimal salesVolume) {
        this.salesVolume = salesVolume;
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
     * @return 关键字
     */
    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(final String keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * @return 是否停止销售
     */
    public Integer getIsStopSelling() {
        return isStopSelling;
    }

    public void setIsStopSelling(final Integer isStopSelling) {
        this.isStopSelling = isStopSelling;
    }

    /**
     * @return 买家评分
     */
    public BigDecimal getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(final BigDecimal customerGrade) {
        this.customerGrade = customerGrade;
    }

}
