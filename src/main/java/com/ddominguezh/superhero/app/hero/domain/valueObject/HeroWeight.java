package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.IntValueObject;

public class HeroWeight extends IntValueObject {

	public HeroWeight() {
		super(IntValueObject.Empty());
	}
	
	protected HeroWeight(int value) {
		super(value);
	}

	public static HeroWeight create(int value) {
		return new HeroWeight(value);
	}
	
}
