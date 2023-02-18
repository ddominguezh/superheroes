package com.ddominguezh.superhero.app.hero.application.useCase.deleteHero;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class HeroDeleterTest {

	@InjectMocks
	private HeroDeleter deleter;
	
	@Mock
	private HeroByIdFinder finderById;
	
	@Mock
	private HeroRepository repository;
	
	@Test
	public void delete_hero() {
		Hero hero = HeroMother.randomHero();
		when(finderById.invoke(any(HeroId.class))).thenReturn(hero);
		deleter.invoke(new DeleteHeroCommand(hero.id()));
		verify(repository, times(1)).delete(any(Hero.class));
	}
	
	@Test
	public void hero_not_found() {
		when(finderById.invoke(any(HeroId.class))).thenThrow(HeroNotFoundException.class);
		assertThrows(HeroNotFoundException.class, () -> deleter.invoke(new DeleteHeroCommand(UUID.randomUUID().toString())));
	}
}
