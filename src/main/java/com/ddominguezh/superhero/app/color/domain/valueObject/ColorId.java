package com.ddominguezh.superhero.app.color.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.IntValueObject;

public class ColorId extends IntValueObject {

	protected ColorId(){
		this(IntValueObject.Empty());
	}
	protected ColorId(int value) {
		super(value);
	}
	public static ColorId create(int value) {
		return new ColorId(value);
	}
	
}
