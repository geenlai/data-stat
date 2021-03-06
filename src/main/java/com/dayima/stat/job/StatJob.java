package com.dayima.stat.job;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.dayima.stat.service.StatService;
import com.dayima.stat.util.CSVUtils;
import com.dayima.stat.util.MyDatesUtils;
import com.dayima.stat.util.PropertiesUtil;
import com.dayima.stat.util.enums.OrderTypeEnum;

public class StatJob {
	
	@Resource
	private StatService statService;

	public void work() {
		List<Map<String, Object>> tmList;
		List<Map<String, Object>> misList;
		List<Map<String, Object>> flashList;
		try {
			System.out.println("stat start............");
			String dataDir = PropertiesUtil.getInstance().getDataDir();
			// 当前日期前一天
			String date = MyDatesUtils.getOffsetDate(-1);
			
			// 查询数据
			tmList = statService.getTm(date, OrderTypeEnum.DISCOUNT.getValue());
			misList = statService.getMis(date);
			flashList = statService.getTm(date, OrderTypeEnum.FLASH.getValue());
			
			// 生成文件
			File tmFile = new File(dataDir + "特卖" + date + ".csv");
			File misFile = new File(dataDir + "周期购" + date + ".csv");
			File flashFile = new File(dataDir + "限时购" + date + ".csv");
			
			// 导出excel
			CSVUtils.exportTmCsv(tmFile, tmList);
			CSVUtils.exportMisCsv(misFile, misList);
			CSVUtils.exportTmCsv(flashFile, flashList);
			
			System.out.println("stat end............");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
