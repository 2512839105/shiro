package com.sdzy.xiaomi.user.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author charlin
 * @since 2018-07-03
 */
@TableName("baseMember")
public class BaseMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("memberId")
    private String memberId;
    @TableField("companyId")
    private String companyId;
    /**
     * 公司名称
     */
    @TableField("companyName")
    private String companyName;
    @TableField("storeId")
    private String storeId;
    /**
     * 门店名称
     */
    @TableField("storeName")
    private String storeName;
    @TableField("memberNo")
    private String memberNo;
    @TableField("memberName")
    private String memberName;
    @TableField("memberTypeName")
    private String memberTypeName;
    @TableField("memberType")
    private Integer memberType;
    private Integer sex;
    private Integer age;
    private String birthday;
    private String mobile;
    private String webchart;
    @TableField("idCard")
    private String idCard;
    private Integer deleteFlag;
    public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	private String address;
    /**
     * 会员积分
     */
    @TableField("totalScore")
    private Integer totalScore;
    @TableField("remainScore")
    private Integer remainScore;
    @TableField("storedMoney")
    private BigDecimal storedMoney;
    @TableField("medicalHistory")
    private String medicalHistory;
    @TableField("lastExpenseDate1")
    private Date lastExpenseDate1;
    @TableField("lastExpenseDate2")
    private Date lastExpenseDate2;
    @TableField("auditState")
    private Integer auditState;
    @TableField("createUserId")
    private String createUserId;
    @TableField("createUserName")
    private String createUserName;
    @TableField(value = "createDate", fill = FieldFill.INSERT_UPDATE)
    private Date createDate;
    @TableField("modifyUserId")
    private String modifyUserId;
    @TableField("modifyUserName")
    private String modifyUserName;
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;
    private String remark;
    /**
     * 0禁用 1启用
     */
    private Integer status;
    @TableField("memberCardNo")
    private String memberCardNo;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberTypeName() {
        return memberTypeName;
    }

    public void setMemberTypeName(String memberTypeName) {
        this.memberTypeName = memberTypeName;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWebchart() {
        return webchart;
    }

    public void setWebchart(String webchart) {
        this.webchart = webchart;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getRemainScore() {
        return remainScore;
    }

    public void setRemainScore(Integer remainScore) {
        this.remainScore = remainScore;
    }

    public BigDecimal getStoredMoney() {
        return storedMoney;
    }

    public void setStoredMoney(BigDecimal storedMoney) {
        this.storedMoney = storedMoney;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Date getLastExpenseDate1() {
        return lastExpenseDate1;
    }

    public void setLastExpenseDate1(Date lastExpenseDate1) {
        this.lastExpenseDate1 = lastExpenseDate1;
    }

    public Date getLastExpenseDate2() {
        return lastExpenseDate2;
    }

    public void setLastExpenseDate2(Date lastExpenseDate2) {
        this.lastExpenseDate2 = lastExpenseDate2;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemberCardNo() {
        return memberCardNo;
    }

    public void setMemberCardNo(String memberCardNo) {
        this.memberCardNo = memberCardNo;
    }

    @Override
    public String toString() {
        return "BaseMember{" +
        ", memberId=" + memberId +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", storeId=" + storeId +
        ", storeName=" + storeName +
        ", memberNo=" + memberNo +
        ", memberName=" + memberName +
        ", memberTypeName=" + memberTypeName +
        ", memberType=" + memberType +
        ", sex=" + sex +
        ", age=" + age +
        ", birthday=" + birthday +
        ", mobile=" + mobile +
        ", webchart=" + webchart +
        ", idCard=" + idCard +
        ", address=" + address +
        ", totalScore=" + totalScore +
        ", remainScore=" + remainScore +
        ", storedMoney=" + storedMoney +
        ", medicalHistory=" + medicalHistory +
        ", lastExpenseDate1=" + lastExpenseDate1 +
        ", lastExpenseDate2=" + lastExpenseDate2 +
        ", auditState=" + auditState +
        ", createUserId=" + createUserId +
        ", createUserName=" + createUserName +
        ", createDate=" + createDate +
        ", modifyUserId=" + modifyUserId +
        ", modifyUserName=" + modifyUserName +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", status=" + status +
        ", memberCardNo=" + memberCardNo +
        "}";
    }
}
