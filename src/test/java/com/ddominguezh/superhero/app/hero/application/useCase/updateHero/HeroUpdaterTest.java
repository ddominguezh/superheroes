package com.ddominguezh.superhero.app.hero.application.useCase.updateHero;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.hero.application.useCase.createHero.CreateHeroCommand;
import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.HeroMother;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroGenderNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.useCase.findColorById.ColorByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById.GenderByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class HeroUpdaterTest {

	private static final String userId = "7f675eca-afbf-11ed-afa1-0242ac120002";
	
	@InjectMocks
	private HeroUpdater updater;
	
	@Mock
	private HeroRepository repository;
	
	@Mock
	private HeroByIdFinder heroFinder;
	
	@Mock
	private GenderByIdFinder genderFinder;
	
	@Mock
	private ColorByIdFinder colorFinder;
	
	@Test
	public void update_hero() {
		Hero hero = HeroMother.randomHero();
		
		when(heroFinder.invoke(HeroId.create(userId))).thenReturn(hero);
		HeroGender gender = HeroMother.randomHeroGender();
		when(genderFinder.invoke(any(HeroGenderId.class))).thenReturn(gender);
		HeroColor eyeColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.eyeColorId()))).thenReturn(eyeColor);
		HeroColor hairColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.hairColorId()))).thenReturn(hairColor);
		
		updater.invoke(
				new UpdateHeroCommand(
						userId, 
						hero.genderId(),
						hero.eyeColorId(),
						hero.hairColorId(),
						hero.name(), 
						hero.height(), 
						hero.weight()
					)
				);
		verify(repository, times(1)).update(any(Hero.class));
	}
	
	@Test
	public void hero_not_found() {
		Hero hero = HeroMother.randomHero();
		
		when(heroFinder.invoke(HeroId.create(userId))).thenThrow(HeroNotFoundException.class);
		HeroGender gender = HeroMother.randomHeroGender();
		when(genderFinder.invoke(any(HeroGenderId.class))).thenReturn(gender);
		HeroColor eyeColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.eyeColorId()))).thenReturn(eyeColor);
		HeroColor hairColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.hairColorId()))).thenReturn(hairColor);
		
		assertThrows(HeroNotFoundException.class, () -> updater.invoke(
				new UpdateHeroCommand(
						userId, 
						hero.genderId(),
						hero.eyeColorId(),
						hero.hairColorId(),
						hero.name(), 
						hero.height(), 
						hero.weight()
					)
				));
		verify(repository, times(0)).update(any(Hero.class));
	}
}
