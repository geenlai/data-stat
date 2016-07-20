package com.dayima.datacut.util;

import java.io.Serializable;

public class Pagger implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// 默认每页数据行数
	private final int DEFAULT_PAGE_SIZE = 20;
	// 每页最大数据量
	private final int MAX_PAGE_SIZE = 1000;

	private int startPage;
	private int pageSize;
	
	
	
	
	public Pagger() {
		super();
	}

	public Pagger(int startPage, int pageSize) {
		//如果开始页数小于1，则默认为1
		if (startPage >= 1) {
			this.startPage = startPage;
		} else {
			this.startPage = 1;
		}
		//如果总页数不在默认范围内，则设置为默认值
		if (pageSize < 0 || pageSize > MAX_PAGE_SIZE) {
			this.pageSize = DEFAULT_PAGE_SIZE;
		} else {
			this.pageSize = pageSize;
		}
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 计算出数据库查询起始行数
	 * 
	 * @return
	 */
	public int getStart() {
		int start = (startPage - 1) * pageSize;
		return start;
	}

	/**
	 * 计算出数据库查询出结果的行数
	 * 
	 * @return
	 */
	public int getLimit() {
		int limit = pageSize;
		return limit;
	}
}
