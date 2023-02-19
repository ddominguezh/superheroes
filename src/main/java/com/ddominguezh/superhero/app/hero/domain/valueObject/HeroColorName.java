package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.StringValueObject;

public class HeroColorName extends StringValueObject {

	public HeroColorName() {
		super(StringValueObject.empty());
	}
	public HeroColorName(String value) {
		super(value);
	}
	public static HeroColorName create(String value) {
		return new HeroColorName(value);
	}
}
