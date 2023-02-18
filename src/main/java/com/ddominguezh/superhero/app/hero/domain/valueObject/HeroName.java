package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.StringValueObject;

public class HeroName extends StringValueObject {

	public HeroName() {
		super(StringValueObject.Empty());
	}
	
	protected HeroName(String value) {
		super(value);
	}

	public static HeroName create() {
		return new HeroName();
	}
	
	public static HeroName create(String name) {
		return new HeroName(name);
	}
	
}
