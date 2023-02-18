package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class H2HeroRepositoryTest {

	@Autowired
	private H2HeroRepository repository;
	
	@Test
	public void hero_detail() {
		String heroId = "7f675eca-afbf-11ed-afa1-0242ac120002";
		Optional<Hero> hero = repository.findById(HeroId.create(heroId));
		assertTrue(hero.isPresent());
		assertEquals(heroId, hero.get().id());
	}
	
	@Test
	public void hero_not_found() {
		Optional<Hero> hero = repository.findById(HeroId.create(UUID.randomUUID().toString()));
		assertTrue(hero.isEmpty());
	}
}