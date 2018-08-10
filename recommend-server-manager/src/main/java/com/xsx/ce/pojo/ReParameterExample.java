package com.xsx.ce.pojo;

import java.util.ArrayList;
import java.util.List;

public class ReParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReParameterExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIntValueIsNull() {
            addCriterion("int_value is null");
            return (Criteria) this;
        }

        public Criteria andIntValueIsNotNull() {
            addCriterion("int_value is not null");
            return (Criteria) this;
        }

        public Criteria andIntValueEqualTo(Integer value) {
            addCriterion("int_value =", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueNotEqualTo(Integer value) {
            addCriterion("int_value <>", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueGreaterThan(Integer value) {
            addCriterion("int_value >", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_value >=", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueLessThan(Integer value) {
            addCriterion("int_value <", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueLessThanOrEqualTo(Integer value) {
            addCriterion("int_value <=", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueIn(List<Integer> values) {
            addCriterion("int_value in", values, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueNotIn(List<Integer> values) {
            addCriterion("int_value not in", values, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueBetween(Integer value1, Integer value2) {
            addCriterion("int_value between", value1, value2, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueNotBetween(Integer value1, Integer value2) {
            addCriterion("int_value not between", value1, value2, "intValue");
            return (Criteria) this;
        }

        public Criteria andLongValueIsNull() {
            addCriterion("long_value is null");
            return (Criteria) this;
        }

        public Criteria andLongValueIsNotNull() {
            addCriterion("long_value is not null");
            return (Criteria) this;
        }

        public Criteria andLongValueEqualTo(Integer value) {
            addCriterion("long_value =", value, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueNotEqualTo(Integer value) {
            addCriterion("long_value <>", value, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueGreaterThan(Integer value) {
            addCriterion("long_value >", value, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("long_value >=", value, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueLessThan(Integer value) {
            addCriterion("long_value <", value, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueLessThanOrEqualTo(Integer value) {
            addCriterion("long_value <=", value, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueIn(List<Integer> values) {
            addCriterion("long_value in", values, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueNotIn(List<Integer> values) {
            addCriterion("long_value not in", values, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueBetween(Integer value1, Integer value2) {
            addCriterion("long_value between", value1, value2, "longValue");
            return (Criteria) this;
        }

        public Criteria andLongValueNotBetween(Integer value1, Integer value2) {
            addCriterion("long_value not between", value1, value2, "longValue");
            return (Criteria) this;
        }

        public Criteria andWordIsNull() {
            addCriterion("word is null");
            return (Criteria) this;
        }

        public Criteria andWordIsNotNull() {
            addCriterion("word is not null");
            return (Criteria) this;
        }

        public Criteria andWordEqualTo(String value) {
            addCriterion("word =", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotEqualTo(String value) {
            addCriterion("word <>", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThan(String value) {
            addCriterion("word >", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThanOrEqualTo(String value) {
            addCriterion("word >=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThan(String value) {
            addCriterion("word <", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThanOrEqualTo(String value) {
            addCriterion("word <=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLike(String value) {
            addCriterion("word like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotLike(String value) {
            addCriterion("word not like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordIn(List<String> values) {
            addCriterion("word in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotIn(List<String> values) {
            addCriterion("word not in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordBetween(String value1, String value2) {
            addCriterion("word between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotBetween(String value1, String value2) {
            addCriterion("word not between", value1, value2, "word");
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