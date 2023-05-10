package com.ddominguezh.superhero.app.gender.domain.valueObject;

import com.ddominguezh.hibernate.core.shared.domain.IntValueObject;

public class GenderId extends IntValueObject {

	public GenderId() {
		this(IntValueObject.empty());
	}
	protected GenderId(int value) {
		super(value);
	}

	public static GenderId create(int value) {
		return new GenderId(value);
	}

}
