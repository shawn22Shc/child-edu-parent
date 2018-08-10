package com.xsx.ce.pojo;

import java.util.ArrayList;
import java.util.List;

public class ReUserStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReUserStatusExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andRoundCountIsNull() {
            addCriterion("round_count is null");
            return (Criteria) this;
        }

        public Criteria andRoundCountIsNotNull() {
            addCriterion("round_count is not null");
            return (Criteria) this;
        }

        public Criteria andRoundCountEqualTo(Integer value) {
            addCriterion("round_count =", value, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountNotEqualTo(Integer value) {
            addCriterion("round_count <>", value, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountGreaterThan(Integer value) {
            addCriterion("round_count >", value, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("round_count >=", value, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountLessThan(Integer value) {
            addCriterion("round_count <", value, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountLessThanOrEqualTo(Integer value) {
            addCriterion("round_count <=", value, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountIn(List<Integer> values) {
            addCriterion("round_count in", values, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountNotIn(List<Integer> values) {
            addCriterion("round_count not in", values, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountBetween(Integer value1, Integer value2) {
            addCriterion("round_count between", value1, value2, "roundCount");
            return (Criteria) this;
        }

        public Criteria andRoundCountNotBetween(Integer value1, Integer value2) {
            addCriterion("round_count not between", value1, value2, "roundCount");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusIsNull() {
            addCriterion("now_round_status is null");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusIsNotNull() {
            addCriterion("now_round_status is not null");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusEqualTo(Integer value) {
            addCriterion("now_round_status =", value, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusNotEqualTo(Integer value) {
            addCriterion("now_round_status <>", value, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusGreaterThan(Integer value) {
            addCriterion("now_round_status >", value, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("now_round_status >=", value, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusLessThan(Integer value) {
            addCriterion("now_round_status <", value, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("now_round_status <=", value, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusIn(List<Integer> values) {
            addCriterion("now_round_status in", values, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusNotIn(List<Integer> values) {
            addCriterion("now_round_status not in", values, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusBetween(Integer value1, Integer value2) {
            addCriterion("now_round_status between", value1, value2, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andNowRoundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("now_round_status not between", value1, value2, "nowRoundStatus");
            return (Criteria) this;
        }

        public Criteria andReIdIsNull() {
            addCriterion("re_id is null");
            return (Criteria) this;
        }

        public Criteria andReIdIsNotNull() {
            addCriterion("re_id is not null");
            return (Criteria) this;
        }

        public Criteria andReIdEqualTo(Integer value) {
            addCriterion("re_id =", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotEqualTo(Integer value) {
            addCriterion("re_id <>", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdGreaterThan(Integer value) {
            addCriterion("re_id >", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_id >=", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdLessThan(Integer value) {
            addCriterion("re_id <", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdLessThanOrEqualTo(Integer value) {
            addCriterion("re_id <=", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdIn(List<Integer> values) {
            addCriterion("re_id in", values, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotIn(List<Integer> values) {
            addCriterion("re_id not in", values, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdBetween(Integer value1, Integer value2) {
            addCriterion("re_id between", value1, value2, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotBetween(Integer value1, Integer value2) {
            addCriterion("re_id not between", value1, value2, "reId");
            return (Criteria) this;
        }

        public Criteria andReTimeIsNull() {
            addCriterion("re_time is null");
            return (Criteria) this;
        }

        public Criteria andReTimeIsNotNull() {
            addCriterion("re_time is not null");
            return (Criteria) this;
        }

        public Criteria andReTimeEqualTo(Long value) {
            addCriterion("re_time =", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeNotEqualTo(Long value) {
            addCriterion("re_time <>", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeGreaterThan(Long value) {
            addCriterion("re_time >", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("re_time >=", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeLessThan(Long value) {
            addCriterion("re_time <", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeLessThanOrEqualTo(Long value) {
            addCriterion("re_time <=", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeIn(List<Long> values) {
            addCriterion("re_time in", values, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeNotIn(List<Long> values) {
            addCriterion("re_time not in", values, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeBetween(Long value1, Long value2) {
            addCriterion("re_time between", value1, value2, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeNotBetween(Long value1, Long value2) {
            addCriterion("re_time not between", value1, value2, "reTime");
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