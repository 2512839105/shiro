package com.sdzy.mall.base.model;

import java.util.Date;

public class BaseAutoIncrement {
    private String guid;

    private String storeId;

    private String prefix;

    private Integer value;

    private Date updateTime;
    /**修改时间*/
    private Date modifyDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseAutoIncrement.guid
     *
     * @return the value of baseAutoIncrement.guid
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public String getGuid() {
        return guid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseAutoIncrement.guid
     *
     * @param guid the value for baseAutoIncrement.guid
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseAutoIncrement.storeId
     *
     * @return the value of baseAutoIncrement.storeId
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseAutoIncrement.storeId
     *
     * @param storeId the value for baseAutoIncrement.storeId
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseAutoIncrement.prefix
     *
     * @return the value of baseAutoIncrement.prefix
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseAutoIncrement.prefix
     *
     * @param prefix the value for baseAutoIncrement.prefix
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseAutoIncrement.value
     *
     * @return the value of baseAutoIncrement.value
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public Integer getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseAutoIncrement.value
     *
     * @param value the value for baseAutoIncrement.value
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseAutoIncrement.updateTime
     *
     * @return the value of baseAutoIncrement.updateTime
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseAutoIncrement.updateTime
     *
     * @param updateTime the value for baseAutoIncrement.updateTime
     *
     * @mbg.generated Fri Jul 14 08:47:24 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}