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

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@Transactional
public class H2HeroColorRepositoryTest {

	@Autowired
	private H2HeroColorRepository repository;
	
	@Test
	public void color_detail() {
		Optional<HeroColor> color = repository.findById(HeroColorId.create(2));
		assertTrue(color.isPresent());
		assertEquals(2, color.get().id());
		assertEquals("green", color.get().name());
	}
	
	@Test
	public void color_not_found() {
		Optional<HeroColor> color = repository.findById(HeroColorId.create(Integer.MAX_VALUE));
		assertTrue(color.isEmpty());
	}
}
