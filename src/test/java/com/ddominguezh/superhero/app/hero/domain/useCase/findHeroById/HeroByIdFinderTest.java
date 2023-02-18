package com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.HeroMother;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class HeroByIdFinderTest {

	@InjectMocks
	private HeroByIdFinder finder;
	
	@Mock
	private HeroRepository repository;
	
	@Test
	public void get_hero() {
		Hero hero = HeroMother.randomHero();
		when(repository.findById(any(HeroId.class))).thenReturn(Optional.of(hero));
		Hero response = finder.invoke(HeroId.create(hero.id()));
		assertEquals(hero.id(), response.id());
	}
	
	@Test
	public void hero_not_found() {
		when(repository.findById(any(HeroId.class))).thenReturn(Optional.empty());
		assertThrows(HeroNotFoundException.class, () -> finder.invoke(HeroId.create(UUID.randomUUID().toString())));
	}
}
