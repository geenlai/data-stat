package com.dayima.datacut.model;

import java.math.BigDecimal;

public class MallCouponRule {
    private Integer couponRuleId;

    private Integer couponId;

    private Byte couponType;

    private String couponTitle;

    private BigDecimal feeLimit;

    private BigDecimal couponPrice;

    private Byte status;

    private Byte couponScope;

    private Integer categoryId;

    private Integer brandId;

    private Integer topicId;

    private Long exchStartTime;

    private Long exchEndTime;

    private Byte timeType;

    private Integer validTime;

    private Long startTime;

    private Long endTime;

    private Long createTime;

    private Long modifyTime;

    public Integer getCouponRuleId() {
        return couponRuleId;
    }

    public void setCouponRuleId(Integer couponRuleId) {
        this.couponRuleId = couponRuleId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle;
    }

    public BigDecimal getFeeLimit() {
        return feeLimit;
    }

    public void setFeeLimit(BigDecimal feeLimit) {
        this.feeLimit = feeLimit;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getCouponScope() {
        return couponScope;
    }

    public void setCouponScope(Byte couponScope) {
        this.couponScope = couponScope;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Long getExchStartTime() {
        return exchStartTime;
    }

    public void setExchStartTime(Long exchStartTime) {
        this.exchStartTime = exchStartTime;
    }

    public Long getExchEndTime() {
        return exchEndTime;
    }

    public void setExchEndTime(Long exchEndTime) {
        this.exchEndTime = exchEndTime;
    }

    public Byte getTimeType() {
        return timeType;
    }

    public void setTimeType(Byte timeType) {
        this.timeType = timeType;
    }

    public Integer getValidTime() {
        return validTime;
    }

    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }
}