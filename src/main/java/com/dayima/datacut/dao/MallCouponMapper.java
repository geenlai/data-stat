package com.dayima.datacut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dayima.datacut.model.MallCoupon;

public interface MallCouponMapper {
    int deleteByPrimaryKey(Integer couponId);
    int deleteAll();

    int insert(MallCoupon record);
    int insertBatch(@Param("mallCouponList")List<MallCoupon> mallCouponList);

    int insertSelective(MallCoupon record);

    MallCoupon selectByPrimaryKey(Integer couponId);

    int updateByPrimaryKeySelective(MallCoupon record);

    int updateByPrimaryKey(MallCoupon record);
}