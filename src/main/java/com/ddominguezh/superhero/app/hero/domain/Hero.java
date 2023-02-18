package com.ddominguezh.superhero.app.hero.domain;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.shared.domain.Identifier;

public class Hero {

	private HeroId id;
	protected Hero() {
		this(HeroId.create(Identifier.empty()));
	}
	protected Hero(HeroId id) {
		this.id = id;
	}
	public static Hero create(String id) {
		return new Hero(
				HeroId.create(id)
			);
	}
	public String id() {
		return this.id.value();
	}
}
