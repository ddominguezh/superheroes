package com.ddominguezh.superhero.app.color.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.StringValueObject;

public class ColorName extends StringValueObject {

	protected ColorName(){
		this(StringValueObject.Empty());
	}
	protected ColorName(String value) {
		super(value);
	}
	
	public static ColorName create(String value) {
		return new ColorName(value);
	}
	
}
