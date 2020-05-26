package com.jianqiaoguoye.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.jianqiaoguoye.api.dto.OrderCreateDTO;
import com.jianqiaoguoye.api.dto.ProductSkuDTO;
import com.jianqiaoguoye.app.service.OrderService;
import com.jianqiaoguoye.domain.entity.Consignment;
import com.jianqiaoguoye.domain.entity.ConsignmentEntry;
import com.jianqiaoguoye.domain.entity.Order;
import com.jianqiaoguoye.domain.entity.OrderAddress;
import com.jianqiaoguoye.domain.entity.OrderEntry;
import com.jianqiaoguoye.domain.entity.ProductSku;
import com.jianqiaoguoye.domain.entity.ProductSpu;
import com.jianqiaoguoye.domain.repository.ConsignmentEntryRepository;
import com.jianqiaoguoye.domain.repository.ConsignmentRepository;
import com.jianqiaoguoye.domain.repository.OrderAddressRepository;
import com.jianqiaoguoye.domain.repository.OrderEntryRepository;
import com.jianqiaoguoye.domain.repository.OrderRepository;
import com.jianqiaoguoye.domain.repository.ProductSkuRepository;
import com.jianqiaoguoye.domain.repository.ProductSpuRepository;
import com.jianqiaoguoye.infra.util.StringConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.boot.platform.code.constant.CodeConstants;
import org.hzero.core.base.BaseConstants;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 订单头应用服务默认实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:28
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderEntryRepository orderEntryRepository;
    @Autowired
    private ConsignmentRepository consignmentRepository;
    @Autowired
    private ConsignmentEntryRepository consignmentEntryRepository;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;
    @Autowired
    private ProductSkuRepository productSkuRepository;
    @Autowired
    private ProductSpuRepository productSpuRepository;
    @Autowired
    private OrderAddressRepository orderAddressRepository;

    @Override
    public List<Order> list(Order order) {
        order = (Objects.isNull(order)) ? new Order() : order;
        return orderRepository.list(order);
    }

    @Override
    public String confirmOrder(Long orderId) {
        // 更新订单数据
        Order order = orderRepository.selectByPrimaryKey(orderId);
        Assert.isTrue(null != order, "订单不存在: " + orderId);

        order.setOrderStatusCode(StringConstant.Order.OrderStatus.CONSIGNING);
        order.setIsManualApproved(BaseConstants.Digital.ONE);
        order.appendProcessMsg("订单已确认");

        orderRepository.updateByPrimaryKeySelective(order);

        // 生成配货单
        Consignment consignment = new Consignment();
        // 校验是否已存在配货单
        consignment.setOrderId(orderId);
        List<Consignment> existConsignmentList = consignmentRepository.select(consignment);
        if (CollectionUtils.isNotEmpty(existConsignmentList)) {
            return null;
        }
        // 组装配货单数据
        installConsignment(consignment, order);
        // 生成配货单头，回填id
        consignmentRepository.insertSelective(consignment);

        // 组装配货单行数据
        installConsignmentEntry(consignment, order);
        // 生成配货单行
        consignmentEntryRepository.batchInsertSelective(consignment.getConsignmentEntryList());

        return consignment.getConsignmentCode();
    }

    private void installConsignment(Consignment consignment, Order order) {
        consignment.setConsignmentCode(order.getOrderCode());
        consignment.setDeliveryTypeCode(order.getDeliveryTypeCode());
        consignment.setConsignmentStatusCode(StringConstant.Consignment.ConsignmentStatus.WAITING_APPROVE);
        consignment.setRemarks(order.getRemarks());
    }

    private void installConsignmentEntry(Consignment consignment, Order order) {
        List<OrderEntry> orderEntryList = orderEntryRepository.listByOrderId(order.getOrderId());
        Assert.isTrue(CollectionUtils.isNotEmpty(orderEntryList), "订单行不存在: " + order.getOrderId());

        List<ConsignmentEntry> consignmentEntryList = new ArrayList<>();
        orderEntryList.forEach(orderEntry -> {
            ConsignmentEntry consignmentEntry = new ConsignmentEntry();
            consignmentEntry.setConsignmentId(consignment.getConsignmentId());
            consignmentEntry.setEntryNumber(orderEntry.getEntryNumber());
            consignmentEntry.setOrderEntryId(orderEntry.getOrderEntryId());
            consignmentEntry.setRemarks(orderEntry.getRemarks());
            consignmentEntryList.add(consignmentEntry);
        });

        consignment.setConsignmentEntryList(consignmentEntryList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> createOrder(OrderCreateDTO orderCreateDTO) {
        List<ProductSkuDTO> productSkuDtoList = orderCreateDTO.getProductSkuDtoList();
        String valid = validateStock(productSkuDtoList);

        if (StringUtils.isNotBlank(valid)) {
            return Results.invalid(valid);
        }

        // 库存更新
        List<ProductSku> productSkuList = new ArrayList<>();
        for (ProductSkuDTO dto : productSkuDtoList) {
            ProductSku sku = new ProductSku();
            sku.setProductSkuId(dto.getProductSkuId());
            Long stockLevel = dto.getStockLevel();
            sku.setStockLevel(stockLevel);
            sku.setIsExistStock(stockLevel > 0 ? 1 : 0);
            sku.setObjectVersionNumber(dto.getObjectVersionNumber());
            productSkuList.add(sku);
        }
        productSkuRepository.batchUpdateByPrimaryKeySelective(productSkuList);

        // 订单地址生成（未校验）
        OrderAddress orderAddress = orderCreateDTO.getOrderAddress();
        orderAddress.setCustomerId(StringConstant.Customer.DEFAULT_CUSTOMER_ID);
        orderAddress.setCountry(StringConstant.Order.Address.CHINA);
        orderAddressRepository.insertSelective(orderAddress);

        Order order = new Order();
        // 订单编码生成规则
        String orderCode = codeRuleBuilder.generateCode(BaseConstants.DEFAULT_TENANT_ID, StringConstant.Order.ORDER_CODE,
                CodeConstants.CodeRuleLevelCode.GLOBAL, CodeConstants.CodeRuleLevelCode.GLOBAL, null);
        order.setOrderCode(orderCode);
        order.setOrderStatusCode(StringConstant.Order.OrderStatus.WAITING_CONFIRM);
        order.setTotalAmount(calculateTotalAmount(productSkuDtoList));
        order.appendProcessMsg("已支付");
        order.setPaidAmount(order.getTotalAmount());
        order.setPaidTime(LocalDateTime.now());
        order.setIsPaid(BaseConstants.Digital.ONE);
        order.setBuyerRemarks(orderCreateDTO.getBuyerRemarks());
        order.setCustomerId(StringConstant.Customer.DEFAULT_CUSTOMER_ID);
        order.setAddressId(orderAddress.getOrderAddressId());
        orderRepository.insertSelective(order);

        // 订单行
        List<OrderEntry> orderEntryList = new ArrayList<>();
        long entryNumber = 1;
        for (ProductSkuDTO productSkuDTO : productSkuDtoList) {
            OrderEntry orderEntry = new OrderEntry();
            orderEntry.setOrderId(order.getOrderId());
            orderEntry.setEntryNumber(entryNumber++);
            orderEntry.setProductSkuId(productSkuDTO.getProductSkuId());
            orderEntry.setStatusCode(StringConstant.Order.EntryStatus.PAID);

            @NotNull BigDecimal price = productSkuDTO.getPrice();
            orderEntry.setUnitPrice(price);

            Long count = productSkuDTO.getCount();
            orderEntry.setQuantity(count);

            orderEntry.setActualPaidAmount(price.multiply(new BigDecimal(count)));

            orderEntryList.add(orderEntry);
        }
        orderEntryRepository.batchInsertSelective(orderEntryList);

        return Results.success(orderCode);
    }

    @Override
    public List<Order> queryOrderList(Long customerId) {
        Order orderSelector = new Order();
        orderSelector.setCustomerId(customerId);
        return orderRepository.list(orderSelector);
    }

    @Override
    public ResponseEntity<?> commentOrder(Order order1, BigDecimal grade) {
        if (BigDecimal.ZERO.compareTo(grade) > 0 || new BigDecimal(ProductSpu.FIELD_CUSTOMER_GRADE_MAX).compareTo(grade) < 0) {
            return Results.invalid("分数必须在0~5之间");
        }
        Order order = orderRepository.selectByPrimaryKey(order1);
        Assert.isTrue(null != order, "不存在该订单：" + JSON.toJSONString(order1));
        // 计算spu分数
        List<ProductSpu> productSpuList = productSpuRepository.queryByOrderId(order.getOrderId());
        Assert.isTrue(CollectionUtils.isNotEmpty(productSpuList), "数据错误");
        for (ProductSpu spu : productSpuList) {
            BigDecimal customerGrade = spu.getCustomerGrade();
            BigDecimal subtract = grade.subtract(customerGrade);
            BigDecimal multiply = subtract.multiply(new BigDecimal("0.01"));
            BigDecimal result = customerGrade.add(multiply);
            spu.setCustomerGrade(result);
        }
        productSpuRepository.batchUpdateOptional(productSpuList, ProductSpu.FIELD_CUSTOMER_GRADE);

        // 更新订单状态
        order.setOrderStatusCode(StringConstant.Order.OrderStatus.COMPLETE);
        order.setIsCommented(BaseConstants.Digital.ONE);
        orderRepository.updateOptional(order, Order.FIELD_ORDER_STATUS_CODE, Order.FIELD_IS_COMMENTED);

        return Results.success();
    }

    @Override
    public ResponseEntity<?> receive(Order order1) {
        Order order = orderRepository.selectByPrimaryKey(order1);
        Assert.isTrue(null != order, "不存在该订单：" + JSON.toJSONString(order1));
        if (StringConstant.Order.OrderStatus.DELIVERING.equals(order.getOrderStatusCode())) {
            order.setOrderStatusCode(StringConstant.Order.OrderStatus.WAITING_COMMENT);
            orderRepository.updateOptional(order, Order.FIELD_ORDER_STATUS_CODE);
            return Results.success();
        } else {
            return Results.invalid("订单状态不是运送中，无法接收");
        }
    }

    private BigDecimal calculateTotalAmount(List<ProductSkuDTO> productSkuDtoList) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (ProductSkuDTO product : productSkuDtoList) {
            totalAmount = totalAmount.add(product.getPrice().multiply(new BigDecimal(product.getCount())));
        }
        return totalAmount;
    }

    /**
     * 校验库存
     *
     * @param productSkuDtoList 请求参数
     * @return 空串则为校验通过
     */
    private String validateStock(List<ProductSkuDTO> productSkuDtoList) {
        for (ProductSkuDTO product : productSkuDtoList) {
            ProductSku productSkuValidator = productSkuRepository.selectByPrimaryKey(product.getProductSkuId());
            Assert.isTrue(null != productSkuValidator, "商品ID：" + product.getProductSkuId() + "不存在");
            final long existStockLevel = productSkuValidator.getStockLevel();
            Long count = product.getCount();
            if (existStockLevel < count) {
                return "商品[" + product.getTitle() + "]库存不足";
            }
            product.setStockLevel(existStockLevel - count);
            product.setObjectVersionNumber(productSkuValidator.getObjectVersionNumber());
        }
        return null;
    }


}
