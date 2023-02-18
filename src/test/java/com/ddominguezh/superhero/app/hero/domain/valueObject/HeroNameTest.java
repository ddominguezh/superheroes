package com.ddominguezh.superhero.app.hero.domain.valueObject;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.ddominguezh.superhero.app.hero.domain.exception.HeroNameFormatException;

public class HeroNameTest {

	@Test
	public void valid_hero_name() {
		HeroName.create(randomAlphabetic(1));
		HeroName.create(randomAlphabetic(255));
	}
	
	@Test
	public void hero_name_empty_exception() {
		assertThrows(HeroNameFormatException.class, () -> HeroName.create(""));
	}
	
	@Test
	public void hero_name_max_length_exception() {
		assertThrows(HeroNameFormatException.class, () -> HeroName.create(randomAlphabetic(256)));
	}
}
