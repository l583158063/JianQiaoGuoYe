package com.jianqiaoguoye.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hzero.boot.platform.lov.annotation.LovValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品spu
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("商品spu")
@VersionAudit
@ModifyAudit
@Table(name = "product_spu")
public class ProductSpu extends AuditDomain {

    public static final String FIELD_PRODUCT_SPU_ID = "productSpuId";
    public static final String FIELD_PRODUCT_SPU_CODE = "productSpuCode";
    public static final String FIELD_CATEGORY_ID = "categoryId";
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

    /**
     * 设置价格区间
     */
    public void setupPriceRange() {
        if (null == maxPrice && null == minPrice) {
            priceRange = "-";
        } else {
            if (null == maxPrice) {
                throw new IllegalArgumentException("The field maxPrice must be not null!");
            }
            if (0 != maxPrice.compareTo(minPrice)) {
                priceRange = minPrice + "-" + maxPrice;
            } else {
                priceRange = maxPrice.toString();
            }
        }
    }

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long productSpuId;
    @ApiModelProperty(value = "商品编码")
    @NotBlank
    private String productSpuCode;
    @ApiModelProperty(value = "商品类型")
    @NotNull
    private Long categoryId;
    @ApiModelProperty(value = "标题")
    @NotBlank
    private String title;
    @ApiModelProperty(value = "发布状态，值集: JIANQIAO.PRODUCT_POST_STATUS")
    @LovValue(lovCode = "JIANQIAO.PRODUCT_POST_STATUS")
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
    @ApiModelProperty(value = "上下架状态，值集: JIANQIAO.PRODUCT_SHELF_STATUS")
    @NotBlank
    @LovValue(lovCode = "JIANQIAO.PRODUCT_SHELF_STATUS")
    private String shelfStatus;
    @ApiModelProperty(value = "上架日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime onlineDate;
    @ApiModelProperty(value = "下架日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime offlineDate;
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

    @Transient
    private String postStatusMeaning;
    @Transient
    private String shelfStatusMeaning;
    @Transient
    private String categoryCode;
    @Transient
    private String categoryName;
    @Transient
    private BigDecimal maxPrice;
    @Transient
    private BigDecimal minPrice;
    @Transient
    private String priceRange;

    //
    // getter/setter
    // ------------------------------------------------------------------------------


}
