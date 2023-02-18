package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.superhero.shared.domain.Identifier;

public class HeroId extends Identifier {

	protected HeroId() {
		super(Identifier.empty());
	}

	protected HeroId(String id) {
		super(id);
	}
	
	public static HeroId create(String id) {
		return new HeroId(id);
	}
	
}
