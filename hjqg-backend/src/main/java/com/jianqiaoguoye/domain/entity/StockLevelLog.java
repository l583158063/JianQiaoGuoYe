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

/**
 * 库存变动日志
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@ApiModel("库存变动日志")
@VersionAudit
@ModifyAudit
@Table(name = "stock_level_log")
public class StockLevelLog extends AuditDomain {

    public static final String FIELD_STOCK_LEVEL_LOG_ID = "stockLevelLogId";
    public static final String FIELD_STOCK_LEVEL_ID = "stockLevelId";
    public static final String FIELD_IN_STOCK_CHANGE = "inStockChange";
    public static final String FIELD_RESERVED_QUANTITY_CHANGE = "reservedQuantityChange";
    public static final String FIELD_HANDLER_ID = "handlerId";
    public static final String FIELD_STATUS_CODE = "statusCode";
    public static final String FIELD_REMARK = "remark";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long stockLevelLogId;
    @ApiModelProperty(value = "关联库存", required = true)
    @NotNull
    private Long stockLevelId;
    @ApiModelProperty(value = "库存现有量变动", required = true)
    @NotNull
    private Long inStockChange;
    @ApiModelProperty(value = "库存保留量变动", required = true)
    @NotNull
    private Long reservedQuantityChange;
    @ApiModelProperty(value = "负责人，hzero的用户ID(iam_user.user_id)")
    private Long handlerId;
    @ApiModelProperty(value = "库存变动状态编码", required = true)
    @NotBlank
    private String statusCode;
    @ApiModelProperty(value = "备注说明")
    private String remark;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getStockLevelLogId() {
        return stockLevelLogId;
    }

    public void setStockLevelLogId(final Long stockLevelLogId) {
        this.stockLevelLogId = stockLevelLogId;
    }

    /**
     * @return 关联库存
     */
    public Long getStockLevelId() {
        return stockLevelId;
    }

    public void setStockLevelId(final Long stockLevelId) {
        this.stockLevelId = stockLevelId;
    }

    /**
     * @return 库存现有量变动
     */
    public Long getInStockChange() {
        return inStockChange;
    }

    public void setInStockChange(final Long inStockChange) {
        this.inStockChange = inStockChange;
    }

    /**
     * @return 库存保留量变动
     */
    public Long getReservedQuantityChange() {
        return reservedQuantityChange;
    }

    public void setReservedQuantityChange(final Long reservedQuantityChange) {
        this.reservedQuantityChange = reservedQuantityChange;
    }

    /**
     * @return 负责人，hzero的用户ID(iam_user.user_id)
     */
    public Long getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(final Long handlerId) {
        this.handlerId = handlerId;
    }

    /**
     * @return 库存变动状态编码
     */
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return 备注说明
     */
    public String getRemark() {
        return remark;
    }

    public void setRemark(final String remark) {
        this.remark = remark;
    }

}
