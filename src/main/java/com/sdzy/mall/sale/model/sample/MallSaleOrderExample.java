package com.sdzy.mall.sale.model.sample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MallSaleOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallSaleOrderExample() {
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

        public Criteria andSaleOrderIdIsNull() {
            addCriterion("saleOrderId is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdIsNotNull() {
            addCriterion("saleOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdEqualTo(String value) {
            addCriterion("saleOrderId =", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotEqualTo(String value) {
            addCriterion("saleOrderId <>", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdGreaterThan(String value) {
            addCriterion("saleOrderId >", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("saleOrderId >=", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdLessThan(String value) {
            addCriterion("saleOrderId <", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdLessThanOrEqualTo(String value) {
            addCriterion("saleOrderId <=", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdLike(String value) {
            addCriterion("saleOrderId like", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotLike(String value) {
            addCriterion("saleOrderId not like", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdIn(List<String> values) {
            addCriterion("saleOrderId in", values, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotIn(List<String> values) {
            addCriterion("saleOrderId not in", values, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdBetween(String value1, String value2) {
            addCriterion("saleOrderId between", value1, value2, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotBetween(String value1, String value2) {
            addCriterion("saleOrderId not between", value1, value2, "saleOrderId");
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

        public Criteria andSaleOrderTypeIsNull() {
            addCriterion("saleOrderType is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeIsNotNull() {
            addCriterion("saleOrderType is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeEqualTo(Integer value) {
            addCriterion("saleOrderType =", value, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeNotEqualTo(Integer value) {
            addCriterion("saleOrderType <>", value, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeGreaterThan(Integer value) {
            addCriterion("saleOrderType >", value, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("saleOrderType >=", value, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeLessThan(Integer value) {
            addCriterion("saleOrderType <", value, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("saleOrderType <=", value, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeIn(List<Integer> values) {
            addCriterion("saleOrderType in", values, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeNotIn(List<Integer> values) {
            addCriterion("saleOrderType not in", values, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("saleOrderType between", value1, value2, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("saleOrderType not between", value1, value2, "saleOrderType");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoIsNull() {
            addCriterion("saleOrderNo is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoIsNotNull() {
            addCriterion("saleOrderNo is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoEqualTo(String value) {
            addCriterion("saleOrderNo =", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoNotEqualTo(String value) {
            addCriterion("saleOrderNo <>", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoGreaterThan(String value) {
            addCriterion("saleOrderNo >", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("saleOrderNo >=", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoLessThan(String value) {
            addCriterion("saleOrderNo <", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoLessThanOrEqualTo(String value) {
            addCriterion("saleOrderNo <=", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoLike(String value) {
            addCriterion("saleOrderNo like", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoNotLike(String value) {
            addCriterion("saleOrderNo not like", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoIn(List<String> values) {
            addCriterion("saleOrderNo in", values, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoNotIn(List<String> values) {
            addCriterion("saleOrderNo not in", values, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoBetween(String value1, String value2) {
            addCriterion("saleOrderNo between", value1, value2, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoNotBetween(String value1, String value2) {
            addCriterion("saleOrderNo not between", value1, value2, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleDateIsNull() {
            addCriterion("saleDate is null");
            return (Criteria) this;
        }

        public Criteria andSaleDateIsNotNull() {
            addCriterion("saleDate is not null");
            return (Criteria) this;
        }

        public Criteria andSaleDateEqualTo(Date value) {
            addCriterion("saleDate =", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateNotEqualTo(Date value) {
            addCriterion("saleDate <>", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateGreaterThan(Date value) {
            addCriterion("saleDate >", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateGreaterThanOrEqualTo(Date value) {
            addCriterion("saleDate >=", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateLessThan(Date value) {
            addCriterion("saleDate <", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateLessThanOrEqualTo(Date value) {
            addCriterion("saleDate <=", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateIn(List<Date> values) {
            addCriterion("saleDate in", values, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateNotIn(List<Date> values) {
            addCriterion("saleDate not in", values, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateBetween(Date value1, Date value2) {
            addCriterion("saleDate between", value1, value2, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateNotBetween(Date value1, Date value2) {
            addCriterion("saleDate not between", value1, value2, "saleDate");
            return (Criteria) this;
        }

        public Criteria andMemberIsNull() {
            addCriterion("member is null");
            return (Criteria) this;
        }

        public Criteria andMemberIsNotNull() {
            addCriterion("member is not null");
            return (Criteria) this;
        }

        public Criteria andMemberEqualTo(String value) {
            addCriterion("member =", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotEqualTo(String value) {
            addCriterion("member <>", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberGreaterThan(String value) {
            addCriterion("member >", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberGreaterThanOrEqualTo(String value) {
            addCriterion("member >=", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberLessThan(String value) {
            addCriterion("member <", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberLessThanOrEqualTo(String value) {
            addCriterion("member <=", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberLike(String value) {
            addCriterion("member like", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotLike(String value) {
            addCriterion("member not like", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberIn(List<String> values) {
            addCriterion("member in", values, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotIn(List<String> values) {
            addCriterion("member not in", values, "member");
            return (Criteria) this;
        }

        public Criteria andMemberBetween(String value1, String value2) {
            addCriterion("member between", value1, value2, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotBetween(String value1, String value2) {
            addCriterion("member not between", value1, value2, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNoIsNull() {
            addCriterion("memberNo is null");
            return (Criteria) this;
        }

        public Criteria andMemberNoIsNotNull() {
            addCriterion("memberNo is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNoEqualTo(String value) {
            addCriterion("memberNo =", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotEqualTo(String value) {
            addCriterion("memberNo <>", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoGreaterThan(String value) {
            addCriterion("memberNo >", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoGreaterThanOrEqualTo(String value) {
            addCriterion("memberNo >=", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLessThan(String value) {
            addCriterion("memberNo <", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLessThanOrEqualTo(String value) {
            addCriterion("memberNo <=", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLike(String value) {
            addCriterion("memberNo like", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotLike(String value) {
            addCriterion("memberNo not like", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoIn(List<String> values) {
            addCriterion("memberNo in", values, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotIn(List<String> values) {
            addCriterion("memberNo not in", values, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoBetween(String value1, String value2) {
            addCriterion("memberNo between", value1, value2, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotBetween(String value1, String value2) {
            addCriterion("memberNo not between", value1, value2, "memberNo");
            return (Criteria) this;
        }

        public Criteria andIsPendingIsNull() {
            addCriterion("isPending is null");
            return (Criteria) this;
        }

        public Criteria andIsPendingIsNotNull() {
            addCriterion("isPending is not null");
            return (Criteria) this;
        }

        public Criteria andIsPendingEqualTo(Integer value) {
            addCriterion("isPending =", value, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingNotEqualTo(Integer value) {
            addCriterion("isPending <>", value, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingGreaterThan(Integer value) {
            addCriterion("isPending >", value, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingGreaterThanOrEqualTo(Integer value) {
            addCriterion("isPending >=", value, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingLessThan(Integer value) {
            addCriterion("isPending <", value, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingLessThanOrEqualTo(Integer value) {
            addCriterion("isPending <=", value, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingIn(List<Integer> values) {
            addCriterion("isPending in", values, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingNotIn(List<Integer> values) {
            addCriterion("isPending not in", values, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingBetween(Integer value1, Integer value2) {
            addCriterion("isPending between", value1, value2, "isPending");
            return (Criteria) this;
        }

        public Criteria andIsPendingNotBetween(Integer value1, Integer value2) {
            addCriterion("isPending not between", value1, value2, "isPending");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkIsNull() {
            addCriterion("pendingRemark is null");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkIsNotNull() {
            addCriterion("pendingRemark is not null");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkEqualTo(String value) {
            addCriterion("pendingRemark =", value, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkNotEqualTo(String value) {
            addCriterion("pendingRemark <>", value, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkGreaterThan(String value) {
            addCriterion("pendingRemark >", value, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pendingRemark >=", value, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkLessThan(String value) {
            addCriterion("pendingRemark <", value, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkLessThanOrEqualTo(String value) {
            addCriterion("pendingRemark <=", value, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkLike(String value) {
            addCriterion("pendingRemark like", value, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkNotLike(String value) {
            addCriterion("pendingRemark not like", value, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkIn(List<String> values) {
            addCriterion("pendingRemark in", values, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkNotIn(List<String> values) {
            addCriterion("pendingRemark not in", values, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkBetween(String value1, String value2) {
            addCriterion("pendingRemark between", value1, value2, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andPendingRemarkNotBetween(String value1, String value2) {
            addCriterion("pendingRemark not between", value1, value2, "pendingRemark");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNull() {
            addCriterion("totalCount is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("totalCount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(BigDecimal value) {
            addCriterion("totalCount =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(BigDecimal value) {
            addCriterion("totalCount <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(BigDecimal value) {
            addCriterion("totalCount >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalCount >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(BigDecimal value) {
            addCriterion("totalCount <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalCount <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<BigDecimal> values) {
            addCriterion("totalCount in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<BigDecimal> values) {
            addCriterion("totalCount not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalCount between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalCount not between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountIsNull() {
            addCriterion("totalRetailAmount is null");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountIsNotNull() {
            addCriterion("totalRetailAmount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountEqualTo(BigDecimal value) {
            addCriterion("totalRetailAmount =", value, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountNotEqualTo(BigDecimal value) {
            addCriterion("totalRetailAmount <>", value, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountGreaterThan(BigDecimal value) {
            addCriterion("totalRetailAmount >", value, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalRetailAmount >=", value, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountLessThan(BigDecimal value) {
            addCriterion("totalRetailAmount <", value, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalRetailAmount <=", value, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountIn(List<BigDecimal> values) {
            addCriterion("totalRetailAmount in", values, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountNotIn(List<BigDecimal> values) {
            addCriterion("totalRetailAmount not in", values, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalRetailAmount between", value1, value2, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRetailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalRetailAmount not between", value1, value2, "totalRetailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountIsNull() {
            addCriterion("totalMemberAmount is null");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountIsNotNull() {
            addCriterion("totalMemberAmount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountEqualTo(BigDecimal value) {
            addCriterion("totalMemberAmount =", value, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountNotEqualTo(BigDecimal value) {
            addCriterion("totalMemberAmount <>", value, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountGreaterThan(BigDecimal value) {
            addCriterion("totalMemberAmount >", value, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalMemberAmount >=", value, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountLessThan(BigDecimal value) {
            addCriterion("totalMemberAmount <", value, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalMemberAmount <=", value, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountIn(List<BigDecimal> values) {
            addCriterion("totalMemberAmount in", values, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountNotIn(List<BigDecimal> values) {
            addCriterion("totalMemberAmount not in", values, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalMemberAmount between", value1, value2, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMemberAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalMemberAmount not between", value1, value2, "totalMemberAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeIsNull() {
            addCriterion("totalDiscountFee is null");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeIsNotNull() {
            addCriterion("totalDiscountFee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeEqualTo(BigDecimal value) {
            addCriterion("totalDiscountFee =", value, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeNotEqualTo(BigDecimal value) {
            addCriterion("totalDiscountFee <>", value, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeGreaterThan(BigDecimal value) {
            addCriterion("totalDiscountFee >", value, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalDiscountFee >=", value, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeLessThan(BigDecimal value) {
            addCriterion("totalDiscountFee <", value, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalDiscountFee <=", value, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeIn(List<BigDecimal> values) {
            addCriterion("totalDiscountFee in", values, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeNotIn(List<BigDecimal> values) {
            addCriterion("totalDiscountFee not in", values, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalDiscountFee between", value1, value2, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andTotalDiscountFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalDiscountFee not between", value1, value2, "totalDiscountFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeIsNull() {
            addCriterion("toalOtherFee is null");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeIsNotNull() {
            addCriterion("toalOtherFee is not null");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeEqualTo(BigDecimal value) {
            addCriterion("toalOtherFee =", value, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeNotEqualTo(BigDecimal value) {
            addCriterion("toalOtherFee <>", value, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeGreaterThan(BigDecimal value) {
            addCriterion("toalOtherFee >", value, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("toalOtherFee >=", value, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeLessThan(BigDecimal value) {
            addCriterion("toalOtherFee <", value, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("toalOtherFee <=", value, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeIn(List<BigDecimal> values) {
            addCriterion("toalOtherFee in", values, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeNotIn(List<BigDecimal> values) {
            addCriterion("toalOtherFee not in", values, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("toalOtherFee between", value1, value2, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andToalOtherFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("toalOtherFee not between", value1, value2, "toalOtherFee");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyIsNull() {
            addCriterion("paymentMoney is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyIsNotNull() {
            addCriterion("paymentMoney is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyEqualTo(BigDecimal value) {
            addCriterion("paymentMoney =", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyNotEqualTo(BigDecimal value) {
            addCriterion("paymentMoney <>", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyGreaterThan(BigDecimal value) {
            addCriterion("paymentMoney >", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paymentMoney >=", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyLessThan(BigDecimal value) {
            addCriterion("paymentMoney <", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paymentMoney <=", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyIn(List<BigDecimal> values) {
            addCriterion("paymentMoney in", values, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyNotIn(List<BigDecimal> values) {
            addCriterion("paymentMoney not in", values, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paymentMoney between", value1, value2, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paymentMoney not between", value1, value2, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyIsNull() {
            addCriterion("receiveMoney is null");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyIsNotNull() {
            addCriterion("receiveMoney is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyEqualTo(BigDecimal value) {
            addCriterion("receiveMoney =", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyNotEqualTo(BigDecimal value) {
            addCriterion("receiveMoney <>", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyGreaterThan(BigDecimal value) {
            addCriterion("receiveMoney >", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receiveMoney >=", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyLessThan(BigDecimal value) {
            addCriterion("receiveMoney <", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receiveMoney <=", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyIn(List<BigDecimal> values) {
            addCriterion("receiveMoney in", values, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyNotIn(List<BigDecimal> values) {
            addCriterion("receiveMoney not in", values, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receiveMoney between", value1, value2, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receiveMoney not between", value1, value2, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyIsNull() {
            addCriterion("changeMoney is null");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyIsNotNull() {
            addCriterion("changeMoney is not null");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyEqualTo(BigDecimal value) {
            addCriterion("changeMoney =", value, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("changeMoney <>", value, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyGreaterThan(BigDecimal value) {
            addCriterion("changeMoney >", value, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("changeMoney >=", value, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyLessThan(BigDecimal value) {
            addCriterion("changeMoney <", value, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("changeMoney <=", value, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyIn(List<BigDecimal> values) {
            addCriterion("changeMoney in", values, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("changeMoney not in", values, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("changeMoney between", value1, value2, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andChangeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("changeMoney not between", value1, value2, "changeMoney");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumIsNull() {
            addCriterion("totalSaleNum is null");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumIsNotNull() {
            addCriterion("totalSaleNum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumEqualTo(BigDecimal value) {
            addCriterion("totalSaleNum =", value, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumNotEqualTo(BigDecimal value) {
            addCriterion("totalSaleNum <>", value, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumGreaterThan(BigDecimal value) {
            addCriterion("totalSaleNum >", value, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalSaleNum >=", value, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumLessThan(BigDecimal value) {
            addCriterion("totalSaleNum <", value, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalSaleNum <=", value, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumIn(List<BigDecimal> values) {
            addCriterion("totalSaleNum in", values, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumNotIn(List<BigDecimal> values) {
            addCriterion("totalSaleNum not in", values, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalSaleNum between", value1, value2, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalSaleNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalSaleNum not between", value1, value2, "totalSaleNum");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountIsNull() {
            addCriterion("totalReduceAmount is null");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountIsNotNull() {
            addCriterion("totalReduceAmount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountEqualTo(BigDecimal value) {
            addCriterion("totalReduceAmount =", value, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountNotEqualTo(BigDecimal value) {
            addCriterion("totalReduceAmount <>", value, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountGreaterThan(BigDecimal value) {
            addCriterion("totalReduceAmount >", value, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalReduceAmount >=", value, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountLessThan(BigDecimal value) {
            addCriterion("totalReduceAmount <", value, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalReduceAmount <=", value, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountIn(List<BigDecimal> values) {
            addCriterion("totalReduceAmount in", values, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountNotIn(List<BigDecimal> values) {
            addCriterion("totalReduceAmount not in", values, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalReduceAmount between", value1, value2, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReduceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalReduceAmount not between", value1, value2, "totalReduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumIsNull() {
            addCriterion("totalGiveNum is null");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumIsNotNull() {
            addCriterion("totalGiveNum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumEqualTo(BigDecimal value) {
            addCriterion("totalGiveNum =", value, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumNotEqualTo(BigDecimal value) {
            addCriterion("totalGiveNum <>", value, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumGreaterThan(BigDecimal value) {
            addCriterion("totalGiveNum >", value, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalGiveNum >=", value, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumLessThan(BigDecimal value) {
            addCriterion("totalGiveNum <", value, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalGiveNum <=", value, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumIn(List<BigDecimal> values) {
            addCriterion("totalGiveNum in", values, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumNotIn(List<BigDecimal> values) {
            addCriterion("totalGiveNum not in", values, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalGiveNum between", value1, value2, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andTotalGiveNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalGiveNum not between", value1, value2, "totalGiveNum");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("isPay is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("isPay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(Integer value) {
            addCriterion("isPay =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(Integer value) {
            addCriterion("isPay <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(Integer value) {
            addCriterion("isPay >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("isPay >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(Integer value) {
            addCriterion("isPay <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(Integer value) {
            addCriterion("isPay <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<Integer> values) {
            addCriterion("isPay in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<Integer> values) {
            addCriterion("isPay not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(Integer value1, Integer value2) {
            addCriterion("isPay between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(Integer value1, Integer value2) {
            addCriterion("isPay not between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("payType is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("payType is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("payType =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("payType <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("payType >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("payType >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("payType <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("payType <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("payType like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("payType not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("payType in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("payType not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("payType between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("payType not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugIsNull() {
            addCriterion("isRxDrug is null");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugIsNotNull() {
            addCriterion("isRxDrug is not null");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugEqualTo(Integer value) {
            addCriterion("isRxDrug =", value, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugNotEqualTo(Integer value) {
            addCriterion("isRxDrug <>", value, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugGreaterThan(Integer value) {
            addCriterion("isRxDrug >", value, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugGreaterThanOrEqualTo(Integer value) {
            addCriterion("isRxDrug >=", value, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugLessThan(Integer value) {
            addCriterion("isRxDrug <", value, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugLessThanOrEqualTo(Integer value) {
            addCriterion("isRxDrug <=", value, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugIn(List<Integer> values) {
            addCriterion("isRxDrug in", values, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugNotIn(List<Integer> values) {
            addCriterion("isRxDrug not in", values, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugBetween(Integer value1, Integer value2) {
            addCriterion("isRxDrug between", value1, value2, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsRxDrugNotBetween(Integer value1, Integer value2) {
            addCriterion("isRxDrug not between", value1, value2, "isRxDrug");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineIsNull() {
            addCriterion("isEphedrine is null");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineIsNotNull() {
            addCriterion("isEphedrine is not null");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineEqualTo(Integer value) {
            addCriterion("isEphedrine =", value, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineNotEqualTo(Integer value) {
            addCriterion("isEphedrine <>", value, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineGreaterThan(Integer value) {
            addCriterion("isEphedrine >", value, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineGreaterThanOrEqualTo(Integer value) {
            addCriterion("isEphedrine >=", value, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineLessThan(Integer value) {
            addCriterion("isEphedrine <", value, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineLessThanOrEqualTo(Integer value) {
            addCriterion("isEphedrine <=", value, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineIn(List<Integer> values) {
            addCriterion("isEphedrine in", values, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineNotIn(List<Integer> values) {
            addCriterion("isEphedrine not in", values, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineBetween(Integer value1, Integer value2) {
            addCriterion("isEphedrine between", value1, value2, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andIsEphedrineNotBetween(Integer value1, Integer value2) {
            addCriterion("isEphedrine not between", value1, value2, "isEphedrine");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("createDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("createDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("createDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createDate");
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
            addCriterion("modifyDate =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modifyDate <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modifyDate >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modifyDate >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modifyDate <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modifyDate <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modifyDate in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modifyDate not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modifyDate between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modifyDate not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNull() {
            addCriterion("sellerId is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("sellerId is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("sellerId =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("sellerId <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("sellerId >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("sellerId >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("sellerId <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("sellerId <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("sellerId like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("sellerId not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("sellerId in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("sellerId not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("sellerId between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("sellerId not between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIsNull() {
            addCriterion("seller is null");
            return (Criteria) this;
        }

        public Criteria andSellerIsNotNull() {
            addCriterion("seller is not null");
            return (Criteria) this;
        }

        public Criteria andSellerEqualTo(String value) {
            addCriterion("seller =", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotEqualTo(String value) {
            addCriterion("seller <>", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerGreaterThan(String value) {
            addCriterion("seller >", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerGreaterThanOrEqualTo(String value) {
            addCriterion("seller >=", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLessThan(String value) {
            addCriterion("seller <", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLessThanOrEqualTo(String value) {
            addCriterion("seller <=", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLike(String value) {
            addCriterion("seller like", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotLike(String value) {
            addCriterion("seller not like", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerIn(List<String> values) {
            addCriterion("seller in", values, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotIn(List<String> values) {
            addCriterion("seller not in", values, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerBetween(String value1, String value2) {
            addCriterion("seller between", value1, value2, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotBetween(String value1, String value2) {
            addCriterion("seller not between", value1, value2, "seller");
            return (Criteria) this;
        }

        public Criteria andOperaterIdIsNull() {
            addCriterion("operaterId is null");
            return (Criteria) this;
        }

        public Criteria andOperaterIdIsNotNull() {
            addCriterion("operaterId is not null");
            return (Criteria) this;
        }

        public Criteria andOperaterIdEqualTo(String value) {
            addCriterion("operaterId =", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdNotEqualTo(String value) {
            addCriterion("operaterId <>", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdGreaterThan(String value) {
            addCriterion("operaterId >", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdGreaterThanOrEqualTo(String value) {
            addCriterion("operaterId >=", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdLessThan(String value) {
            addCriterion("operaterId <", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdLessThanOrEqualTo(String value) {
            addCriterion("operaterId <=", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdLike(String value) {
            addCriterion("operaterId like", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdNotLike(String value) {
            addCriterion("operaterId not like", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdIn(List<String> values) {
            addCriterion("operaterId in", values, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdNotIn(List<String> values) {
            addCriterion("operaterId not in", values, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdBetween(String value1, String value2) {
            addCriterion("operaterId between", value1, value2, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdNotBetween(String value1, String value2) {
            addCriterion("operaterId not between", value1, value2, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIsNull() {
            addCriterion("operater is null");
            return (Criteria) this;
        }

        public Criteria andOperaterIsNotNull() {
            addCriterion("operater is not null");
            return (Criteria) this;
        }

        public Criteria andOperaterEqualTo(String value) {
            addCriterion("operater =", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotEqualTo(String value) {
            addCriterion("operater <>", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterGreaterThan(String value) {
            addCriterion("operater >", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterGreaterThanOrEqualTo(String value) {
            addCriterion("operater >=", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLessThan(String value) {
            addCriterion("operater <", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLessThanOrEqualTo(String value) {
            addCriterion("operater <=", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLike(String value) {
            addCriterion("operater like", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotLike(String value) {
            addCriterion("operater not like", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterIn(List<String> values) {
            addCriterion("operater in", values, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotIn(List<String> values) {
            addCriterion("operater not in", values, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterBetween(String value1, String value2) {
            addCriterion("operater between", value1, value2, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotBetween(String value1, String value2) {
            addCriterion("operater not between", value1, value2, "operater");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("deleteFlag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("deleteFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("deleteFlag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("deleteFlag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("deleteFlag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleteFlag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("deleteFlag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("deleteFlag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("deleteFlag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("deleteFlag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("deleteFlag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("deleteFlag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIsNull() {
            addCriterion("buyerName is null");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIsNotNull() {
            addCriterion("buyerName is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerNameEqualTo(String value) {
            addCriterion("buyerName =", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotEqualTo(String value) {
            addCriterion("buyerName <>", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameGreaterThan(String value) {
            addCriterion("buyerName >", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            addCriterion("buyerName >=", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLessThan(String value) {
            addCriterion("buyerName <", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLessThanOrEqualTo(String value) {
            addCriterion("buyerName <=", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLike(String value) {
            addCriterion("buyerName like", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotLike(String value) {
            addCriterion("buyerName not like", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIn(List<String> values) {
            addCriterion("buyerName in", values, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotIn(List<String> values) {
            addCriterion("buyerName not in", values, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameBetween(String value1, String value2) {
            addCriterion("buyerName between", value1, value2, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotBetween(String value1, String value2) {
            addCriterion("buyerName not between", value1, value2, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoIsNull() {
            addCriterion("buyerCardNo is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoIsNotNull() {
            addCriterion("buyerCardNo is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoEqualTo(String value) {
            addCriterion("buyerCardNo =", value, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoNotEqualTo(String value) {
            addCriterion("buyerCardNo <>", value, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoGreaterThan(String value) {
            addCriterion("buyerCardNo >", value, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("buyerCardNo >=", value, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoLessThan(String value) {
            addCriterion("buyerCardNo <", value, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoLessThanOrEqualTo(String value) {
            addCriterion("buyerCardNo <=", value, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoLike(String value) {
            addCriterion("buyerCardNo like", value, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoNotLike(String value) {
            addCriterion("buyerCardNo not like", value, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoIn(List<String> values) {
            addCriterion("buyerCardNo in", values, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoNotIn(List<String> values) {
            addCriterion("buyerCardNo not in", values, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoBetween(String value1, String value2) {
            addCriterion("buyerCardNo between", value1, value2, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCardNoNotBetween(String value1, String value2) {
            addCriterion("buyerCardNo not between", value1, value2, "buyerCardNo");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneIsNull() {
            addCriterion("buyerPhone is null");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneIsNotNull() {
            addCriterion("buyerPhone is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneEqualTo(String value) {
            addCriterion("buyerPhone =", value, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneNotEqualTo(String value) {
            addCriterion("buyerPhone <>", value, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneGreaterThan(String value) {
            addCriterion("buyerPhone >", value, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("buyerPhone >=", value, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneLessThan(String value) {
            addCriterion("buyerPhone <", value, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneLessThanOrEqualTo(String value) {
            addCriterion("buyerPhone <=", value, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneLike(String value) {
            addCriterion("buyerPhone like", value, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneNotLike(String value) {
            addCriterion("buyerPhone not like", value, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneIn(List<String> values) {
            addCriterion("buyerPhone in", values, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneNotIn(List<String> values) {
            addCriterion("buyerPhone not in", values, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneBetween(String value1, String value2) {
            addCriterion("buyerPhone between", value1, value2, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerPhoneNotBetween(String value1, String value2) {
            addCriterion("buyerPhone not between", value1, value2, "buyerPhone");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdIsNull() {
            addCriterion("buyerFaceId is null");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdIsNotNull() {
            addCriterion("buyerFaceId is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdEqualTo(String value) {
            addCriterion("buyerFaceId =", value, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdNotEqualTo(String value) {
            addCriterion("buyerFaceId <>", value, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdGreaterThan(String value) {
            addCriterion("buyerFaceId >", value, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("buyerFaceId >=", value, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdLessThan(String value) {
            addCriterion("buyerFaceId <", value, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdLessThanOrEqualTo(String value) {
            addCriterion("buyerFaceId <=", value, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdLike(String value) {
            addCriterion("buyerFaceId like", value, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdNotLike(String value) {
            addCriterion("buyerFaceId not like", value, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdIn(List<String> values) {
            addCriterion("buyerFaceId in", values, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdNotIn(List<String> values) {
            addCriterion("buyerFaceId not in", values, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdBetween(String value1, String value2) {
            addCriterion("buyerFaceId between", value1, value2, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerFaceIdNotBetween(String value1, String value2) {
            addCriterion("buyerFaceId not between", value1, value2, "buyerFaceId");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNull() {
            addCriterion("returnStatus is null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNotNull() {
            addCriterion("returnStatus is not null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusEqualTo(Integer value) {
            addCriterion("returnStatus =", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotEqualTo(Integer value) {
            addCriterion("returnStatus <>", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThan(Integer value) {
            addCriterion("returnStatus >", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("returnStatus >=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThan(Integer value) {
            addCriterion("returnStatus <", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            addCriterion("returnStatus <=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIn(List<Integer> values) {
            addCriterion("returnStatus in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotIn(List<Integer> values) {
            addCriterion("returnStatus not in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            addCriterion("returnStatus between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("returnStatus not between", value1, value2, "returnStatus");
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