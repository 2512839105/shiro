package com.sdzy.xiaomi.user.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 短信发送记录
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
@TableName("msgSendRecord")
public class MsgSendRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     */
    @TableId("recordId")
    private String recordId;
    /**
     * 发送人类别：1企业，2门店，3会员
     */
    @TableField("sendUserType")
    private Integer sendUserType;
    /**
     * 发送人ID
     */
    @TableField("sendUserId")
    private String sendUserId;
    /**
     * 模板ID
     */
    @TableField("templateId")
    private String templateId;
    /**
     * 发送主题
     */
    @TableField("sendTitle")
    private String sendTitle;
    /**
     * 发送内容
     */
    @TableField("sendContent")
    private String sendContent;
    /**
     * 设定发送日期
     */
    @TableField("sendDate")
    private String sendDate;
    /**
     * 接收人
     */
    @TableField("receiveUsers")
    private String receiveUsers;
    /**
     * 发送数量
     */
    @TableField("sendCount")
    private Integer sendCount;
    /**
     * 状态：-1删除，0暂存，1发送成功，2发送失败
     */
    private Integer state;
    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("modifyTime")
    private Date modifyTime;
    /**
     * 发送时间
     */
    @TableField("sendTime")
    private Date sendTime;
    /**
     * 备注
     */
    private String remark;


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Integer getSendUserType() {
        return sendUserType;
    }

    public void setSendUserType(Integer sendUserType) {
        this.sendUserType = sendUserType;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getSendTitle() {
        return sendTitle;
    }

    public void setSendTitle(String sendTitle) {
        this.sendTitle = sendTitle;
    }

    public String getSendContent() {
        return sendContent;
    }

    public void setSendContent(String sendContent) {
        this.sendContent = sendContent;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getReceiveUsers() {
        return receiveUsers;
    }

    public void setReceiveUsers(String receiveUsers) {
        this.receiveUsers = receiveUsers;
    }

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MsgSendRecord{" +
        ", recordId=" + recordId +
        ", sendUserType=" + sendUserType +
        ", sendUserId=" + sendUserId +
        ", templateId=" + templateId +
        ", sendTitle=" + sendTitle +
        ", sendContent=" + sendContent +
        ", sendDate=" + sendDate +
        ", receiveUsers=" + receiveUsers +
        ", sendCount=" + sendCount +
        ", state=" + state +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", sendTime=" + sendTime +
        ", remark=" + remark +
        "}";
    }
}
