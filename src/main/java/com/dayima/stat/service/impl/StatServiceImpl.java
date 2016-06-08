package com.dayima.stat.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dayima.stat.dao.StatMapper;
import com.dayima.stat.service.StatService;

@Service("statService")
public class StatServiceImpl implements StatService {

	@Resource
	private StatMapper statMapper;
	
	@Override
	public List<Map<String, Object>> getTm(String date) throws Exception {
		List<Map<String, Object>> result = statMapper.getTm(date);
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getMis(String date) throws Exception {
		List<Map<String, Object>> result = statMapper.getMis(date);
		return result;
	}

}
