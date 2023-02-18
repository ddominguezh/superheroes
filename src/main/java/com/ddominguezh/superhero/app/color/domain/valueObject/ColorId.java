package com.ddominguezh.superhero.app.color.domain.valueObject;

public class ColorId {

	private int value;
	ColorId(int value) {
		this.value = value;
	}
	public static ColorId create(int value) {
		return new ColorId(value);
	}
	public int getValue() {
		return value;
	}
	
}
