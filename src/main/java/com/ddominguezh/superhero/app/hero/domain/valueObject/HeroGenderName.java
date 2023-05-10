package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.hibernate.core.shared.domain.StringValueObject;

public class HeroGenderName extends StringValueObject {

	public HeroGenderName() {
		super(StringValueObject.empty());
	}
	public HeroGenderName(String value) {
		super(value);
	}
	public static HeroGenderName create(String value) {
		return new HeroGenderName(value);
	}
}
