package com.ddominguezh.superhero.app.hero.domain;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.Random;
import java.util.UUID;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;

public class HeroMother {

	public static Hero randomHero() {
		Random random = new Random();
		return Hero.create(
				UUID.randomUUID().toString(),
				random.nextInt(3) + 1,
				randomAlphabetic(20),
				random.nextInt(5) + 1,
				randomAlphabetic(20),
				random.nextInt(5) + 1,
				randomAlphabetic(20),
				randomAlphabetic(50),
				random.nextInt(250),
				random.nextInt(100));
	}

	public static HeroGender randomHeroGender() {
		// TODO Auto-generated method stub
		return null;
	}

}
