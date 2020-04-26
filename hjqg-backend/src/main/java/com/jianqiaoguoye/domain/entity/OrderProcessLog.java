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
 * 订单处理日志
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@ApiModel("订单处理日志")
@VersionAudit
@ModifyAudit
@Table(name = "order_process_log")
public class OrderProcessLog extends AuditDomain {

    public static final String FIELD_ORDER_PROCESS_LOG_ID = "orderProcessLogId";
    public static final String FIELD_ORDER_ID = "orderId";
    public static final String FIELD_CONSIGNMENT_ID = "consignmentId";
    public static final String FIELD_PROCESS_MESSAGE = "processMessage";
    public static final String FIELD_PREVIOUS_STATUS = "previousStatus";
    public static final String FIELD_CURRENT_STATUS = "currentStatus";
    public static final String FIELD_REMARK = "remark";
    public static final String FIELD_HANDLER_ID = "handlerId";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long orderProcessLogId;
    @ApiModelProperty(value = "关联order")
    @NotNull
    private Long orderId;
    @ApiModelProperty(value = "关联consignment")
    private Long consignmentId;
    @ApiModelProperty(value = "处理结果")
    @NotBlank
    private String processMessage;
    @ApiModelProperty(value = "前一个订单状态")
    private String previousStatus;
    @ApiModelProperty(value = "当前订单状态")
    private String currentStatus;
    @ApiModelProperty(value = "备注说明")
    private String remark;
    @ApiModelProperty(value = "处理人ID，hzero的用户ID(iam_user.user_id)")
    @NotNull
    private Long handlerId;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getOrderProcessLogId() {
        return orderProcessLogId;
    }

    public void setOrderProcessLogId(final Long orderProcessLogId) {
        this.orderProcessLogId = orderProcessLogId;
    }

    /**
     * @return 关联order
     */
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 关联consignment
     */
    public Long getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(final Long consignmentId) {
        this.consignmentId = consignmentId;
    }

    /**
     * @return 处理结果
     */
    public String getProcessMessage() {
        return processMessage;
    }

    public void setProcessMessage(final String processMessage) {
        this.processMessage = processMessage;
    }

    /**
     * @return 前一个订单状态
     */
    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(final String previousStatus) {
        this.previousStatus = previousStatus;
    }

    /**
     * @return 当前订单状态
     */
    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(final String currentStatus) {
        this.currentStatus = currentStatus;
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

    /**
     * @return 处理人ID，hzero的用户ID(iam_user.user_id)
     */
    public Long getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(final Long handlerId) {
        this.handlerId = handlerId;
    }

}
