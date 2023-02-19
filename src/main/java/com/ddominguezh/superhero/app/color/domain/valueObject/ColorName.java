package com.ddominguezh.superhero.app.color.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.StringValueObject;

public class ColorName extends StringValueObject {

	public ColorName(){
		this(StringValueObject.empty());
	}
	protected ColorName(String value) {
		super(value);
	}
	
	public static ColorName create(String value) {
		return new ColorName(value);
	}
	
}
