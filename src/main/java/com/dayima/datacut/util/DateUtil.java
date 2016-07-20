package com.dayima.datacut.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	/** yyyy-MM-dd HH:mm:ss */
	public static final String DEF_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEF_MIN_FORMAT = "yyyy-MM-dd HH:mm";
	public final static String DEFAULT_DATE_FORMAT = "yyyyMMddHHmmss";

	/** yyyy-MM-dd */
	public static final String DAY_FORMAT = "yyyy-MM-dd";

	public static final String SM_FORMAT = "HHmmssMMdd";

	public static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public static String orderNo() {
		DateFormat df = new SimpleDateFormat(SM_FORMAT);
		return df.format(new Date());
	}

	public static String format(String src, String format) {
		long time = strLong(src);
		DateFormat df = new SimpleDateFormat(format);
		return df.format(time);
	}
	
	public static String parseLong(String src) {
		return src.substring(0,4) + "-" + src.substring(4,6) + "-" + src.substring(6,8) + " " + src.substring(8,10) + ":" + src.substring(10,12);
	}
	
	public static String parseLong2(String src) {
		return src.substring(0,4) + "-" + src.substring(4,6) + "-" + src.substring(6,8) + " " + src.substring(8,10) + ":" + src.substring(10,12) + ":" + src.substring(12,14);
	}

	public static String format(long time, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(time);
	}

	public static Date parse(String dateStr, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 时间转字符
	 */
	public static String currTimeStr() {
		DateFormat df = new SimpleDateFormat(DEF_FORMAT);
		return df.format(new Date());
	}

	public static String todayStr() {
		DateFormat df = new SimpleDateFormat(DAY_FORMAT);
		return df.format(new Date());
	}

	public static String currTimeStr(String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(new Date());
	}

	/**
	 * 长整型转字符
	 */
	public static String longStr(Long num) {
		DateFormat df = new SimpleDateFormat(DEF_FORMAT);
		return df.format(num);
	}

	/**
	 * 字符转长整型
	 */
	public static long strLong(String str) {
		DateFormat df = new SimpleDateFormat(DEF_FORMAT);
		try {
			return df.parse(str).getTime();
		} catch (ParseException e) {
			logger.error("", e);
		}
		return 0;
	}
	
	public static long strLong(String str, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(str).getTime();
		} catch (ParseException e) {
			logger.error("", e);
		}
		return 0;
	}

	public static Date addMinute(Date date, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, minute);
		return c.getTime();
	}

	/**
	 * 前后几天的零点,昨天-1
	 */
	public static Date getYesterday(int num) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static String addMonth(int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, month);
		
		if(day >= 29) {
			int maxDayNum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			if(day > maxDayNum) {
				day = maxDayNum;
			}
		}
		
		cal.set(Calendar.DATE, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		DateFormat df = new SimpleDateFormat(DAY_FORMAT);
		return df.format(cal.getTime());
	}

	public static String getYesterdayStr(int num) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		DateFormat df = new SimpleDateFormat(DEF_FORMAT);
		return df.format(cal.getTime());
	}
	
	public static String addDay(int day, String format){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		DateFormat df = new SimpleDateFormat(format);
		return df.format(cal.getTime());
	}

	public static String getLastMinStr(int num) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		cal.add(Calendar.HOUR_OF_DAY, 0);
		cal.add(Calendar.MINUTE, num);
		cal.add(Calendar.SECOND, 0);
		cal.add(Calendar.MILLISECOND, 0);

		DateFormat df = new SimpleDateFormat(DEF_FORMAT);
		return df.format(cal.getTime());
	}

	public static int getIntervalBySecond() {
		Date date = new Date();
		int min = date.getMinutes();
		int sec = date.getSeconds();

		int left = 0;

		int div = min % 2;
		if (div == 0) {
			left = 120 - sec;
		} else {
			left = 60 - sec;
		}

		return left;
	}

	public static Date addDay(String s, int n) {
		Calendar cd = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			cd = Calendar.getInstance();
			cd.setTime(sdf.parse(s));
			cd.add(Calendar.DATE, n);// 增加一天
			return cd.getTime();

		} catch (Exception e) {
			return null;
		} finally {
			cd.clear();
		}

	}

	public static Date getTodayWithOutHMS() {
		return DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
	}

	/**
	 * 比较两个日期的年份。
	 * 
	 * @param d1
	 * @param d2
	 * @return d1-d2的年份差
	 */
	public static int compareYear(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);

		return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
	}
	
	/**
	 * 比较两个日期的年份。
	 * 
	 * @param d1
	 * @param d2
	 * @return d1-d2的年份差
	 */
	public static int compare(Date d1, Date d2) {
		long result = d1.getTime()-d2.getTime();
		if(result>0L){
			return 1;
		}else if(result==0L){
			return 0;
		}else{
			return -1;
		}
	}

	/**
	 * 获取当前时间到当天二十四点之间的剩余秒数
	 * 
	 * @return
	 */
	public static int getSecondToMorning() {
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.HOUR_OF_DAY, 24);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		ca.set(Calendar.MILLISECOND, 0);
		long time = ca.getTimeInMillis() - System.currentTimeMillis();
		int second = (int) time / 1000;

		// java client的实现源码里是这样实现的 expiry.getTime() /
		// 1000，也就是说，如果小于1000的值，除以1000以后都是0，即永不过期
		return Math.max(1, second);
	}
	
}
