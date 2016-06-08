package com.dayima.stat.service;

import java.util.List;
import java.util.Map;

public interface StatService {

	/**
	 * 查询特卖信息
	 * @param date
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTm(String date) throws Exception;
	
	/**
	 * 查询周期购信息
	 * @param date
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMis(String date) throws Exception;
}
