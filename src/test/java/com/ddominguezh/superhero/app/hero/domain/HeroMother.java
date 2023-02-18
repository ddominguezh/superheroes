package com.ddominguezh.superhero.app.hero.domain;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.Random;
import java.util.UUID;

public class HeroMother {

	public static Hero randomHero() {
		Random random = new Random();
		return Hero.create(
				UUID.randomUUID().toString(), 
				randomAlphabetic(50),
				random.nextInt(250),
				random.nextInt(100));
	}

}
