package com.dayima.stat.job;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.dayima.stat.service.StatService;
import com.dayima.stat.util.CSVUtils;
import com.dayima.stat.util.MyDatesUtils;
import com.dayima.stat.util.PropertiesUtil;

public class StatJob {
	
	@Resource
	private StatService statService;

	public void work() {
		List<Map<String, Object>> tmList;
		List<Map<String, Object>> misList;
		try {
			System.out.println("stat start............");
			// 当前日期前一天
			String date = MyDatesUtils.getOffsetDate(-1);
			tmList = statService.getTm(date);
			misList = statService.getMis(date);
			// 生成文件
			String dataDir = PropertiesUtil.getInstance().getDataDir();
			File tmFile = new File(dataDir + "特卖" + date + ".csv");
			File misFile = new File(dataDir + "周期购" + date + ".csv");
			CSVUtils.exportTmCsv(tmFile, tmList);
			CSVUtils.exportMisCsv(misFile, misList);
			System.out.println("stat end............");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
