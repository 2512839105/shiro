package com.sdzy.mall.base.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author charlin
 * @since 2018-07-11
 */
@TableName("baseStoreInfo")
public class MallBaseStoreInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 门店ID
     */
    @TableId("storeId")
    private String storeId;
    /**
     * 机构编码
     */
    @TableField("storeAccount")
    private String storeAccount;
    /**
     * 门店编码
     */
    @TableField("storeCode")
    private String storeCode;
    /**
     * 机构编码(社保上传用)
     */
    @TableField("uploadCode")
    private String uploadCode;
    /**
     * 企业Id
     */
    @TableField("companyId")
    private String companyId;
    @TableField("companyNo")
    private String companyNo;
    @TableField("companyFullName")
    private String companyFullName;
    @TableField("dataUploadAccount")
    private String dataUploadAccount;
    @TableField("dataUploadPassword")
    private String dataUploadPassword;
    /**
     * 门店类别 0:单体，1:连锁
     */
    @TableField("storeType")
    private Integer storeType;
    /**
     * 门店名称
     */
    @TableField("storeName")
    private String storeName;
    /**
     * 门店全称
     */
    @TableField("storeFullName")
    private String storeFullName;
    /**
     * 联系人
     */
    private String contactor;
    /**
     * 电话/(客服电话)
     */
    private String tel;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 省代码
     */
    @TableField("proviceCode")
    private String proviceCode;
    /**
     * 省名称
     */
    @TableField("proviceName")
    private String proviceName;
    /**
     * 市代码
     */
    @TableField("cityCode")
    private String cityCode;
    /**
     * 市名称
     */
    @TableField("cityName")
    private String cityName;
    /**
     * 区代码
     */
    @TableField("zoneCode")
    private String zoneCode;
    /**
     * 区名称
     */
    @TableField("zoneName")
    private String zoneName;
    /**
     * 营业地址
     */
    @TableField("storeAddress")
    private String storeAddress;
    /**
     * 价格方案
     */
    @TableField("priceScheme")
    private String priceScheme;
    /**
     * 状态-1删除0停用1正常
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField(value = "createDate", fill = FieldFill.INSERT_UPDATE)
    private Date createDate;
    /**
     * 修改时间
     */
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;
    /**
     * 备注
     */
    private String remark;
    /**
     * -1表示删除,0或null表示正常
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;
    /**
     * 门店图片
     */
    @TableField("storePic")
    private String storePic;
    /**
     * 门店视频
     */
    @TableField("storeVideo")
    private String storeVideo;
    /**
     * 营业时间
     */
    @TableField("shopTime")
    private String shopTime;
    /**
     * 证件号码
     */
    @TableField("idNumber")
    private String idNumber;
    /**
     * 证件图片
     */
    @TableField("idPic")
    private String idPic;
    /**
     * 门店描述
     */
    @TableField("storeDescription")
    private String storeDescription;
    /**
     * 支付宝账号
     */
    @TableField("alipayAppId")
    private String alipayAppId;
    /**
     * 微信账号
     */
    @TableField("wxAppId")
    private String wxAppId;
    @TableField("wxMachId")
    private String wxMachId;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 0:线下支付， 1：线上支付
     */
    @TableField("payMethod")
    private Integer payMethod;
    
    private String storeLogo;
    
    
    private BigDecimal totalCount;
    
    
    
    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getUploadCode() {
        return uploadCode;
    }

    public void setUploadCode(String uploadCode) {
        this.uploadCode = uploadCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public String getDataUploadAccount() {
        return dataUploadAccount;
    }

    public void setDataUploadAccount(String dataUploadAccount) {
        this.dataUploadAccount = dataUploadAccount;
    }

    public String getDataUploadPassword() {
        return dataUploadPassword;
    }

    public void setDataUploadPassword(String dataUploadPassword) {
        this.dataUploadPassword = dataUploadPassword;
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreFullName() {
        return storeFullName;
    }

    public void setStoreFullName(String storeFullName) {
        this.storeFullName = storeFullName;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProviceCode() {
        return proviceCode;
    }

    public void setProviceCode(String proviceCode) {
        this.proviceCode = proviceCode;
    }

    public String getProviceName() {
        return proviceName;
    }

    public void setProviceName(String proviceName) {
        this.proviceName = proviceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getPriceScheme() {
        return priceScheme;
    }

    public void setPriceScheme(String priceScheme) {
        this.priceScheme = priceScheme;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getStorePic() {
        return storePic;
    }

    public void setStorePic(String storePic) {
        this.storePic = storePic;
    }

    public String getStoreVideo() {
        return storeVideo;
    }

    public void setStoreVideo(String storeVideo) {
        this.storeVideo = storeVideo;
    }

    public String getShopTime() {
        return shopTime;
    }

    public void setShopTime(String shopTime) {
        this.shopTime = shopTime;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdPic() {
        return idPic;
    }

    public void setIdPic(String idPic) {
        this.idPic = idPic;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public String getAlipayAppId() {
        return alipayAppId;
    }

    public void setAlipayAppId(String alipayAppId) {
        this.alipayAppId = alipayAppId;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxMachId() {
        return wxMachId;
    }

    public void setWxMachId(String wxMachId) {
        this.wxMachId = wxMachId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "BaseStoreInfo{" +
        ", storeId=" + storeId +
        ", storeAccount=" + storeAccount +
        ", storeCode=" + storeCode +
        ", uploadCode=" + uploadCode +
        ", companyId=" + companyId +
        ", companyNo=" + companyNo +
        ", companyFullName=" + companyFullName +
        ", dataUploadAccount=" + dataUploadAccount +
        ", dataUploadPassword=" + dataUploadPassword +
        ", storeType=" + storeType +
        ", storeName=" + storeName +
        ", storeFullName=" + storeFullName +
        ", contactor=" + contactor +
        ", tel=" + tel +
        ", mobile=" + mobile +
        ", proviceCode=" + proviceCode +
        ", proviceName=" + proviceName +
        ", cityCode=" + cityCode +
        ", cityName=" + cityName +
        ", zoneCode=" + zoneCode +
        ", zoneName=" + zoneName +
        ", storeAddress=" + storeAddress +
        ", priceScheme=" + priceScheme +
        ", status=" + status +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        ", storePic=" + storePic +
        ", storeVideo=" + storeVideo +
        ", shopTime=" + shopTime +
        ", idNumber=" + idNumber +
        ", idPic=" + idPic +
        ", storeDescription=" + storeDescription +
        ", alipayAppId=" + alipayAppId +
        ", wxAppId=" + wxAppId +
        ", wxMachId=" + wxMachId +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", payMethod=" + payMethod +
        "}";
    }
}
