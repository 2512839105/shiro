package com.sdzy.mall.system.model;

import java.io.Serializable;
import java.util.Date;

public class SysConfig implements Serializable {
    private Integer configId;

    private String storeId;

    private String storeCode;

    private String storeLicense;

    private Integer storeAuthStatus;

    private String storeSa;

    private String storeIP;

    private String storeMAC;

    private String storeHost;

    private String socialPort;

    private String socialComm;

    private String storeAppkey;

    private String storeApisecret;

    private String storeApiId;

    private Date modifyDate;

    private Integer clickRunProductDownload;

    private Integer clickRunPurchaseDownload;

    private Integer migrateMemberStatus;

    private Integer migrateStockStatus;

    private Integer migratePurchaseStatus;

    private Integer migrateSaleStatus;

    private Integer migratePriceStatus;

    private static final long serialVersionUID = 1L;

    public Integer getMigrateMemberStatus() {
        return migrateMemberStatus;
    }

    public void setMigrateMemberStatus(Integer migrateMemberStatus) {
        this.migrateMemberStatus = migrateMemberStatus;
    }

    public Integer getMigrateStockStatus() {
        return migrateStockStatus;
    }

    public void setMigrateStockStatus(Integer migrateStockStatus) {
        this.migrateStockStatus = migrateStockStatus;
    }

    public Integer getMigratePurchaseStatus() {
        return migratePurchaseStatus;
    }

    public void setMigratePurchaseStatus(Integer migratePurchaseStatus) {
        this.migratePurchaseStatus = migratePurchaseStatus;
    }

    public Integer getMigrateSaleStatus() {
        return migrateSaleStatus;
    }

    public void setMigrateSaleStatus(Integer migrateSaleStatus) {
        this.migrateSaleStatus = migrateSaleStatus;
    }

    public Integer getMigratePriceStatus() {
        return migratePriceStatus;
    }

    public void setMigratePriceStatus(Integer migratePriceStatus) {
        this.migratePriceStatus = migratePriceStatus;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreLicense() {
        return storeLicense;
    }

    public void setStoreLicense(String storeLicense) {
        this.storeLicense = storeLicense;
    }

    public Integer getStoreAuthStatus() {
        return storeAuthStatus;
    }

    public void setStoreAuthStatus(Integer storeAuthStatus) {
        this.storeAuthStatus = storeAuthStatus;
    }

    public String getStoreSa() {
        return storeSa;
    }

    public void setStoreSa(String storeSa) {
        this.storeSa = storeSa;
    }

    public String getStoreIP() {
        return storeIP;
    }

    public void setStoreIP(String storeIP) {
        this.storeIP = storeIP;
    }

    public String getStoreMAC() {
        return storeMAC;
    }

    public void setStoreMAC(String storeMAC) {
        this.storeMAC = storeMAC;
    }

    public String getStoreHost() {
        return storeHost;
    }

    public void setStoreHost(String storeHost) {
        this.storeHost = storeHost;
    }

    public String getSocialPort() {
        return socialPort;
    }

    public void setSocialPort(String socialPort) {
        this.socialPort = socialPort;
    }

    public String getSocialComm() {
        return socialComm;
    }

    public void setSocialComm(String socialComm) {
        this.socialComm = socialComm;
    }

    public String getStoreAppkey() {
        return storeAppkey;
    }

    public void setStoreAppkey(String storeAppkey) {
        this.storeAppkey = storeAppkey;
    }

    public String getStoreApisecret() {
        return storeApisecret;
    }

    public void setStoreApisecret(String storeApisecret) {
        this.storeApisecret = storeApisecret;
    }

    public String getStoreApiId() {
        return storeApiId;
    }

    public void setStoreApiId(String storeApiId) {
        this.storeApiId = storeApiId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getClickRunProductDownload() {
        return clickRunProductDownload;
    }

    public void setClickRunProductDownload(Integer clickRunProductDownload) {
        this.clickRunProductDownload = clickRunProductDownload;
    }

    public Integer getClickRunPurchaseDownload() {
        return clickRunPurchaseDownload;
    }

    public void setClickRunPurchaseDownload(Integer clickRunPurchaseDownload) {
        this.clickRunPurchaseDownload = clickRunPurchaseDownload;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configId=").append(configId);
        sb.append(", storeId=").append(storeId);
        sb.append(", storeCode=").append(storeCode);
        sb.append(", storeLicense=").append(storeLicense);
        sb.append(", storeAuthStatus=").append(storeAuthStatus);
        sb.append(", storeSa=").append(storeSa);
        sb.append(", storeIP=").append(storeIP);
        sb.append(", storeMAC=").append(storeMAC);
        sb.append(", storeHost=").append(storeHost);
        sb.append(", socialPort=").append(socialPort);
        sb.append(", socialComm=").append(socialComm);
        sb.append(", storeAppkey=").append(storeAppkey);
        sb.append(", storeApisecret=").append(storeApisecret);
        sb.append(", storeApiId=").append(storeApiId);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", clickRunProductDownload=").append(clickRunProductDownload);
        sb.append(", clickRunPurchaseDownload=").append(clickRunPurchaseDownload);
        sb.append("]");
        return sb.toString();
    }
}