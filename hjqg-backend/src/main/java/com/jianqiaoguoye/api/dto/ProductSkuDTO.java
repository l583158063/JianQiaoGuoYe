package com.jianqiaoguoye.api.dto;

import com.jianqiaoguoye.domain.entity.ProductSku;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Luwx
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("创建订单接收商品")
public class ProductSkuDTO extends ProductSku {

    private Long count;
}
