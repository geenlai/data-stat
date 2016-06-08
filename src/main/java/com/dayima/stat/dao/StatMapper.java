package com.dayima.stat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StatMapper {

	/**
	 * 查询特卖信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTm (@Param("date")String date);
	
	/**
	 * 查询周期购信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getMis (@Param("date")String date);
}
