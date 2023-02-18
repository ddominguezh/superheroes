package com.ddominguezh.superhero.app.hero.domain;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroName;
import com.ddominguezh.superhero.shared.domain.Identifier;

public class Hero {

	private HeroId id;
	private HeroName name;
	protected Hero() {
		this(new HeroId(), new HeroName());
	}
	protected Hero(HeroId id, HeroName name) {
		this.id = id;
		this.name = name;
	}
	public static Hero create(String id, String name) {
		return new Hero(
				HeroId.create(id),
				HeroName.create(name)
			);
	}
	public String id() {
		return this.id.value();
	}
	public String name() {
		return this.name.value();
	}
}
