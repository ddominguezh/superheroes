package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.IntValueObject;

public class HeroHeight extends IntValueObject {

	public HeroHeight() {
		super(IntValueObject.empty());
	}
	
	protected HeroHeight(int value) {
		super(value);
	}

	public static HeroHeight create(int value) {
		return new HeroHeight(value);
	}
}
