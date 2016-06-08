package com.dayima.stat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class PropertiesUtil {
	
	private static Properties properties;
	private static PropertiesUtil propertiesUtil;
	
	private PropertiesUtil() throws IOException
	{
		InputStream inputStream = PropertiesUtil.class.getResourceAsStream("/application.properties");
		properties = new Properties();
		properties.load(inputStream);
	}
	
	/**
	 * 初始化工具类
	 * @return
	 * @throws IOException
	 */
	public synchronized static PropertiesUtil getInstance() throws IOException{
		if (propertiesUtil == null) {
			propertiesUtil = new PropertiesUtil();
		}
		return propertiesUtil;
	}
	
	
	/**
	 * 获取数据存放目录
	 * @return
	 */
	public String getDataDir() {
		return properties.getProperty("data_dir","");
	}
	
}
