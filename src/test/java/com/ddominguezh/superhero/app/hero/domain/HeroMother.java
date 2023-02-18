package com.ddominguezh.superhero.app.hero.domain;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.UUID;

public class HeroMother {

	public static Hero randomHero() {
		return Hero.create(UUID.randomUUID().toString(), randomAlphabetic(50));
	}

}
