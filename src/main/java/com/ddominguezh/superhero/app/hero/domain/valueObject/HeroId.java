package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.superhero.app.hero.domain.exception.HeroIdFormatException;
import com.ddominguezh.superhero.shared.domain.Identifier;

public class HeroId extends Identifier {

	public HeroId() {
		super(Identifier.empty());
	}

	protected HeroId(String id) {
		super(id);
	}
	
	public static HeroId create(String id) {
		try {
			return new HeroId(id);
		}catch(IllegalArgumentException e) {
			throw new HeroIdFormatException();
		}
		
	}
	
}
