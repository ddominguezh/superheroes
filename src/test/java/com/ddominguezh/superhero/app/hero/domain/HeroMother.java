package com.ddominguezh.superhero.app.hero.domain;

import java.util.UUID;

public class HeroMother {

	public static Hero randomHero() {
		return Hero.create(UUID.randomUUID().toString());
	}

}
