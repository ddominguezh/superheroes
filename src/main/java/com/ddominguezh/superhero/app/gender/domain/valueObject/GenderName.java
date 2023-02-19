package com.ddominguezh.superhero.app.gender.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.StringValueObject;

public class GenderName extends StringValueObject {

	public GenderName() {
		this(StringValueObject.empty());
	}
	protected GenderName(String value) {
		super(value);
	}

	public static GenderName create(String value) {
		return new GenderName(value);
	}

}
