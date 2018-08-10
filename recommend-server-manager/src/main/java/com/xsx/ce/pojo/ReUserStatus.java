package com.xsx.ce.pojo;

public class ReUserStatus {
    private Long userId;

    //当前轮 是否完成 1完成  0 未完成  -1 为 还没申请过  第一次申请表0 第二次申请变1
    private Integer status;

    private Integer age;

    private Integer gender;

    private Integer roundCount;

    private Integer nowRoundStatus;

    private Integer reId;

    private Long reTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(Integer roundCount) {
        this.roundCount = roundCount;
    }

    public Integer getNowRoundStatus() {
        return nowRoundStatus;
    }

    public void setNowRoundStatus(Integer nowRoundStatus) {
        this.nowRoundStatus = nowRoundStatus;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Long getReTime() {
        return reTime;
    }

    public void setReTime(Long reTime) {
        this.reTime = reTime;
    }
}