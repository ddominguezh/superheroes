package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.hibernate.core.shared.domain.IntValueObject;

public class HeroWeight extends IntValueObject {

	public HeroWeight() {
		super(IntValueObject.empty());
	}
	
	protected HeroWeight(int value) {
		super(value);
	}

	public static HeroWeight create(int value) {
		return new HeroWeight(value);
	}
	
}
