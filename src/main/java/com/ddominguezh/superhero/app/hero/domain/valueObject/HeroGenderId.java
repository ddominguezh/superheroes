package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.IntValueObject;

public class HeroGenderId extends IntValueObject{

	public HeroGenderId() {
		super(IntValueObject.empty());
	}
	public HeroGenderId(int value) {
		super(value);
	}
	public static HeroGenderId create(int value) {
		return new HeroGenderId(value);
	}
	
}
