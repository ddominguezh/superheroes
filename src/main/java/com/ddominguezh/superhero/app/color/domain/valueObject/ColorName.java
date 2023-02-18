package com.ddominguezh.superhero.app.color.domain.valueObject;

public class ColorName {

	private String value;
	ColorName(String value) {
		this.value = value;
	}
	public static ColorName create(String value) {
		return new ColorName(value);
	}
	public String getValue() {
		return value;
	}
	
}
