package com.sdzy.xiaomi.base.entity;

import com.asdzy.common.session.LocalUser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 * @author
 */
public class SysUser implements LocalUser, Serializable {

	 private String userId;
	    /**帐户*/
	    private String userAccount;
	    /**用户代码*/
	    private String userCode;
	    /**用户名称*/
	    private String userName;
	    /**所在组织id*/
	    private String userGroupId;
	    /**企业id*/
	    private String companyId;

	    private String storeId;
	    /**门店名称*/
	    private String storeName;

	    private String password;
	    /**密码状态0:没有修改密码，1表示修改了密码*/
	    private Integer pwdStatus;

	    private String email;

	    private String mobile;

	    private Integer sex;

	    private String exitDate;

	    private String entryDate;

	    private String degree;

	    private String birthday;
	    /**身份证号*/
	    private String cardNo;

	    private String fileNumber;

	    private String postName;

	    private String deptName;

	    private String jobTitle;

	    private String education;

	    private Integer status;

	    private String createUserId;

	    private Date createDate;

	    private Date modifyDate;

	    private String remark;

	    private Integer deleteFlag;

	    private String autoLoginKeys;
	    
	    //最后登录时间
	    private Date lastLoginTime;
	    
	    //最后登出时间
	    private Date lastLogoutTime;

	    //--未在数据库中字段---------------------------------------
	    private String storeCode;
	    /**门店帐号*/
	    private String storeAccount;

	    private String storeAddress;
	    /**企业名称*/
	    private String companyName;
	    /**用户角色名称*/
	    private List<String> roleNameList;

	    private List<String> roleIdList;

	    private List<SysRole> roleList;
	    
 
	    private static final long serialVersionUID = 1L;

	    public String getStoreAddress() {
	        return storeAddress;
	    }

	    public void setStoreAddress(String storeAddress) {
	        this.storeAddress = storeAddress;
	    }

	    public List<SysRole> getRoleList() {
	        return roleList;
	    }

	    public void setRoleList(List<SysRole> roleList) {
	        this.roleList = roleList;
	    }

	    @Override
	    public Integer getPwdStatus() {
	        return pwdStatus==null ? 0 : pwdStatus;
	    }

	    public void setPwdStatus(Integer pwdStatus) {
	        this.pwdStatus = pwdStatus;
	    }

	    @Override
	    public String getStoreAccount() {
	        return storeAccount;
	    }

	    public void setStoreAccount(String storeAccount) {
	        this.storeAccount = storeAccount;
	    }

	    @Override
	    public String getDBInfo() {
	        return null;
	    }

	    @Override
	    public List<String> getRoleIdList() {
	        return roleIdList;
	    }

	    public void setRoleIdList(List<String> roleIdList) {
	        this.roleIdList = roleIdList;
	    }

	    @Override
	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId == null ? null : userId.trim();
	    }

	    @Override
	    public String getUserAccount() {
	        return userAccount;
	    }

	    public void setUserAccount(String userAccount) {
	        this.userAccount = userAccount == null ? null : userAccount.trim();
	    }

	    @Override
	    public String getUserCode() {
	        return userCode;
	    }

	    public void setUserCode(String userCode) {
	        this.userCode = userCode == null ? null : userCode.trim();
	    }

	    @Override
	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName == null ? null : userName.trim();
	    }

	    @Override
	    public String getUserGroupId() {
	        return userGroupId;
	    }

	    public void setUserGroupId(String userGroupId) {
	        this.userGroupId = userGroupId == null ? null : userGroupId.trim();
	    }

	    public String getCompanyName() {
	        return companyName;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }

	    @Override
	    public String getCompanyId() {
	        return companyId;
	    }

	    public void setCompanyId(String companyId) {
	        this.companyId = companyId == null ? null : companyId.trim();
	    }

	    @Override
	    public String getStoreId() {
	        return storeId;
	    }

	    public void setStoreCode(String storeCode) {
	        this.storeCode = storeCode;
	    }

	    @Override
	    public String getStoreCode() {
	        return storeCode;
	    }

	    public void setStoreId(String storeId) {
	        this.storeId = storeId == null ? null : storeId.trim();
	    }

	    @Override
	    public String getStoreName() {
	        return storeName;
	    }

	    public void setStoreName(String storeName) {
	        this.storeName = storeName == null ? null : storeName.trim();
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password == null ? null : password.trim();
	    }

	    @Override
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email == null ? null : email.trim();
	    }

	    @Override
	    public String getMobile() {
	        return mobile;
	    }

	    public void setMobile(String mobile) {
	        this.mobile = mobile == null ? null : mobile.trim();
	    }

	    @Override
	    public Integer getSex() {
	        return sex;
	    }

	    public void setSex(Integer sex) {
	        this.sex = sex;
	    }

	    @Override
	    public String getExitDate() {
	        return exitDate;
	    }

	    public void setExitDate(String exitDate) {
	        this.exitDate = exitDate == null ? null : exitDate.trim();
	    }

	    @Override
	    public String getEntryDate() {
	        return entryDate;
	    }

	    public void setEntryDate(String entryDate) {
	        this.entryDate = entryDate == null ? null : entryDate.trim();
	    }

	    @Override
	    public String getDegree() {
	        return degree;
	    }

	    public void setDegree(String degree) {
	        this.degree = degree == null ? null : degree.trim();
	    }

	    @Override
	    public String getBirthday() {
	        return birthday;
	    }

	    public void setBirthday(String birthday) {
	        this.birthday = birthday == null ? null : birthday.trim();
	    }

	    @Override
	    public String getCardNo() {
	        return cardNo;
	    }

	    public void setCardNo(String cardNo) {
	        this.cardNo = cardNo == null ? null : cardNo.trim();
	    }

	    @Override
	    public String getFileNumber() {
	        return fileNumber;
	    }

	    public void setFileNumber(String fileNumber) {
	        this.fileNumber = fileNumber == null ? null : fileNumber.trim();
	    }

	    @Override
	    public String getPostName() {
	        return postName;
	    }

	    public void setPostName(String postName) {
	        this.postName = postName == null ? null : postName.trim();
	    }

	    @Override
	    public String getDeptName() {
	        return deptName;
	    }

	    public void setDeptName(String deptName) {
	        this.deptName = deptName == null ? null : deptName.trim();
	    }

	    @Override
	    public String getJobTitle() {
	        return jobTitle;
	    }

	    public void setJobTitle(String jobTitle) {
	        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
	    }

	    @Override
	    public String getEducation() {
	        return education;
	    }

	    public void setEducation(String education) {
	        this.education = education == null ? null : education.trim();
	    }

	    @Override
	    public Integer getStatus() {
	        return status;
	    }

	    public void setStatus(Integer status) {
	        this.status = status;
	    }

	    @Override
	    public String getCreateUserId() {
	        return createUserId;
	    }

	    public void setCreateUserId(String createUserId) {
	        this.createUserId = createUserId == null ? null : createUserId.trim();
	    }

	    @Override
	    public Date getCreateDate() {
	        return createDate;
	    }

	    public void setCreateDate(Date createDate) {
	        this.createDate = createDate;
	    }

	    @Override
	    public Date getModifyDate() {
	        return modifyDate;
	    }

	    public void setModifyDate(Date modifyDate) {
	        this.modifyDate = modifyDate;
	    }

	    @Override
	    public String getRemark() {
	        return remark;
	    }

	    public void setRemark(String remark) {
	        this.remark = remark == null ? null : remark.trim();
	    }

	    @Override
	    public Integer getDeleteFlag() {
	        return deleteFlag;
	    }

	    public void setDeleteFlag(Integer deleteFlag) {
	        this.deleteFlag = deleteFlag;
	    }

	    @Override
	    public String getAutoLoginKeys() {
	        return autoLoginKeys;
	    }

	    public void setAutoLoginKeys(String autoLoginKeys) {
	        this.autoLoginKeys = autoLoginKeys == null ? null : autoLoginKeys.trim();
	    }

 

	    public List<String> getRoleNameList() {
	        return roleNameList;
	    }

	    public void setRoleNameList(List<String> roleNameList) {
	        this.roleNameList = roleNameList;
	    }

	    public Date getLastLoginTime() {
			return lastLoginTime;
		}

		public void setLastLoginTime(Date lastLoginTime) {
			this.lastLoginTime = lastLoginTime;
		}

		public Date getLastLogoutTime() {
			return lastLogoutTime;
		}

		public void setLastLogoutTime(Date lastLogoutTime) {
			this.lastLogoutTime = lastLogoutTime;
		}

		@Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append(getClass().getSimpleName());
	        sb.append(" [");
	        sb.append("Hash = ").append(hashCode());
	        sb.append(", userId=").append(userId);
	        sb.append(", userAccount=").append(userAccount);
	        sb.append(", userCode=").append(userCode);
	        sb.append(", userName=").append(userName);
	        sb.append(", userGroupId=").append(userGroupId);
	        sb.append(", companyId=").append(companyId);
	        sb.append(", storeId=").append(storeId);
	        sb.append(", storeName=").append(storeName);
	        sb.append(", password=").append(password);
	        sb.append(", email=").append(email);
	        sb.append(", mobile=").append(mobile);
	        sb.append(", sex=").append(sex);
	        sb.append(", exitDate=").append(exitDate);
	        sb.append(", entryDate=").append(entryDate);
	        sb.append(", degree=").append(degree);
	        sb.append(", birthday=").append(birthday);
	        sb.append(", cardNo=").append(cardNo);
	        sb.append(", fileNumber=").append(fileNumber);
	        sb.append(", postName=").append(postName);
	        sb.append(", deptName=").append(deptName);
	        sb.append(", jobTitle=").append(jobTitle);
	        sb.append(", education=").append(education);
	        sb.append(", status=").append(status);
	        sb.append(", createUserId=").append(createUserId);
	        sb.append(", createDate=").append(createDate);
	        sb.append(", modifyDate=").append(modifyDate);
	        sb.append(", remark=").append(remark);
	        sb.append(", deleteFlag=").append(deleteFlag);
	        sb.append(", autoLoginKeys=").append(autoLoginKeys);
	        sb.append("]");
	        return sb.toString();
	    }

		@Override
		public Integer getDeleteStatus() {
			// TODO 未实现
			return null;
		}
	}