package com.dayima.datacut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dayima.datacut.model.MallCouponRule;

public interface MallCouponRuleMapper {
    int deleteByPrimaryKey(Integer couponRuleId);

    int insert(MallCouponRule record);

    int insertBatch(@Param("ruleList")List<MallCouponRule> ruleList);
    
    int insertSelective(MallCouponRule record);

    MallCouponRule selectByPrimaryKey(Integer couponRuleId);

    int updateByPrimaryKeySelective(MallCouponRule record);

    int updateByPrimaryKey(MallCouponRule record);
    
    int updateAll();
}