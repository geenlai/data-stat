package com.dayima.stat.run;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dayima.datacut.service.CouponDataCutService;

public class Main {
	
	static String[] params = new String[] {"classpath:/context.xml"};
	static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(params);

	public static void main(String[] args) {
		try {
			context.start();
			CouponDataCutService couponDataCutService = (CouponDataCutService) context.getBean("couponDataCutService");
			couponDataCutService.doCut();
			System.out.println("修改1");
			System.out.println("修改33");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
