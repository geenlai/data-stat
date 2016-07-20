package com.dayima.stat.util.enums;

public enum OrderTypeEnum {

	DISCOUNT((byte)1, "特卖"),
	MISS((byte)2, "特卖"),
	FLASH((byte)5, "特卖");
	
	private byte value;
	private String name;
	
	public byte getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	
	OrderTypeEnum(byte value, String name) {
		this.value = value;
		this.name = name;
	}
	
}
