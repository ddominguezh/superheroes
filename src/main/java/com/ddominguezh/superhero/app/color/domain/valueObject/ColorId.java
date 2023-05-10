package com.ddominguezh.superhero.app.color.domain.valueObject;

import com.ddominguezh.hibernate.core.shared.domain.IntValueObject;

public class ColorId extends IntValueObject {

	public ColorId(){
		this(IntValueObject.empty());
	}
	protected ColorId(int value) {
		super(value);
	}
	public static ColorId create(int value) {
		return new ColorId(value);
	}
	
}
