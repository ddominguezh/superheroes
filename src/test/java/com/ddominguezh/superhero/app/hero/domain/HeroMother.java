package com.ddominguezh.superhero.app.hero.domain;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;

public class HeroMother {

	public static Hero randomHero() {
		return randomHero(UUID.randomUUID().toString());
	}

	public static Hero randomHeroWithId(String heroid) {
		return randomHero(heroid);
	}
	
	private static Hero randomHero(String heroid) {
		Random random = new Random();
		int eyeColor = random.nextInt(4) + 1;
		return Hero.create(
				heroid,
				random.nextInt(3) + 1,
				randomAlphabetic(20),
				eyeColor,
				randomAlphabetic(20),
				eyeColor + 1,
				randomAlphabetic(20),
				randomAlphabetic(50),
				random.nextInt(250),
				random.nextInt(100));
	}
	
	public static HeroGender randomHeroGender() {
		Random random = new Random();
		return HeroGender.create(random.nextInt(3) + 1, randomAlphabetic(20));
	}

	public static HeroColor randomHeroColor() {
		Random random = new Random();
		return HeroColor.create(random.nextInt(5) + 1, randomAlphabetic(20));
	}

	public static List<Hero> randomHeroes() {
		List<Hero> heroes = new ArrayList<Hero>();
		for(int i = 0 ; i < new Random().nextInt(10) ; i++) {
			heroes.add(randomHero());
		}
		return heroes;
	}

	

}
