package com.ddominguezh.superhero.app.hero.domain.valueObject;

import com.ddominguezh.hibernate.core.shared.domain.Identifier;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroIdFormatException;

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
