package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.hibernate.core.shared.domain.StringValueObject;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNameFormatException;

public class HeroName extends StringValueObject {

	private static int MIN_LENGTH = 1;
	private static int MAX_LENGTH = 255;
	public HeroName() {
		super(StringValueObject.empty());
	}
	
	protected HeroName(String value) {
		super(value);
	}
	
	public static HeroName create(String name) {
		if(name == null || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
			throw new HeroNameFormatException(MIN_LENGTH, MAX_LENGTH);
		}
		return new HeroName(name);
	}
	
}
