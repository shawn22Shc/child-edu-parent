package com.xsx.ce.pojo;

import java.util.ArrayList;
import java.util.List;

public class ReRoundProportionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReRoundProportionExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(Integer value) {
            addCriterion("start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(Integer value) {
            addCriterion("start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(Integer value) {
            addCriterion("start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(Integer value) {
            addCriterion("start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(Integer value) {
            addCriterion("start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<Integer> values) {
            addCriterion("start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<Integer> values) {
            addCriterion("start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(Integer value1, Integer value2) {
            addCriterion("start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(Integer value1, Integer value2) {
            addCriterion("start not between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andEndIsNull() {
            addCriterion("end is null");
            return (Criteria) this;
        }

        public Criteria andEndIsNotNull() {
            addCriterion("end is not null");
            return (Criteria) this;
        }

        public Criteria andEndEqualTo(Integer value) {
            addCriterion("end =", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotEqualTo(Integer value) {
            addCriterion("end <>", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThan(Integer value) {
            addCriterion("end >", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("end >=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThan(Integer value) {
            addCriterion("end <", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThanOrEqualTo(Integer value) {
            addCriterion("end <=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndIn(List<Integer> values) {
            addCriterion("end in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotIn(List<Integer> values) {
            addCriterion("end not in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndBetween(Integer value1, Integer value2) {
            addCriterion("end between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotBetween(Integer value1, Integer value2) {
            addCriterion("end not between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionIsNull() {
            addCriterion("artificial_proportion is null");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionIsNotNull() {
            addCriterion("artificial_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionEqualTo(Integer value) {
            addCriterion("artificial_proportion =", value, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionNotEqualTo(Integer value) {
            addCriterion("artificial_proportion <>", value, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionGreaterThan(Integer value) {
            addCriterion("artificial_proportion >", value, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionGreaterThanOrEqualTo(Integer value) {
            addCriterion("artificial_proportion >=", value, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionLessThan(Integer value) {
            addCriterion("artificial_proportion <", value, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionLessThanOrEqualTo(Integer value) {
            addCriterion("artificial_proportion <=", value, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionIn(List<Integer> values) {
            addCriterion("artificial_proportion in", values, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionNotIn(List<Integer> values) {
            addCriterion("artificial_proportion not in", values, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionBetween(Integer value1, Integer value2) {
            addCriterion("artificial_proportion between", value1, value2, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andArtificialProportionNotBetween(Integer value1, Integer value2) {
            addCriterion("artificial_proportion not between", value1, value2, "artificialProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionIsNull() {
            addCriterion("system_proportion is null");
            return (Criteria) this;
        }

        public Criteria andSystemProportionIsNotNull() {
            addCriterion("system_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andSystemProportionEqualTo(Integer value) {
            addCriterion("system_proportion =", value, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionNotEqualTo(Integer value) {
            addCriterion("system_proportion <>", value, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionGreaterThan(Integer value) {
            addCriterion("system_proportion >", value, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionGreaterThanOrEqualTo(Integer value) {
            addCriterion("system_proportion >=", value, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionLessThan(Integer value) {
            addCriterion("system_proportion <", value, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionLessThanOrEqualTo(Integer value) {
            addCriterion("system_proportion <=", value, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionIn(List<Integer> values) {
            addCriterion("system_proportion in", values, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionNotIn(List<Integer> values) {
            addCriterion("system_proportion not in", values, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionBetween(Integer value1, Integer value2) {
            addCriterion("system_proportion between", value1, value2, "systemProportion");
            return (Criteria) this;
        }

        public Criteria andSystemProportionNotBetween(Integer value1, Integer value2) {
            addCriterion("system_proportion not between", value1, value2, "systemProportion");
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