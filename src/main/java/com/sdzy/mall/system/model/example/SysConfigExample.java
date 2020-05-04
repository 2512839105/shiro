package com.sdzy.mall.system.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andConfigIdIsNull() {
            addCriterion("configId is null");
            return (Criteria) this;
        }

        public Criteria andConfigIdIsNotNull() {
            addCriterion("configId is not null");
            return (Criteria) this;
        }

        public Criteria andConfigIdEqualTo(Integer value) {
            addCriterion("configId =", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdNotEqualTo(Integer value) {
            addCriterion("configId <>", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdGreaterThan(Integer value) {
            addCriterion("configId >", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("configId >=", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdLessThan(Integer value) {
            addCriterion("configId <", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("configId <=", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdIn(List<Integer> values) {
            addCriterion("configId in", values, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdNotIn(List<Integer> values) {
            addCriterion("configId not in", values, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("configId between", value1, value2, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("configId not between", value1, value2, "configId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("storeId is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("storeId is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(String value) {
            addCriterion("storeId =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(String value) {
            addCriterion("storeId <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(String value) {
            addCriterion("storeId >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("storeId >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(String value) {
            addCriterion("storeId <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(String value) {
            addCriterion("storeId <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLike(String value) {
            addCriterion("storeId like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotLike(String value) {
            addCriterion("storeId not like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<String> values) {
            addCriterion("storeId in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<String> values) {
            addCriterion("storeId not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(String value1, String value2) {
            addCriterion("storeId between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(String value1, String value2) {
            addCriterion("storeId not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreCodeIsNull() {
            addCriterion("storeCode is null");
            return (Criteria) this;
        }

        public Criteria andStoreCodeIsNotNull() {
            addCriterion("storeCode is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCodeEqualTo(String value) {
            addCriterion("storeCode =", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeNotEqualTo(String value) {
            addCriterion("storeCode <>", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeGreaterThan(String value) {
            addCriterion("storeCode >", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeGreaterThanOrEqualTo(String value) {
            addCriterion("storeCode >=", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeLessThan(String value) {
            addCriterion("storeCode <", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeLessThanOrEqualTo(String value) {
            addCriterion("storeCode <=", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeLike(String value) {
            addCriterion("storeCode like", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeNotLike(String value) {
            addCriterion("storeCode not like", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeIn(List<String> values) {
            addCriterion("storeCode in", values, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeNotIn(List<String> values) {
            addCriterion("storeCode not in", values, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeBetween(String value1, String value2) {
            addCriterion("storeCode between", value1, value2, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeNotBetween(String value1, String value2) {
            addCriterion("storeCode not between", value1, value2, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIsNull() {
            addCriterion("storeLicense is null");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIsNotNull() {
            addCriterion("storeLicense is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseEqualTo(String value) {
            addCriterion("storeLicense =", value, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseNotEqualTo(String value) {
            addCriterion("storeLicense <>", value, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseGreaterThan(String value) {
            addCriterion("storeLicense >", value, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("storeLicense >=", value, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseLessThan(String value) {
            addCriterion("storeLicense <", value, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseLessThanOrEqualTo(String value) {
            addCriterion("storeLicense <=", value, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseLike(String value) {
            addCriterion("storeLicense like", value, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseNotLike(String value) {
            addCriterion("storeLicense not like", value, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIn(List<String> values) {
            addCriterion("storeLicense in", values, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseNotIn(List<String> values) {
            addCriterion("storeLicense not in", values, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseBetween(String value1, String value2) {
            addCriterion("storeLicense between", value1, value2, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseNotBetween(String value1, String value2) {
            addCriterion("storeLicense not between", value1, value2, "storeLicense");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusIsNull() {
            addCriterion("storeAuthStatus is null");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusIsNotNull() {
            addCriterion("storeAuthStatus is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusEqualTo(Integer value) {
            addCriterion("storeAuthStatus =", value, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusNotEqualTo(Integer value) {
            addCriterion("storeAuthStatus <>", value, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusGreaterThan(Integer value) {
            addCriterion("storeAuthStatus >", value, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("storeAuthStatus >=", value, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusLessThan(Integer value) {
            addCriterion("storeAuthStatus <", value, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusLessThanOrEqualTo(Integer value) {
            addCriterion("storeAuthStatus <=", value, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusIn(List<Integer> values) {
            addCriterion("storeAuthStatus in", values, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusNotIn(List<Integer> values) {
            addCriterion("storeAuthStatus not in", values, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusBetween(Integer value1, Integer value2) {
            addCriterion("storeAuthStatus between", value1, value2, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreAuthStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("storeAuthStatus not between", value1, value2, "storeAuthStatus");
            return (Criteria) this;
        }

        public Criteria andStoreSaIsNull() {
            addCriterion("storeSa is null");
            return (Criteria) this;
        }

        public Criteria andStoreSaIsNotNull() {
            addCriterion("storeSa is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSaEqualTo(String value) {
            addCriterion("storeSa =", value, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaNotEqualTo(String value) {
            addCriterion("storeSa <>", value, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaGreaterThan(String value) {
            addCriterion("storeSa >", value, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaGreaterThanOrEqualTo(String value) {
            addCriterion("storeSa >=", value, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaLessThan(String value) {
            addCriterion("storeSa <", value, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaLessThanOrEqualTo(String value) {
            addCriterion("storeSa <=", value, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaLike(String value) {
            addCriterion("storeSa like", value, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaNotLike(String value) {
            addCriterion("storeSa not like", value, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaIn(List<String> values) {
            addCriterion("storeSa in", values, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaNotIn(List<String> values) {
            addCriterion("storeSa not in", values, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaBetween(String value1, String value2) {
            addCriterion("storeSa between", value1, value2, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreSaNotBetween(String value1, String value2) {
            addCriterion("storeSa not between", value1, value2, "storeSa");
            return (Criteria) this;
        }

        public Criteria andStoreIPIsNull() {
            addCriterion("storeIP is null");
            return (Criteria) this;
        }

        public Criteria andStoreIPIsNotNull() {
            addCriterion("storeIP is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIPEqualTo(String value) {
            addCriterion("storeIP =", value, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPNotEqualTo(String value) {
            addCriterion("storeIP <>", value, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPGreaterThan(String value) {
            addCriterion("storeIP >", value, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPGreaterThanOrEqualTo(String value) {
            addCriterion("storeIP >=", value, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPLessThan(String value) {
            addCriterion("storeIP <", value, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPLessThanOrEqualTo(String value) {
            addCriterion("storeIP <=", value, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPLike(String value) {
            addCriterion("storeIP like", value, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPNotLike(String value) {
            addCriterion("storeIP not like", value, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPIn(List<String> values) {
            addCriterion("storeIP in", values, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPNotIn(List<String> values) {
            addCriterion("storeIP not in", values, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPBetween(String value1, String value2) {
            addCriterion("storeIP between", value1, value2, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreIPNotBetween(String value1, String value2) {
            addCriterion("storeIP not between", value1, value2, "storeIP");
            return (Criteria) this;
        }

        public Criteria andStoreMACIsNull() {
            addCriterion("storeMAC is null");
            return (Criteria) this;
        }

        public Criteria andStoreMACIsNotNull() {
            addCriterion("storeMAC is not null");
            return (Criteria) this;
        }

        public Criteria andStoreMACEqualTo(String value) {
            addCriterion("storeMAC =", value, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACNotEqualTo(String value) {
            addCriterion("storeMAC <>", value, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACGreaterThan(String value) {
            addCriterion("storeMAC >", value, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACGreaterThanOrEqualTo(String value) {
            addCriterion("storeMAC >=", value, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACLessThan(String value) {
            addCriterion("storeMAC <", value, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACLessThanOrEqualTo(String value) {
            addCriterion("storeMAC <=", value, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACLike(String value) {
            addCriterion("storeMAC like", value, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACNotLike(String value) {
            addCriterion("storeMAC not like", value, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACIn(List<String> values) {
            addCriterion("storeMAC in", values, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACNotIn(List<String> values) {
            addCriterion("storeMAC not in", values, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACBetween(String value1, String value2) {
            addCriterion("storeMAC between", value1, value2, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreMACNotBetween(String value1, String value2) {
            addCriterion("storeMAC not between", value1, value2, "storeMAC");
            return (Criteria) this;
        }

        public Criteria andStoreHostIsNull() {
            addCriterion("storeHost is null");
            return (Criteria) this;
        }

        public Criteria andStoreHostIsNotNull() {
            addCriterion("storeHost is not null");
            return (Criteria) this;
        }

        public Criteria andStoreHostEqualTo(String value) {
            addCriterion("storeHost =", value, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostNotEqualTo(String value) {
            addCriterion("storeHost <>", value, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostGreaterThan(String value) {
            addCriterion("storeHost >", value, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostGreaterThanOrEqualTo(String value) {
            addCriterion("storeHost >=", value, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostLessThan(String value) {
            addCriterion("storeHost <", value, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostLessThanOrEqualTo(String value) {
            addCriterion("storeHost <=", value, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostLike(String value) {
            addCriterion("storeHost like", value, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostNotLike(String value) {
            addCriterion("storeHost not like", value, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostIn(List<String> values) {
            addCriterion("storeHost in", values, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostNotIn(List<String> values) {
            addCriterion("storeHost not in", values, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostBetween(String value1, String value2) {
            addCriterion("storeHost between", value1, value2, "storeHost");
            return (Criteria) this;
        }

        public Criteria andStoreHostNotBetween(String value1, String value2) {
            addCriterion("storeHost not between", value1, value2, "storeHost");
            return (Criteria) this;
        }

        public Criteria andSocialPortIsNull() {
            addCriterion("socialPort is null");
            return (Criteria) this;
        }

        public Criteria andSocialPortIsNotNull() {
            addCriterion("socialPort is not null");
            return (Criteria) this;
        }

        public Criteria andSocialPortEqualTo(String value) {
            addCriterion("socialPort =", value, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortNotEqualTo(String value) {
            addCriterion("socialPort <>", value, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortGreaterThan(String value) {
            addCriterion("socialPort >", value, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortGreaterThanOrEqualTo(String value) {
            addCriterion("socialPort >=", value, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortLessThan(String value) {
            addCriterion("socialPort <", value, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortLessThanOrEqualTo(String value) {
            addCriterion("socialPort <=", value, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortLike(String value) {
            addCriterion("socialPort like", value, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortNotLike(String value) {
            addCriterion("socialPort not like", value, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortIn(List<String> values) {
            addCriterion("socialPort in", values, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortNotIn(List<String> values) {
            addCriterion("socialPort not in", values, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortBetween(String value1, String value2) {
            addCriterion("socialPort between", value1, value2, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialPortNotBetween(String value1, String value2) {
            addCriterion("socialPort not between", value1, value2, "socialPort");
            return (Criteria) this;
        }

        public Criteria andSocialCommIsNull() {
            addCriterion("socialComm is null");
            return (Criteria) this;
        }

        public Criteria andSocialCommIsNotNull() {
            addCriterion("socialComm is not null");
            return (Criteria) this;
        }

        public Criteria andSocialCommEqualTo(String value) {
            addCriterion("socialComm =", value, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommNotEqualTo(String value) {
            addCriterion("socialComm <>", value, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommGreaterThan(String value) {
            addCriterion("socialComm >", value, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommGreaterThanOrEqualTo(String value) {
            addCriterion("socialComm >=", value, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommLessThan(String value) {
            addCriterion("socialComm <", value, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommLessThanOrEqualTo(String value) {
            addCriterion("socialComm <=", value, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommLike(String value) {
            addCriterion("socialComm like", value, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommNotLike(String value) {
            addCriterion("socialComm not like", value, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommIn(List<String> values) {
            addCriterion("socialComm in", values, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommNotIn(List<String> values) {
            addCriterion("socialComm not in", values, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommBetween(String value1, String value2) {
            addCriterion("socialComm between", value1, value2, "socialComm");
            return (Criteria) this;
        }

        public Criteria andSocialCommNotBetween(String value1, String value2) {
            addCriterion("socialComm not between", value1, value2, "socialComm");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyIsNull() {
            addCriterion("storeAppkey is null");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyIsNotNull() {
            addCriterion("storeAppkey is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyEqualTo(String value) {
            addCriterion("storeAppkey =", value, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyNotEqualTo(String value) {
            addCriterion("storeAppkey <>", value, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyGreaterThan(String value) {
            addCriterion("storeAppkey >", value, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyGreaterThanOrEqualTo(String value) {
            addCriterion("storeAppkey >=", value, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyLessThan(String value) {
            addCriterion("storeAppkey <", value, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyLessThanOrEqualTo(String value) {
            addCriterion("storeAppkey <=", value, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyLike(String value) {
            addCriterion("storeAppkey like", value, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyNotLike(String value) {
            addCriterion("storeAppkey not like", value, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyIn(List<String> values) {
            addCriterion("storeAppkey in", values, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyNotIn(List<String> values) {
            addCriterion("storeAppkey not in", values, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyBetween(String value1, String value2) {
            addCriterion("storeAppkey between", value1, value2, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreAppkeyNotBetween(String value1, String value2) {
            addCriterion("storeAppkey not between", value1, value2, "storeAppkey");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretIsNull() {
            addCriterion("storeApisecret is null");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretIsNotNull() {
            addCriterion("storeApisecret is not null");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretEqualTo(String value) {
            addCriterion("storeApisecret =", value, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretNotEqualTo(String value) {
            addCriterion("storeApisecret <>", value, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretGreaterThan(String value) {
            addCriterion("storeApisecret >", value, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretGreaterThanOrEqualTo(String value) {
            addCriterion("storeApisecret >=", value, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretLessThan(String value) {
            addCriterion("storeApisecret <", value, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretLessThanOrEqualTo(String value) {
            addCriterion("storeApisecret <=", value, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretLike(String value) {
            addCriterion("storeApisecret like", value, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretNotLike(String value) {
            addCriterion("storeApisecret not like", value, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretIn(List<String> values) {
            addCriterion("storeApisecret in", values, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretNotIn(List<String> values) {
            addCriterion("storeApisecret not in", values, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretBetween(String value1, String value2) {
            addCriterion("storeApisecret between", value1, value2, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApisecretNotBetween(String value1, String value2) {
            addCriterion("storeApisecret not between", value1, value2, "storeApisecret");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdIsNull() {
            addCriterion("storeApiId is null");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdIsNotNull() {
            addCriterion("storeApiId is not null");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdEqualTo(String value) {
            addCriterion("storeApiId =", value, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdNotEqualTo(String value) {
            addCriterion("storeApiId <>", value, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdGreaterThan(String value) {
            addCriterion("storeApiId >", value, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdGreaterThanOrEqualTo(String value) {
            addCriterion("storeApiId >=", value, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdLessThan(String value) {
            addCriterion("storeApiId <", value, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdLessThanOrEqualTo(String value) {
            addCriterion("storeApiId <=", value, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdLike(String value) {
            addCriterion("storeApiId like", value, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdNotLike(String value) {
            addCriterion("storeApiId not like", value, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdIn(List<String> values) {
            addCriterion("storeApiId in", values, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdNotIn(List<String> values) {
            addCriterion("storeApiId not in", values, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdBetween(String value1, String value2) {
            addCriterion("storeApiId between", value1, value2, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andStoreApiIdNotBetween(String value1, String value2) {
            addCriterion("storeApiId not between", value1, value2, "storeApiId");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modifyDate is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterionForJDBCDate("modifyDate =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("modifyDate <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("modifyDate >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modifyDate >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterionForJDBCDate("modifyDate <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modifyDate <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterionForJDBCDate("modifyDate in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("modifyDate not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modifyDate between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modifyDate not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadIsNull() {
            addCriterion("clickRunProductDownload is null");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadIsNotNull() {
            addCriterion("clickRunProductDownload is not null");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadEqualTo(Integer value) {
            addCriterion("clickRunProductDownload =", value, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadNotEqualTo(Integer value) {
            addCriterion("clickRunProductDownload <>", value, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadGreaterThan(Integer value) {
            addCriterion("clickRunProductDownload >", value, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickRunProductDownload >=", value, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadLessThan(Integer value) {
            addCriterion("clickRunProductDownload <", value, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadLessThanOrEqualTo(Integer value) {
            addCriterion("clickRunProductDownload <=", value, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadIn(List<Integer> values) {
            addCriterion("clickRunProductDownload in", values, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadNotIn(List<Integer> values) {
            addCriterion("clickRunProductDownload not in", values, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadBetween(Integer value1, Integer value2) {
            addCriterion("clickRunProductDownload between", value1, value2, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunProductDownloadNotBetween(Integer value1, Integer value2) {
            addCriterion("clickRunProductDownload not between", value1, value2, "clickRunProductDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadIsNull() {
            addCriterion("clickRunPurchaseDownload is null");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadIsNotNull() {
            addCriterion("clickRunPurchaseDownload is not null");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadEqualTo(Integer value) {
            addCriterion("clickRunPurchaseDownload =", value, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadNotEqualTo(Integer value) {
            addCriterion("clickRunPurchaseDownload <>", value, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadGreaterThan(Integer value) {
            addCriterion("clickRunPurchaseDownload >", value, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickRunPurchaseDownload >=", value, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadLessThan(Integer value) {
            addCriterion("clickRunPurchaseDownload <", value, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadLessThanOrEqualTo(Integer value) {
            addCriterion("clickRunPurchaseDownload <=", value, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadIn(List<Integer> values) {
            addCriterion("clickRunPurchaseDownload in", values, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadNotIn(List<Integer> values) {
            addCriterion("clickRunPurchaseDownload not in", values, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadBetween(Integer value1, Integer value2) {
            addCriterion("clickRunPurchaseDownload between", value1, value2, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andClickRunPurchaseDownloadNotBetween(Integer value1, Integer value2) {
            addCriterion("clickRunPurchaseDownload not between", value1, value2, "clickRunPurchaseDownload");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusIsNull() {
            addCriterion("migrateMemberStatus is null");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusIsNotNull() {
            addCriterion("migrateMemberStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusEqualTo(Integer value) {
            addCriterion("migrateMemberStatus =", value, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusNotEqualTo(Integer value) {
            addCriterion("migrateMemberStatus <>", value, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusGreaterThan(Integer value) {
            addCriterion("migrateMemberStatus >", value, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("migrateMemberStatus >=", value, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusLessThan(Integer value) {
            addCriterion("migrateMemberStatus <", value, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusLessThanOrEqualTo(Integer value) {
            addCriterion("migrateMemberStatus <=", value, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusIn(List<Integer> values) {
            addCriterion("migrateMemberStatus in", values, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusNotIn(List<Integer> values) {
            addCriterion("migrateMemberStatus not in", values, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusBetween(Integer value1, Integer value2) {
            addCriterion("migrateMemberStatus between", value1, value2, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateMemberStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("migrateMemberStatus not between", value1, value2, "migrateMemberStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusIsNull() {
            addCriterion("migrateStockStatus is null");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusIsNotNull() {
            addCriterion("migrateStockStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusEqualTo(Integer value) {
            addCriterion("migrateStockStatus =", value, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusNotEqualTo(Integer value) {
            addCriterion("migrateStockStatus <>", value, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusGreaterThan(Integer value) {
            addCriterion("migrateStockStatus >", value, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("migrateStockStatus >=", value, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusLessThan(Integer value) {
            addCriterion("migrateStockStatus <", value, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusLessThanOrEqualTo(Integer value) {
            addCriterion("migrateStockStatus <=", value, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusIn(List<Integer> values) {
            addCriterion("migrateStockStatus in", values, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusNotIn(List<Integer> values) {
            addCriterion("migrateStockStatus not in", values, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusBetween(Integer value1, Integer value2) {
            addCriterion("migrateStockStatus between", value1, value2, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateStockStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("migrateStockStatus not between", value1, value2, "migrateStockStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusIsNull() {
            addCriterion("migratePurchaseStatus is null");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusIsNotNull() {
            addCriterion("migratePurchaseStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusEqualTo(Integer value) {
            addCriterion("migratePurchaseStatus =", value, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusNotEqualTo(Integer value) {
            addCriterion("migratePurchaseStatus <>", value, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusGreaterThan(Integer value) {
            addCriterion("migratePurchaseStatus >", value, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("migratePurchaseStatus >=", value, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusLessThan(Integer value) {
            addCriterion("migratePurchaseStatus <", value, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("migratePurchaseStatus <=", value, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusIn(List<Integer> values) {
            addCriterion("migratePurchaseStatus in", values, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusNotIn(List<Integer> values) {
            addCriterion("migratePurchaseStatus not in", values, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusBetween(Integer value1, Integer value2) {
            addCriterion("migratePurchaseStatus between", value1, value2, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePurchaseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("migratePurchaseStatus not between", value1, value2, "migratePurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusIsNull() {
            addCriterion("migrateSaleStatus is null");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusIsNotNull() {
            addCriterion("migrateSaleStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusEqualTo(Integer value) {
            addCriterion("migrateSaleStatus =", value, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusNotEqualTo(Integer value) {
            addCriterion("migrateSaleStatus <>", value, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusGreaterThan(Integer value) {
            addCriterion("migrateSaleStatus >", value, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("migrateSaleStatus >=", value, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusLessThan(Integer value) {
            addCriterion("migrateSaleStatus <", value, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("migrateSaleStatus <=", value, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusIn(List<Integer> values) {
            addCriterion("migrateSaleStatus in", values, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusNotIn(List<Integer> values) {
            addCriterion("migrateSaleStatus not in", values, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusBetween(Integer value1, Integer value2) {
            addCriterion("migrateSaleStatus between", value1, value2, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigrateSaleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("migrateSaleStatus not between", value1, value2, "migrateSaleStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusIsNull() {
            addCriterion("migratePriceStatus is null");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusIsNotNull() {
            addCriterion("migratePriceStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusEqualTo(Integer value) {
            addCriterion("migratePriceStatus =", value, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusNotEqualTo(Integer value) {
            addCriterion("migratePriceStatus <>", value, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusGreaterThan(Integer value) {
            addCriterion("migratePriceStatus >", value, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("migratePriceStatus >=", value, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusLessThan(Integer value) {
            addCriterion("migratePriceStatus <", value, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("migratePriceStatus <=", value, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusIn(List<Integer> values) {
            addCriterion("migratePriceStatus in", values, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusNotIn(List<Integer> values) {
            addCriterion("migratePriceStatus not in", values, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusBetween(Integer value1, Integer value2) {
            addCriterion("migratePriceStatus between", value1, value2, "migratePriceStatus");
            return (Criteria) this;
        }

        public Criteria andMigratePriceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("migratePriceStatus not between", value1, value2, "migratePriceStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}