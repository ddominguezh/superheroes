package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@Transactional
public class H2HeroGenderRepositoryTest {

	@Autowired
	private H2HeroGenderRepository repository;
	
	@Test
	public void gender_detail() {
		Optional<HeroGender> hero = repository.findById(HeroGenderId.create(2));
		assertTrue(hero.isPresent());
		assertEquals(2, hero.get().id());
		assertEquals("WOMEN", hero.get().name());
	}
	
	@Test
	public void gender_not_found() {
		Optional<HeroGender> hero = repository.findById(HeroGenderId.create(Integer.MAX_VALUE));
		assertTrue(hero.isEmpty());
	}
}
