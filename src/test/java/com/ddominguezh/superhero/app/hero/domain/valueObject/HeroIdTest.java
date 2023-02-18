package com.ddominguezh.superhero.app.hero.domain.valueObject;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.Test;

import com.ddominguezh.superhero.app.hero.domain.exception.HeroIdFormatException;

public class HeroIdTest {

	@Test
	public void id_valid() {
		String id = UUID.randomUUID().toString();
		HeroId heroId = HeroId.create(id);
		assertEquals(id, heroId.value());
	}
	
	@Test
	public void id_with_bad_format() {
		assertThrows(HeroIdFormatException.class, () -> HeroId.create(randomAlphabetic(36)));
	}
}
