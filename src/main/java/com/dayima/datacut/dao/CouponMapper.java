package com.dayima.datacut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dayima.datacut.model.Coupon;
import com.dayima.datacut.util.Pagger;

public interface CouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Integer couponId);
    
    List<Coupon> selectWithPage(@Param("pagger") Pagger pagger);
    
    int countAll();

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}