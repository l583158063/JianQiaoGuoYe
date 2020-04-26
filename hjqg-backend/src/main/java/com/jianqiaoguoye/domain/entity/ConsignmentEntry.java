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

/**
 * 配货单行
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@ApiModel("配货单行")
@VersionAudit
@ModifyAudit
@Table(name = "consignment_entry")
public class ConsignmentEntry extends AuditDomain {

    public static final String FIELD_CONSIGNMENT_ENTRY_ID = "consignmentEntryId";
    public static final String FIELD_ENTRY_NUMBER = "entryNumber";
    public static final String FIELD_CONSIGNMENT_ID = "consignmentId";
    public static final String FIELD_ORDER_ENTRY_ID = "orderEntryId";
    public static final String FIELD_REMARKS = "remarks";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long consignmentEntryId;
    @ApiModelProperty(value = "行号")
    @NotNull
    private Long entryNumber;
    @ApiModelProperty(value = "配货单,关联consignment.consignment_id")
    @NotNull
    private Long consignmentId;
    @ApiModelProperty(value = "订单行,关联order_entry.order_entry_id")
    @NotNull
    private Long orderEntryId;
    @ApiModelProperty(value = "备注")
    private String remarks;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getConsignmentEntryId() {
        return consignmentEntryId;
    }

    public void setConsignmentEntryId(final Long consignmentEntryId) {
        this.consignmentEntryId = consignmentEntryId;
    }

    /**
     * @return 行号
     */
    public Long getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(final Long entryNumber) {
        this.entryNumber = entryNumber;
    }

    /**
     * @return 配货单, 关联consignment.consignment_id
     */
    public Long getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(final Long consignmentId) {
        this.consignmentId = consignmentId;
    }

    /**
     * @return 订单行, 关联order_entry.order_entry_id
     */
    public Long getOrderEntryId() {
        return orderEntryId;
    }

    public void setOrderEntryId(final Long orderEntryId) {
        this.orderEntryId = orderEntryId;
    }

    /**
     * @return 备注
     */
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(final String remarks) {
        this.remarks = remarks;
    }

}
