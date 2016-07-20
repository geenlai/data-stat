package com.dayima.datacut.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import com.dayima.datacut.dao.CouponMapper;
import com.dayima.datacut.dao.MallCouponMapper;
import com.dayima.datacut.dao.MallCouponRuleMapper;
import com.dayima.datacut.model.Coupon;
import com.dayima.datacut.model.MallCoupon;
import com.dayima.datacut.model.MallCouponRule;
import com.dayima.datacut.util.DateUtil;
import com.dayima.datacut.util.Pagger;

@Service("couponDataCutService")
public class CouponDataCutService {

	@Resource
	private CouponMapper couponMapper;
	@Resource
	private MallCouponMapper mallCouponMapper;
	@Resource
	private MallCouponRuleMapper mallCouponRuleMapper;
	
	private final static int pageSize = 500;
	
	public void doCut() {
//		mallCouponRuleMapper.updateAll();
		/*
		mallCouponMapper.deleteAll();
		// 优惠券兑换码历史数据切割
		// 分页处理,每页处理1000条记录
		// 总记录数
		int total = couponMapper.countAll();
		System.out.println("总记录：" + total);
		// 总页数
		int page = (total - 1) / pageSize + 1;
		Pagger pagger = new Pagger(1, pageSize);
		
		List<MallCoupon> mallCouponList = new ArrayList<>();
		List<MallCouponRule> mallCouponRuleList = new ArrayList<>();
		for (int i=0; i<page; i++) {
			pagger.setStartPage(i + 1);
			List<Coupon> sourceList = couponMapper.selectWithPage(pagger);
			
			for (Coupon coupon : sourceList) {
				mallCouponList.add(getMallCoupon(coupon));
				mallCouponRuleList.add(getMallCouponRule(coupon));
			}
			// insert mall_coupon
			mallCouponMapper.insertBatch(mallCouponList);
			mallCouponList.clear();
			// insert mall_coupon_rule
			mallCouponRuleMapper.insertBatch(mallCouponRuleList);
			mallCouponRuleList.clear();
			System.out.println("写入：" + sourceList.size() + "条记录！");
		}
	*/}
	
	private MallCoupon getMallCoupon(Coupon coupon) {
		MallCoupon mallCoupon = new MallCoupon();
		
		byte couponType = -1;
		if (coupon.getCouponType() != null) {
			couponType = Byte.valueOf("" + coupon.getCouponType());
		}
		
		Long createTime = dealDate(coupon.getCreateTime());
		Long modifyTime = dealDate(coupon.getModifyTime());
		
		mallCoupon.setCouponId(coupon.getCouponId());
		mallCoupon.setBatchId(-1);
		mallCoupon.setCouponCode(coupon.getCouponCode());
		mallCoupon.setCouponType(couponType);
		mallCoupon.setCreateTime(createTime);
		mallCoupon.setExchTotalCount(coupon.getExchangeCount());
		mallCoupon.setLeftNum(coupon.getLeftNum());
		mallCoupon.setModifyTime(modifyTime);
		mallCoupon.setStatus(coupon.getStatus());
		
		return mallCoupon;
	}
	
	private MallCouponRule getMallCouponRule(Coupon coupon) {
		MallCouponRule mallCouponRule = new MallCouponRule();
		
		Byte couponType = null;
		if (coupon.getCouponType() != null) {
			couponType = Byte.valueOf("" + coupon.getCouponType());
		}
		
		Long createTime = dealDate(coupon.getCreateTime());
		Long modifyTime = dealDate(coupon.getModifyTime());
		Long startTime = dealDate(coupon.getStartTime());
		Long endTime = dealDate(coupon.getEndTime());
		Long exchEndTime = dealDate(coupon.getExchangeEndTime());
		Long exchStartTime = dealDate(coupon.getExchangeStartTime());
		byte timeType = Byte.valueOf("" + coupon.getTimeType());
		byte scope = Byte.valueOf("" + coupon.getScope());
		
		mallCouponRule.setCouponRuleId(null);
		mallCouponRule.setCategoryId(coupon.getCategoryId());
		mallCouponRule.setBrandId(coupon.getBrandId());
		mallCouponRule.setCouponId(coupon.getCouponId());
		mallCouponRule.setCouponPrice(coupon.getCouponPrice());
		mallCouponRule.setCouponScope(scope);
		mallCouponRule.setCouponTitle(coupon.getCouponTitle());
		mallCouponRule.setCouponType(couponType);
		if (createTime != null) {
			mallCouponRule.setCreateTime(createTime);
		}
		if (endTime != null) {
			mallCouponRule.setEndTime(endTime);
		}
		if (exchEndTime != null) {
			mallCouponRule.setExchEndTime(exchEndTime);
		}
		if (exchStartTime != null) {
			mallCouponRule.setExchStartTime(exchStartTime);
		}
		
		mallCouponRule.setFeeLimit(coupon.getFeeLimit());
		if (modifyTime != null) {
			mallCouponRule.setModifyTime(modifyTime);
		}
		if (startTime != null) {
			mallCouponRule.setStartTime(startTime);
		}
		mallCouponRule.setStatus(coupon.getStatus());
		mallCouponRule.setTimeType(timeType);
		mallCouponRule.setTopicId(0);// 默认0
		mallCouponRule.setValidTime(coupon.getDays());
		
		return mallCouponRule;
	}
	
	private static Long dealDate(Date date) {
		if (date == null) {
			return 0L;
		}
		
		String format = DateFormatUtils.format(date.getTime(), DateUtil.DEFAULT_DATE_FORMAT);
		return Long.valueOf(format);
	}
	
	public static void main(String[] args) {
		System.out.println(dealDate(new Date()));
	}
}
