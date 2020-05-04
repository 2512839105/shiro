package com.sdzy.xiaomi.user.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 短信模板
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
@TableName("msgTemplate")
public class MsgTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模板ID
     */
    @TableId("templateId")
    private String templateId;
    /**
     * 用户类别：1企业，2门店，3会员
     */
    @TableField("memberType")
    private Integer memberType;
    /**
     * 用户ID
     */
    @TableField("memberId")
    private String memberId;
    /**
     * 模板主题
     */
    @TableField("templateTitle")
    private String templateTitle;
    /**
     * 模板内容
     */
    @TableField("templateContent")
    private String templateContent;
    /**
     * 状态：-1删除，0停用，1启用
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
     * 备注
     */
    private String remark;


    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MsgTemplate{" +
        ", templateId=" + templateId +
        ", memberType=" + memberType +
        ", memberId=" + memberId +
        ", templateTitle=" + templateTitle +
        ", templateContent=" + templateContent +
        ", state=" + state +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", remark=" + remark +
        "}";
    }
}
