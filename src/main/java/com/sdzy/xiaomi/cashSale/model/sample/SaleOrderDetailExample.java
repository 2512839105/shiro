package com.sdzy.xiaomi.cashSale.model.sample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleOrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleOrderDetailExample() {
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

        public Criteria andSaleOrderDetailIdIsNull() {
            addCriterion("saleOrderDetailId is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdIsNotNull() {
            addCriterion("saleOrderDetailId is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdEqualTo(String value) {
            addCriterion("saleOrderDetailId =", value, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdNotEqualTo(String value) {
            addCriterion("saleOrderDetailId <>", value, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdGreaterThan(String value) {
            addCriterion("saleOrderDetailId >", value, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("saleOrderDetailId >=", value, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdLessThan(String value) {
            addCriterion("saleOrderDetailId <", value, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdLessThanOrEqualTo(String value) {
            addCriterion("saleOrderDetailId <=", value, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdLike(String value) {
            addCriterion("saleOrderDetailId like", value, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdNotLike(String value) {
            addCriterion("saleOrderDetailId not like", value, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdIn(List<String> values) {
            addCriterion("saleOrderDetailId in", values, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdNotIn(List<String> values) {
            addCriterion("saleOrderDetailId not in", values, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdBetween(String value1, String value2) {
            addCriterion("saleOrderDetailId between", value1, value2, "saleOrderDetailId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderDetailIdNotBetween(String value1, String value2) {
            addCriterion("saleOrderDetailId not between", value1, value2, "saleOrderDetailId");
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

        public Criteria andInspectionOrderNoIsNull() {
            addCriterion("inspectionOrderNo is null");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoIsNotNull() {
            addCriterion("inspectionOrderNo is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoEqualTo(String value) {
            addCriterion("inspectionOrderNo =", value, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoNotEqualTo(String value) {
            addCriterion("inspectionOrderNo <>", value, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoGreaterThan(String value) {
            addCriterion("inspectionOrderNo >", value, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("inspectionOrderNo >=", value, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoLessThan(String value) {
            addCriterion("inspectionOrderNo <", value, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoLessThanOrEqualTo(String value) {
            addCriterion("inspectionOrderNo <=", value, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoLike(String value) {
            addCriterion("inspectionOrderNo like", value, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoNotLike(String value) {
            addCriterion("inspectionOrderNo not like", value, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoIn(List<String> values) {
            addCriterion("inspectionOrderNo in", values, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoNotIn(List<String> values) {
            addCriterion("inspectionOrderNo not in", values, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoBetween(String value1, String value2) {
            addCriterion("inspectionOrderNo between", value1, value2, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andInspectionOrderNoNotBetween(String value1, String value2) {
            addCriterion("inspectionOrderNo not between", value1, value2, "inspectionOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("productId is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("productId is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("productId =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("productId <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("productId >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("productId >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("productId <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("productId <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("productId like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("productId not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("productId in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("productId not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("productId between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("productId not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("productCode is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("productCode is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("productCode =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("productCode <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("productCode >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("productCode >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("productCode <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("productCode <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("productCode like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("productCode not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("productCode in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("productCode not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("productCode between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("productCode not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("productName is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("productName is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("productName =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("productName <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("productName >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("productName >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("productName <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("productName <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("productName like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("productName not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("productName in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("productName not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("productName between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("productName not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andGenericNameIsNull() {
            addCriterion("genericName is null");
            return (Criteria) this;
        }

        public Criteria andGenericNameIsNotNull() {
            addCriterion("genericName is not null");
            return (Criteria) this;
        }

        public Criteria andGenericNameEqualTo(String value) {
            addCriterion("genericName =", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameNotEqualTo(String value) {
            addCriterion("genericName <>", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameGreaterThan(String value) {
            addCriterion("genericName >", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameGreaterThanOrEqualTo(String value) {
            addCriterion("genericName >=", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameLessThan(String value) {
            addCriterion("genericName <", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameLessThanOrEqualTo(String value) {
            addCriterion("genericName <=", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameLike(String value) {
            addCriterion("genericName like", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameNotLike(String value) {
            addCriterion("genericName not like", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameIn(List<String> values) {
            addCriterion("genericName in", values, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameNotIn(List<String> values) {
            addCriterion("genericName not in", values, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameBetween(String value1, String value2) {
            addCriterion("genericName between", value1, value2, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameNotBetween(String value1, String value2) {
            addCriterion("genericName not between", value1, value2, "genericName");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIsNull() {
            addCriterion("producingArea is null");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIsNotNull() {
            addCriterion("producingArea is not null");
            return (Criteria) this;
        }

        public Criteria andProducingAreaEqualTo(String value) {
            addCriterion("producingArea =", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotEqualTo(String value) {
            addCriterion("producingArea <>", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaGreaterThan(String value) {
            addCriterion("producingArea >", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaGreaterThanOrEqualTo(String value) {
            addCriterion("producingArea >=", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLessThan(String value) {
            addCriterion("producingArea <", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLessThanOrEqualTo(String value) {
            addCriterion("producingArea <=", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLike(String value) {
            addCriterion("producingArea like", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotLike(String value) {
            addCriterion("producingArea not like", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIn(List<String> values) {
            addCriterion("producingArea in", values, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotIn(List<String> values) {
            addCriterion("producingArea not in", values, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaBetween(String value1, String value2) {
            addCriterion("producingArea between", value1, value2, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotBetween(String value1, String value2) {
            addCriterion("producingArea not between", value1, value2, "producingArea");
            return (Criteria) this;
        }

        public Criteria andStandardIsNull() {
            addCriterion("standard is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("standard is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(String value) {
            addCriterion("standard =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(String value) {
            addCriterion("standard <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(String value) {
            addCriterion("standard >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(String value) {
            addCriterion("standard >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(String value) {
            addCriterion("standard <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(String value) {
            addCriterion("standard <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLike(String value) {
            addCriterion("standard like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotLike(String value) {
            addCriterion("standard not like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<String> values) {
            addCriterion("standard in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<String> values) {
            addCriterion("standard not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(String value1, String value2) {
            addCriterion("standard between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(String value1, String value2) {
            addCriterion("standard not between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNull() {
            addCriterion("approvalNumber is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNotNull() {
            addCriterion("approvalNumber is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberEqualTo(String value) {
            addCriterion("approvalNumber =", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotEqualTo(String value) {
            addCriterion("approvalNumber <>", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThan(String value) {
            addCriterion("approvalNumber >", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThanOrEqualTo(String value) {
            addCriterion("approvalNumber >=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThan(String value) {
            addCriterion("approvalNumber <", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThanOrEqualTo(String value) {
            addCriterion("approvalNumber <=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLike(String value) {
            addCriterion("approvalNumber like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotLike(String value) {
            addCriterion("approvalNumber not like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIn(List<String> values) {
            addCriterion("approvalNumber in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotIn(List<String> values) {
            addCriterion("approvalNumber not in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberBetween(String value1, String value2) {
            addCriterion("approvalNumber between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotBetween(String value1, String value2) {
            addCriterion("approvalNumber not between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryIsNull() {
            addCriterion("produceFactory is null");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryIsNotNull() {
            addCriterion("produceFactory is not null");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryEqualTo(String value) {
            addCriterion("produceFactory =", value, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryNotEqualTo(String value) {
            addCriterion("produceFactory <>", value, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryGreaterThan(String value) {
            addCriterion("produceFactory >", value, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("produceFactory >=", value, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryLessThan(String value) {
            addCriterion("produceFactory <", value, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryLessThanOrEqualTo(String value) {
            addCriterion("produceFactory <=", value, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryLike(String value) {
            addCriterion("produceFactory like", value, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryNotLike(String value) {
            addCriterion("produceFactory not like", value, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryIn(List<String> values) {
            addCriterion("produceFactory in", values, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryNotIn(List<String> values) {
            addCriterion("produceFactory not in", values, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryBetween(String value1, String value2) {
            addCriterion("produceFactory between", value1, value2, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andProduceFactoryNotBetween(String value1, String value2) {
            addCriterion("produceFactory not between", value1, value2, "produceFactory");
            return (Criteria) this;
        }

        public Criteria andDosageFormIsNull() {
            addCriterion("dosageForm is null");
            return (Criteria) this;
        }

        public Criteria andDosageFormIsNotNull() {
            addCriterion("dosageForm is not null");
            return (Criteria) this;
        }

        public Criteria andDosageFormEqualTo(String value) {
            addCriterion("dosageForm =", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotEqualTo(String value) {
            addCriterion("dosageForm <>", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormGreaterThan(String value) {
            addCriterion("dosageForm >", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormGreaterThanOrEqualTo(String value) {
            addCriterion("dosageForm >=", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormLessThan(String value) {
            addCriterion("dosageForm <", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormLessThanOrEqualTo(String value) {
            addCriterion("dosageForm <=", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormLike(String value) {
            addCriterion("dosageForm like", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotLike(String value) {
            addCriterion("dosageForm not like", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormIn(List<String> values) {
            addCriterion("dosageForm in", values, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotIn(List<String> values) {
            addCriterion("dosageForm not in", values, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormBetween(String value1, String value2) {
            addCriterion("dosageForm between", value1, value2, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotBetween(String value1, String value2) {
            addCriterion("dosageForm not between", value1, value2, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIsNull() {
            addCriterion("expiryDate is null");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIsNotNull() {
            addCriterion("expiryDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryDateEqualTo(String value) {
            addCriterion("expiryDate =", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotEqualTo(String value) {
            addCriterion("expiryDate <>", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThan(String value) {
            addCriterion("expiryDate >", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThanOrEqualTo(String value) {
            addCriterion("expiryDate >=", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThan(String value) {
            addCriterion("expiryDate <", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThanOrEqualTo(String value) {
            addCriterion("expiryDate <=", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLike(String value) {
            addCriterion("expiryDate like", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotLike(String value) {
            addCriterion("expiryDate not like", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIn(List<String> values) {
            addCriterion("expiryDate in", values, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotIn(List<String> values) {
            addCriterion("expiryDate not in", values, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateBetween(String value1, String value2) {
            addCriterion("expiryDate between", value1, value2, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotBetween(String value1, String value2) {
            addCriterion("expiryDate not between", value1, value2, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateIsNull() {
            addCriterion("produceDate is null");
            return (Criteria) this;
        }

        public Criteria andProduceDateIsNotNull() {
            addCriterion("produceDate is not null");
            return (Criteria) this;
        }

        public Criteria andProduceDateEqualTo(String value) {
            addCriterion("produceDate =", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotEqualTo(String value) {
            addCriterion("produceDate <>", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateGreaterThan(String value) {
            addCriterion("produceDate >", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateGreaterThanOrEqualTo(String value) {
            addCriterion("produceDate >=", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateLessThan(String value) {
            addCriterion("produceDate <", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateLessThanOrEqualTo(String value) {
            addCriterion("produceDate <=", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateLike(String value) {
            addCriterion("produceDate like", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotLike(String value) {
            addCriterion("produceDate not like", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateIn(List<String> values) {
            addCriterion("produceDate in", values, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotIn(List<String> values) {
            addCriterion("produceDate not in", values, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateBetween(String value1, String value2) {
            addCriterion("produceDate between", value1, value2, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotBetween(String value1, String value2) {
            addCriterion("produceDate not between", value1, value2, "produceDate");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("batchNo is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batchNo is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batchNo =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batchNo <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batchNo >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batchNo >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batchNo <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batchNo <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batchNo like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batchNo not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batchNo in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batchNo not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batchNo between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batchNo not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andLotNoIsNull() {
            addCriterion("lotNo is null");
            return (Criteria) this;
        }

        public Criteria andLotNoIsNotNull() {
            addCriterion("lotNo is not null");
            return (Criteria) this;
        }

        public Criteria andLotNoEqualTo(String value) {
            addCriterion("lotNo =", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotEqualTo(String value) {
            addCriterion("lotNo <>", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoGreaterThan(String value) {
            addCriterion("lotNo >", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoGreaterThanOrEqualTo(String value) {
            addCriterion("lotNo >=", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLessThan(String value) {
            addCriterion("lotNo <", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLessThanOrEqualTo(String value) {
            addCriterion("lotNo <=", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLike(String value) {
            addCriterion("lotNo like", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotLike(String value) {
            addCriterion("lotNo not like", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoIn(List<String> values) {
            addCriterion("lotNo in", values, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotIn(List<String> values) {
            addCriterion("lotNo not in", values, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoBetween(String value1, String value2) {
            addCriterion("lotNo between", value1, value2, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotBetween(String value1, String value2) {
            addCriterion("lotNo not between", value1, value2, "lotNo");
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

        public Criteria andIsGMPIsNull() {
            addCriterion("isGMP is null");
            return (Criteria) this;
        }

        public Criteria andIsGMPIsNotNull() {
            addCriterion("isGMP is not null");
            return (Criteria) this;
        }

        public Criteria andIsGMPEqualTo(Integer value) {
            addCriterion("isGMP =", value, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPNotEqualTo(Integer value) {
            addCriterion("isGMP <>", value, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPGreaterThan(Integer value) {
            addCriterion("isGMP >", value, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPGreaterThanOrEqualTo(Integer value) {
            addCriterion("isGMP >=", value, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPLessThan(Integer value) {
            addCriterion("isGMP <", value, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPLessThanOrEqualTo(Integer value) {
            addCriterion("isGMP <=", value, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPIn(List<Integer> values) {
            addCriterion("isGMP in", values, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPNotIn(List<Integer> values) {
            addCriterion("isGMP not in", values, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPBetween(Integer value1, Integer value2) {
            addCriterion("isGMP between", value1, value2, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsGMPNotBetween(Integer value1, Integer value2) {
            addCriterion("isGMP not between", value1, value2, "isGMP");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugIsNull() {
            addCriterion("isSplitDrug is null");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugIsNotNull() {
            addCriterion("isSplitDrug is not null");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugEqualTo(Integer value) {
            addCriterion("isSplitDrug =", value, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugNotEqualTo(Integer value) {
            addCriterion("isSplitDrug <>", value, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugGreaterThan(Integer value) {
            addCriterion("isSplitDrug >", value, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugGreaterThanOrEqualTo(Integer value) {
            addCriterion("isSplitDrug >=", value, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugLessThan(Integer value) {
            addCriterion("isSplitDrug <", value, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugLessThanOrEqualTo(Integer value) {
            addCriterion("isSplitDrug <=", value, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugIn(List<Integer> values) {
            addCriterion("isSplitDrug in", values, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugNotIn(List<Integer> values) {
            addCriterion("isSplitDrug not in", values, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugBetween(Integer value1, Integer value2) {
            addCriterion("isSplitDrug between", value1, value2, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsSplitDrugNotBetween(Integer value1, Integer value2) {
            addCriterion("isSplitDrug not between", value1, value2, "isSplitDrug");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoIsNull() {
            addCriterion("isYiBao is null");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoIsNotNull() {
            addCriterion("isYiBao is not null");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoEqualTo(Integer value) {
            addCriterion("isYiBao =", value, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoNotEqualTo(Integer value) {
            addCriterion("isYiBao <>", value, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoGreaterThan(Integer value) {
            addCriterion("isYiBao >", value, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoGreaterThanOrEqualTo(Integer value) {
            addCriterion("isYiBao >=", value, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoLessThan(Integer value) {
            addCriterion("isYiBao <", value, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoLessThanOrEqualTo(Integer value) {
            addCriterion("isYiBao <=", value, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoIn(List<Integer> values) {
            addCriterion("isYiBao in", values, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoNotIn(List<Integer> values) {
            addCriterion("isYiBao not in", values, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoBetween(Integer value1, Integer value2) {
            addCriterion("isYiBao between", value1, value2, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andIsYiBaoNotBetween(Integer value1, Integer value2) {
            addCriterion("isYiBao not between", value1, value2, "isYiBao");
            return (Criteria) this;
        }

        public Criteria andStockCountIsNull() {
            addCriterion("stockCount is null");
            return (Criteria) this;
        }

        public Criteria andStockCountIsNotNull() {
            addCriterion("stockCount is not null");
            return (Criteria) this;
        }

        public Criteria andStockCountEqualTo(BigDecimal value) {
            addCriterion("stockCount =", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotEqualTo(BigDecimal value) {
            addCriterion("stockCount <>", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountGreaterThan(BigDecimal value) {
            addCriterion("stockCount >", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stockCount >=", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountLessThan(BigDecimal value) {
            addCriterion("stockCount <", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stockCount <=", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountIn(List<BigDecimal> values) {
            addCriterion("stockCount in", values, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotIn(List<BigDecimal> values) {
            addCriterion("stockCount not in", values, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stockCount between", value1, value2, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stockCount not between", value1, value2, "stockCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountIsNull() {
            addCriterion("saleCount is null");
            return (Criteria) this;
        }

        public Criteria andSaleCountIsNotNull() {
            addCriterion("saleCount is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCountEqualTo(BigDecimal value) {
            addCriterion("saleCount =", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotEqualTo(BigDecimal value) {
            addCriterion("saleCount <>", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountGreaterThan(BigDecimal value) {
            addCriterion("saleCount >", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("saleCount >=", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountLessThan(BigDecimal value) {
            addCriterion("saleCount <", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("saleCount <=", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountIn(List<BigDecimal> values) {
            addCriterion("saleCount in", values, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotIn(List<BigDecimal> values) {
            addCriterion("saleCount not in", values, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("saleCount between", value1, value2, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("saleCount not between", value1, value2, "saleCount");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNull() {
            addCriterion("costPrice is null");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNotNull() {
            addCriterion("costPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCostPriceEqualTo(BigDecimal value) {
            addCriterion("costPrice =", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("costPrice <>", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThan(BigDecimal value) {
            addCriterion("costPrice >", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("costPrice >=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThan(BigDecimal value) {
            addCriterion("costPrice <", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("costPrice <=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceIn(List<BigDecimal> values) {
            addCriterion("costPrice in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotIn(List<BigDecimal> values) {
            addCriterion("costPrice not in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costPrice between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costPrice not between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostAmountIsNull() {
            addCriterion("costAmount is null");
            return (Criteria) this;
        }

        public Criteria andCostAmountIsNotNull() {
            addCriterion("costAmount is not null");
            return (Criteria) this;
        }

        public Criteria andCostAmountEqualTo(BigDecimal value) {
            addCriterion("costAmount =", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotEqualTo(BigDecimal value) {
            addCriterion("costAmount <>", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountGreaterThan(BigDecimal value) {
            addCriterion("costAmount >", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("costAmount >=", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountLessThan(BigDecimal value) {
            addCriterion("costAmount <", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("costAmount <=", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountIn(List<BigDecimal> values) {
            addCriterion("costAmount in", values, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotIn(List<BigDecimal> values) {
            addCriterion("costAmount not in", values, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costAmount between", value1, value2, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costAmount not between", value1, value2, "costAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("originalPrice is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("originalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("originalPrice =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("originalPrice <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("originalPrice >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("originalPrice >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("originalPrice <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("originalPrice <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("originalPrice in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("originalPrice not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("originalPrice between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("originalPrice not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIsNull() {
            addCriterion("originalAmount is null");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIsNotNull() {
            addCriterion("originalAmount is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountEqualTo(BigDecimal value) {
            addCriterion("originalAmount =", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotEqualTo(BigDecimal value) {
            addCriterion("originalAmount <>", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountGreaterThan(BigDecimal value) {
            addCriterion("originalAmount >", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("originalAmount >=", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountLessThan(BigDecimal value) {
            addCriterion("originalAmount <", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("originalAmount <=", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIn(List<BigDecimal> values) {
            addCriterion("originalAmount in", values, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotIn(List<BigDecimal> values) {
            addCriterion("originalAmount not in", values, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("originalAmount between", value1, value2, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("originalAmount not between", value1, value2, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNull() {
            addCriterion("sellPrice is null");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNotNull() {
            addCriterion("sellPrice is not null");
            return (Criteria) this;
        }

        public Criteria andSellPriceEqualTo(BigDecimal value) {
            addCriterion("sellPrice =", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotEqualTo(BigDecimal value) {
            addCriterion("sellPrice <>", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThan(BigDecimal value) {
            addCriterion("sellPrice >", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sellPrice >=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThan(BigDecimal value) {
            addCriterion("sellPrice <", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sellPrice <=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIn(List<BigDecimal> values) {
            addCriterion("sellPrice in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotIn(List<BigDecimal> values) {
            addCriterion("sellPrice not in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellPrice between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellPrice not between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellAmountIsNull() {
            addCriterion("sellAmount is null");
            return (Criteria) this;
        }

        public Criteria andSellAmountIsNotNull() {
            addCriterion("sellAmount is not null");
            return (Criteria) this;
        }

        public Criteria andSellAmountEqualTo(BigDecimal value) {
            addCriterion("sellAmount =", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountNotEqualTo(BigDecimal value) {
            addCriterion("sellAmount <>", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountGreaterThan(BigDecimal value) {
            addCriterion("sellAmount >", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sellAmount >=", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountLessThan(BigDecimal value) {
            addCriterion("sellAmount <", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sellAmount <=", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountIn(List<BigDecimal> values) {
            addCriterion("sellAmount in", values, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountNotIn(List<BigDecimal> values) {
            addCriterion("sellAmount not in", values, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellAmount between", value1, value2, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellAmount not between", value1, value2, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNull() {
            addCriterion("retailPrice is null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNotNull() {
            addCriterion("retailPrice is not null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceEqualTo(BigDecimal value) {
            addCriterion("retailPrice =", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotEqualTo(BigDecimal value) {
            addCriterion("retailPrice <>", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThan(BigDecimal value) {
            addCriterion("retailPrice >", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retailPrice >=", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThan(BigDecimal value) {
            addCriterion("retailPrice <", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retailPrice <=", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIn(List<BigDecimal> values) {
            addCriterion("retailPrice in", values, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotIn(List<BigDecimal> values) {
            addCriterion("retailPrice not in", values, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retailPrice between", value1, value2, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retailPrice not between", value1, value2, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailAmountIsNull() {
            addCriterion("retailAmount is null");
            return (Criteria) this;
        }

        public Criteria andRetailAmountIsNotNull() {
            addCriterion("retailAmount is not null");
            return (Criteria) this;
        }

        public Criteria andRetailAmountEqualTo(BigDecimal value) {
            addCriterion("retailAmount =", value, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountNotEqualTo(BigDecimal value) {
            addCriterion("retailAmount <>", value, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountGreaterThan(BigDecimal value) {
            addCriterion("retailAmount >", value, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retailAmount >=", value, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountLessThan(BigDecimal value) {
            addCriterion("retailAmount <", value, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retailAmount <=", value, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountIn(List<BigDecimal> values) {
            addCriterion("retailAmount in", values, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountNotIn(List<BigDecimal> values) {
            addCriterion("retailAmount not in", values, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retailAmount between", value1, value2, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andRetailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retailAmount not between", value1, value2, "retailAmount");
            return (Criteria) this;
        }

        public Criteria andTradePriceIsNull() {
            addCriterion("tradePrice is null");
            return (Criteria) this;
        }

        public Criteria andTradePriceIsNotNull() {
            addCriterion("tradePrice is not null");
            return (Criteria) this;
        }

        public Criteria andTradePriceEqualTo(BigDecimal value) {
            addCriterion("tradePrice =", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceNotEqualTo(BigDecimal value) {
            addCriterion("tradePrice <>", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceGreaterThan(BigDecimal value) {
            addCriterion("tradePrice >", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tradePrice >=", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceLessThan(BigDecimal value) {
            addCriterion("tradePrice <", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tradePrice <=", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceIn(List<BigDecimal> values) {
            addCriterion("tradePrice in", values, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceNotIn(List<BigDecimal> values) {
            addCriterion("tradePrice not in", values, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tradePrice between", value1, value2, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tradePrice not between", value1, value2, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("tradeAmount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("tradeAmount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(BigDecimal value) {
            addCriterion("tradeAmount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(BigDecimal value) {
            addCriterion("tradeAmount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(BigDecimal value) {
            addCriterion("tradeAmount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tradeAmount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(BigDecimal value) {
            addCriterion("tradeAmount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tradeAmount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<BigDecimal> values) {
            addCriterion("tradeAmount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<BigDecimal> values) {
            addCriterion("tradeAmount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tradeAmount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tradeAmount not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIsNull() {
            addCriterion("memberPrice is null");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIsNotNull() {
            addCriterion("memberPrice is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPriceEqualTo(BigDecimal value) {
            addCriterion("memberPrice =", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotEqualTo(BigDecimal value) {
            addCriterion("memberPrice <>", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceGreaterThan(BigDecimal value) {
            addCriterion("memberPrice >", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("memberPrice >=", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceLessThan(BigDecimal value) {
            addCriterion("memberPrice <", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("memberPrice <=", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIn(List<BigDecimal> values) {
            addCriterion("memberPrice in", values, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotIn(List<BigDecimal> values) {
            addCriterion("memberPrice not in", values, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("memberPrice between", value1, value2, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("memberPrice not between", value1, value2, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberAmountIsNull() {
            addCriterion("memberAmount is null");
            return (Criteria) this;
        }

        public Criteria andMemberAmountIsNotNull() {
            addCriterion("memberAmount is not null");
            return (Criteria) this;
        }

        public Criteria andMemberAmountEqualTo(BigDecimal value) {
            addCriterion("memberAmount =", value, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountNotEqualTo(BigDecimal value) {
            addCriterion("memberAmount <>", value, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountGreaterThan(BigDecimal value) {
            addCriterion("memberAmount >", value, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("memberAmount >=", value, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountLessThan(BigDecimal value) {
            addCriterion("memberAmount <", value, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("memberAmount <=", value, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountIn(List<BigDecimal> values) {
            addCriterion("memberAmount in", values, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountNotIn(List<BigDecimal> values) {
            addCriterion("memberAmount not in", values, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("memberAmount between", value1, value2, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andMemberAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("memberAmount not between", value1, value2, "memberAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(BigDecimal value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(BigDecimal value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(BigDecimal value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(BigDecimal value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<BigDecimal> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<BigDecimal> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNull() {
            addCriterion("discountFee is null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNotNull() {
            addCriterion("discountFee is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeEqualTo(BigDecimal value) {
            addCriterion("discountFee =", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotEqualTo(BigDecimal value) {
            addCriterion("discountFee <>", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThan(BigDecimal value) {
            addCriterion("discountFee >", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discountFee >=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThan(BigDecimal value) {
            addCriterion("discountFee <", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discountFee <=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIn(List<BigDecimal> values) {
            addCriterion("discountFee in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotIn(List<BigDecimal> values) {
            addCriterion("discountFee not in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discountFee between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discountFee not between", value1, value2, "discountFee");
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

        public Criteria andPayMethodIsNull() {
            addCriterion("payMethod is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("payMethod is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(Integer value) {
            addCriterion("payMethod =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(Integer value) {
            addCriterion("payMethod <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(Integer value) {
            addCriterion("payMethod >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("payMethod >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(Integer value) {
            addCriterion("payMethod <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(Integer value) {
            addCriterion("payMethod <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<Integer> values) {
            addCriterion("payMethod in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<Integer> values) {
            addCriterion("payMethod not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(Integer value1, Integer value2) {
            addCriterion("payMethod between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("payMethod not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andLineNumIsNull() {
            addCriterion("lineNum is null");
            return (Criteria) this;
        }

        public Criteria andLineNumIsNotNull() {
            addCriterion("lineNum is not null");
            return (Criteria) this;
        }

        public Criteria andLineNumEqualTo(Integer value) {
            addCriterion("lineNum =", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumNotEqualTo(Integer value) {
            addCriterion("lineNum <>", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumGreaterThan(Integer value) {
            addCriterion("lineNum >", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("lineNum >=", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumLessThan(Integer value) {
            addCriterion("lineNum <", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumLessThanOrEqualTo(Integer value) {
            addCriterion("lineNum <=", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumIn(List<Integer> values) {
            addCriterion("lineNum in", values, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumNotIn(List<Integer> values) {
            addCriterion("lineNum not in", values, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumBetween(Integer value1, Integer value2) {
            addCriterion("lineNum between", value1, value2, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumNotBetween(Integer value1, Integer value2) {
            addCriterion("lineNum not between", value1, value2, "lineNum");
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

        public Criteria andDetailTypeIsNull() {
            addCriterion("detailType is null");
            return (Criteria) this;
        }

        public Criteria andDetailTypeIsNotNull() {
            addCriterion("detailType is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTypeEqualTo(Integer value) {
            addCriterion("detailType =", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotEqualTo(Integer value) {
            addCriterion("detailType <>", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeGreaterThan(Integer value) {
            addCriterion("detailType >", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("detailType >=", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeLessThan(Integer value) {
            addCriterion("detailType <", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeLessThanOrEqualTo(Integer value) {
            addCriterion("detailType <=", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeIn(List<Integer> values) {
            addCriterion("detailType in", values, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotIn(List<Integer> values) {
            addCriterion("detailType not in", values, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeBetween(Integer value1, Integer value2) {
            addCriterion("detailType between", value1, value2, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("detailType not between", value1, value2, "detailType");
            return (Criteria) this;
        }

        public Criteria andHasPromotionIsNull() {
            addCriterion("hasPromotion is null");
            return (Criteria) this;
        }

        public Criteria andHasPromotionIsNotNull() {
            addCriterion("hasPromotion is not null");
            return (Criteria) this;
        }

        public Criteria andHasPromotionEqualTo(Integer value) {
            addCriterion("hasPromotion =", value, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionNotEqualTo(Integer value) {
            addCriterion("hasPromotion <>", value, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionGreaterThan(Integer value) {
            addCriterion("hasPromotion >", value, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionGreaterThanOrEqualTo(Integer value) {
            addCriterion("hasPromotion >=", value, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionLessThan(Integer value) {
            addCriterion("hasPromotion <", value, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionLessThanOrEqualTo(Integer value) {
            addCriterion("hasPromotion <=", value, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionIn(List<Integer> values) {
            addCriterion("hasPromotion in", values, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionNotIn(List<Integer> values) {
            addCriterion("hasPromotion not in", values, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionBetween(Integer value1, Integer value2) {
            addCriterion("hasPromotion between", value1, value2, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andHasPromotionNotBetween(Integer value1, Integer value2) {
            addCriterion("hasPromotion not between", value1, value2, "hasPromotion");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountIsNull() {
            addCriterion("promotionGiveCount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountIsNotNull() {
            addCriterion("promotionGiveCount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountEqualTo(BigDecimal value) {
            addCriterion("promotionGiveCount =", value, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountNotEqualTo(BigDecimal value) {
            addCriterion("promotionGiveCount <>", value, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountGreaterThan(BigDecimal value) {
            addCriterion("promotionGiveCount >", value, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotionGiveCount >=", value, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountLessThan(BigDecimal value) {
            addCriterion("promotionGiveCount <", value, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotionGiveCount <=", value, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountIn(List<BigDecimal> values) {
            addCriterion("promotionGiveCount in", values, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountNotIn(List<BigDecimal> values) {
            addCriterion("promotionGiveCount not in", values, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotionGiveCount between", value1, value2, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotionGiveCount not between", value1, value2, "promotionGiveCount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountIsNull() {
            addCriterion("promotionReduceAmount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountIsNotNull() {
            addCriterion("promotionReduceAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountEqualTo(BigDecimal value) {
            addCriterion("promotionReduceAmount =", value, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotionReduceAmount <>", value, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountGreaterThan(BigDecimal value) {
            addCriterion("promotionReduceAmount >", value, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotionReduceAmount >=", value, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountLessThan(BigDecimal value) {
            addCriterion("promotionReduceAmount <", value, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotionReduceAmount <=", value, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountIn(List<BigDecimal> values) {
            addCriterion("promotionReduceAmount in", values, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotionReduceAmount not in", values, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotionReduceAmount between", value1, value2, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionReduceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotionReduceAmount not between", value1, value2, "promotionReduceAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdIsNull() {
            addCriterion("promotionProductId is null");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdIsNotNull() {
            addCriterion("promotionProductId is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdEqualTo(String value) {
            addCriterion("promotionProductId =", value, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdNotEqualTo(String value) {
            addCriterion("promotionProductId <>", value, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdGreaterThan(String value) {
            addCriterion("promotionProductId >", value, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("promotionProductId >=", value, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdLessThan(String value) {
            addCriterion("promotionProductId <", value, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdLessThanOrEqualTo(String value) {
            addCriterion("promotionProductId <=", value, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdLike(String value) {
            addCriterion("promotionProductId like", value, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdNotLike(String value) {
            addCriterion("promotionProductId not like", value, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdIn(List<String> values) {
            addCriterion("promotionProductId in", values, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdNotIn(List<String> values) {
            addCriterion("promotionProductId not in", values, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdBetween(String value1, String value2) {
            addCriterion("promotionProductId between", value1, value2, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionProductIdNotBetween(String value1, String value2) {
            addCriterion("promotionProductId not between", value1, value2, "promotionProductId");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIsNull() {
            addCriterion("promotionName is null");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIsNotNull() {
            addCriterion("promotionName is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionNameEqualTo(String value) {
            addCriterion("promotionName =", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotEqualTo(String value) {
            addCriterion("promotionName <>", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameGreaterThan(String value) {
            addCriterion("promotionName >", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameGreaterThanOrEqualTo(String value) {
            addCriterion("promotionName >=", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLessThan(String value) {
            addCriterion("promotionName <", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLessThanOrEqualTo(String value) {
            addCriterion("promotionName <=", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLike(String value) {
            addCriterion("promotionName like", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotLike(String value) {
            addCriterion("promotionName not like", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIn(List<String> values) {
            addCriterion("promotionName in", values, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotIn(List<String> values) {
            addCriterion("promotionName not in", values, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameBetween(String value1, String value2) {
            addCriterion("promotionName between", value1, value2, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotBetween(String value1, String value2) {
            addCriterion("promotionName not between", value1, value2, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesIsNull() {
            addCriterion("promotionGiveProductNames is null");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesIsNotNull() {
            addCriterion("promotionGiveProductNames is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesEqualTo(String value) {
            addCriterion("promotionGiveProductNames =", value, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesNotEqualTo(String value) {
            addCriterion("promotionGiveProductNames <>", value, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesGreaterThan(String value) {
            addCriterion("promotionGiveProductNames >", value, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesGreaterThanOrEqualTo(String value) {
            addCriterion("promotionGiveProductNames >=", value, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesLessThan(String value) {
            addCriterion("promotionGiveProductNames <", value, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesLessThanOrEqualTo(String value) {
            addCriterion("promotionGiveProductNames <=", value, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesLike(String value) {
            addCriterion("promotionGiveProductNames like", value, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesNotLike(String value) {
            addCriterion("promotionGiveProductNames not like", value, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesIn(List<String> values) {
            addCriterion("promotionGiveProductNames in", values, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesNotIn(List<String> values) {
            addCriterion("promotionGiveProductNames not in", values, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesBetween(String value1, String value2) {
            addCriterion("promotionGiveProductNames between", value1, value2, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductNamesNotBetween(String value1, String value2) {
            addCriterion("promotionGiveProductNames not between", value1, value2, "promotionGiveProductNames");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsIsNull() {
            addCriterion("promotionGiveProductIds is null");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsIsNotNull() {
            addCriterion("promotionGiveProductIds is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsEqualTo(String value) {
            addCriterion("promotionGiveProductIds =", value, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsNotEqualTo(String value) {
            addCriterion("promotionGiveProductIds <>", value, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsGreaterThan(String value) {
            addCriterion("promotionGiveProductIds >", value, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsGreaterThanOrEqualTo(String value) {
            addCriterion("promotionGiveProductIds >=", value, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsLessThan(String value) {
            addCriterion("promotionGiveProductIds <", value, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsLessThanOrEqualTo(String value) {
            addCriterion("promotionGiveProductIds <=", value, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsLike(String value) {
            addCriterion("promotionGiveProductIds like", value, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsNotLike(String value) {
            addCriterion("promotionGiveProductIds not like", value, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsIn(List<String> values) {
            addCriterion("promotionGiveProductIds in", values, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsNotIn(List<String> values) {
            addCriterion("promotionGiveProductIds not in", values, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsBetween(String value1, String value2) {
            addCriterion("promotionGiveProductIds between", value1, value2, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveProductIdsNotBetween(String value1, String value2) {
            addCriterion("promotionGiveProductIds not between", value1, value2, "promotionGiveProductIds");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountIsNull() {
            addCriterion("promotionGiveAmount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountIsNotNull() {
            addCriterion("promotionGiveAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountEqualTo(BigDecimal value) {
            addCriterion("promotionGiveAmount =", value, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotionGiveAmount <>", value, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountGreaterThan(BigDecimal value) {
            addCriterion("promotionGiveAmount >", value, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotionGiveAmount >=", value, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountLessThan(BigDecimal value) {
            addCriterion("promotionGiveAmount <", value, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotionGiveAmount <=", value, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountIn(List<BigDecimal> values) {
            addCriterion("promotionGiveAmount in", values, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotionGiveAmount not in", values, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotionGiveAmount between", value1, value2, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionGiveAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotionGiveAmount not between", value1, value2, "promotionGiveAmount");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("categoryId is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("categoryId is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("categoryId =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("categoryId <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("categoryId >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("categoryId >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("categoryId <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("categoryId <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("categoryId like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("categoryId not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("categoryId in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("categoryId not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("categoryId between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("categoryId not between", value1, value2, "categoryId");
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

        public Criteria andLocalRetailPriceIsNull() {
            addCriterion("localRetailPrice is null");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceIsNotNull() {
            addCriterion("localRetailPrice is not null");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceEqualTo(BigDecimal value) {
            addCriterion("localRetailPrice =", value, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceNotEqualTo(BigDecimal value) {
            addCriterion("localRetailPrice <>", value, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceGreaterThan(BigDecimal value) {
            addCriterion("localRetailPrice >", value, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("localRetailPrice >=", value, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceLessThan(BigDecimal value) {
            addCriterion("localRetailPrice <", value, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("localRetailPrice <=", value, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceIn(List<BigDecimal> values) {
            addCriterion("localRetailPrice in", values, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceNotIn(List<BigDecimal> values) {
            addCriterion("localRetailPrice not in", values, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("localRetailPrice between", value1, value2, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andLocalRetailPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("localRetailPrice not between", value1, value2, "localRetailPrice");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductIsNull() {
            addCriterion("isGiveProduct is null");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductIsNotNull() {
            addCriterion("isGiveProduct is not null");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductEqualTo(Integer value) {
            addCriterion("isGiveProduct =", value, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductNotEqualTo(Integer value) {
            addCriterion("isGiveProduct <>", value, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductGreaterThan(Integer value) {
            addCriterion("isGiveProduct >", value, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductGreaterThanOrEqualTo(Integer value) {
            addCriterion("isGiveProduct >=", value, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductLessThan(Integer value) {
            addCriterion("isGiveProduct <", value, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductLessThanOrEqualTo(Integer value) {
            addCriterion("isGiveProduct <=", value, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductIn(List<Integer> values) {
            addCriterion("isGiveProduct in", values, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductNotIn(List<Integer> values) {
            addCriterion("isGiveProduct not in", values, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductBetween(Integer value1, Integer value2) {
            addCriterion("isGiveProduct between", value1, value2, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andIsGiveProductNotBetween(Integer value1, Integer value2) {
            addCriterion("isGiveProduct not between", value1, value2, "isGiveProduct");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeIsNull() {
            addCriterion("giveProdcutParentCode is null");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeIsNotNull() {
            addCriterion("giveProdcutParentCode is not null");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeEqualTo(String value) {
            addCriterion("giveProdcutParentCode =", value, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeNotEqualTo(String value) {
            addCriterion("giveProdcutParentCode <>", value, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeGreaterThan(String value) {
            addCriterion("giveProdcutParentCode >", value, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("giveProdcutParentCode >=", value, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeLessThan(String value) {
            addCriterion("giveProdcutParentCode <", value, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeLessThanOrEqualTo(String value) {
            addCriterion("giveProdcutParentCode <=", value, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeLike(String value) {
            addCriterion("giveProdcutParentCode like", value, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeNotLike(String value) {
            addCriterion("giveProdcutParentCode not like", value, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeIn(List<String> values) {
            addCriterion("giveProdcutParentCode in", values, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeNotIn(List<String> values) {
            addCriterion("giveProdcutParentCode not in", values, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeBetween(String value1, String value2) {
            addCriterion("giveProdcutParentCode between", value1, value2, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andGiveProdcutParentCodeNotBetween(String value1, String value2) {
            addCriterion("giveProdcutParentCode not between", value1, value2, "giveProdcutParentCode");
            return (Criteria) this;
        }

        public Criteria andIsCommissionIsNull() {
            addCriterion("isCommission is null");
            return (Criteria) this;
        }

        public Criteria andIsCommissionIsNotNull() {
            addCriterion("isCommission is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommissionEqualTo(Integer value) {
            addCriterion("isCommission =", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionNotEqualTo(Integer value) {
            addCriterion("isCommission <>", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionGreaterThan(Integer value) {
            addCriterion("isCommission >", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("isCommission >=", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionLessThan(Integer value) {
            addCriterion("isCommission <", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("isCommission <=", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionIn(List<Integer> values) {
            addCriterion("isCommission in", values, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionNotIn(List<Integer> values) {
            addCriterion("isCommission not in", values, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionBetween(Integer value1, Integer value2) {
            addCriterion("isCommission between", value1, value2, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("isCommission not between", value1, value2, "isCommission");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioIsNull() {
            addCriterion("commissionRadio is null");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioIsNotNull() {
            addCriterion("commissionRadio is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioEqualTo(BigDecimal value) {
            addCriterion("commissionRadio =", value, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioNotEqualTo(BigDecimal value) {
            addCriterion("commissionRadio <>", value, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioGreaterThan(BigDecimal value) {
            addCriterion("commissionRadio >", value, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commissionRadio >=", value, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioLessThan(BigDecimal value) {
            addCriterion("commissionRadio <", value, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commissionRadio <=", value, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioIn(List<BigDecimal> values) {
            addCriterion("commissionRadio in", values, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioNotIn(List<BigDecimal> values) {
            addCriterion("commissionRadio not in", values, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commissionRadio between", value1, value2, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionRadioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commissionRadio not between", value1, value2, "commissionRadio");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountIsNull() {
            addCriterion("commissionAmount is null");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountIsNotNull() {
            addCriterion("commissionAmount is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountEqualTo(BigDecimal value) {
            addCriterion("commissionAmount =", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountNotEqualTo(BigDecimal value) {
            addCriterion("commissionAmount <>", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountGreaterThan(BigDecimal value) {
            addCriterion("commissionAmount >", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commissionAmount >=", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountLessThan(BigDecimal value) {
            addCriterion("commissionAmount <", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commissionAmount <=", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountIn(List<BigDecimal> values) {
            addCriterion("commissionAmount in", values, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountNotIn(List<BigDecimal> values) {
            addCriterion("commissionAmount not in", values, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commissionAmount between", value1, value2, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commissionAmount not between", value1, value2, "commissionAmount");
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