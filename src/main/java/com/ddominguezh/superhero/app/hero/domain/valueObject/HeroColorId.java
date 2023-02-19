package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.IntValueObject;

public class HeroColorId extends IntValueObject{

	public HeroColorId() {
		super(IntValueObject.empty());
	}
	public HeroColorId(int value) {
		super(value);
	}
	public static HeroColorId create(int value) {
		return new HeroColorId(value);
	}
	
}
