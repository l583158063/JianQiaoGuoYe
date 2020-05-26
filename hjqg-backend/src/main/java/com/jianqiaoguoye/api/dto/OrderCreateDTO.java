package com.jianqiaoguoye.api.dto;

import com.jianqiaoguoye.domain.entity.OrderAddress;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @author Luwx
 */
@Data
@ApiModel("创建订单接收参数")
public class OrderCreateDTO {

    private List<ProductSkuDTO> productSkuDtoList;

    private OrderAddress orderAddress;

    private String buyerRemarks;
}
