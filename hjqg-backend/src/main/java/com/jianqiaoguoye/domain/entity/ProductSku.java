package com.jianqiaoguoye.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hzero.boot.platform.lov.annotation.LovValue;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

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
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_PRODUCT_SPU_ID = "productSpuId";
    public static final String FIELD_STATUS_CODE = "statusCode";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_RECOMMENDATION = "recommendation";
    public static final String FIELD_IS_ELIMINATE_PRICE = "isEliminatePrice";
    public static final String FIELD_IS_ELIMINATE_STOCK_LEVEL = "isEliminateStockLevel";
    public static final String FIELD_IS_EXIST_STOCK = "isExistStock";
    public static final String FIELD_IS_CALCULATE_STOCK_LEVEL = "isCalculateStockLevel";
    public static final String FIELD_HABITAT = "habitat";
    public static final String FIELD_IMAGE_URL = "imageUrl";
    public static final String FIELD_STOCK_LEVEL = "stockLevel";

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
    @NotBlank
    private String productSkuCode;
    @ApiModelProperty(value = "关联商品spuId,product_spu.product_spu_id")
    private Long productSpuId;
    @ApiModelProperty(value = "商品状态,值集：JIANQIAO.PRODUCT_SKU_STATUS_CODE")
    @LovValue(lovCode = "JIANQIAO.PRODUCT_SKU_STATUS_CODE")
    private String statusCode;
    @ApiModelProperty(value = "标题")
    @NotBlank
    private String title;
    @ApiModelProperty(value = "价格")
    @NotNull
    private BigDecimal price;
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
    @ApiModelProperty(value = "产地")
    private String habitat;
    @ApiModelProperty(value = "图片url")
    private String imageUrl;
    @ApiModelProperty(value = "库存")
    private Long stockLevel;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    @Transient
    private String statusMeaning;
    @Transient
    private String spuTitle;
    @Transient
    private String shelfStatus;
    @Transient
    private List<ProductAttributeSku> attributeSkuList;

}
