package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.HeroMother;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class HeroCreatorTest {

	@InjectMocks
	private HeroCreator creator;
	
	@Mock
	private HeroRepository repository;
	
	@Test
	public void create_hero() {
		Hero hero = HeroMother.randomHero();
		creator.invoke(new CreateHeroCommand(hero.id(), hero.name()));
		verify(repository, times(1)).create(any(Hero.class));
	}
}
