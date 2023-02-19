package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

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

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.HeroMother;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroColorNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroGenderNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.useCase.findColorById.ColorByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById.GenderByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class HeroCreatorTest {

	@InjectMocks
	private HeroCreator creator;
	
	@Mock
	private HeroRepository repository;
	
	@Mock
	private GenderByIdFinder genderFinder;
	
	@Mock
	private ColorByIdFinder colorFinder;
	
	@Test
	public void create_hero() {
		Hero hero = HeroMother.randomHero();
		
		HeroGender gender = HeroMother.randomHeroGender();
		when(genderFinder.invoke(any(HeroGenderId.class))).thenReturn(gender);
		HeroColor eyeColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.eyeColorId()))).thenReturn(eyeColor);
		HeroColor hairColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.hairColorId()))).thenReturn(hairColor);
		
		creator.invoke(
				new CreateHeroCommand(
						hero.id(), 
						hero.genderId(),
						hero.eyeColorId(),
						hero.hairColorId(),
						hero.name(), 
						hero.height(), 
						hero.weight()
					)
				);
		verify(repository, times(1)).create(any(Hero.class));
	}
	
	@Test
	public void hero_gender_not_found() {
		Hero hero = HeroMother.randomHero();
		
		when(genderFinder.invoke(any(HeroGenderId.class))).thenThrow(HeroGenderNotFoundException.class);
		HeroColor eyeColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.eyeColorId()))).thenReturn(eyeColor);
		HeroColor hairColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.hairColorId()))).thenReturn(hairColor);
		
		assertThrows(HeroGenderNotFoundException.class, () -> creator.invoke(
				new CreateHeroCommand(
						hero.id(), 
						hero.genderId(),
						hero.eyeColorId(),
						hero.hairColorId(),
						hero.name(), 
						hero.height(), 
						hero.weight()
					)
				));
		verify(repository, times(0)).create(any(Hero.class));
	}
	
	@Test
	public void hero_eye_color_not_found() {
		Hero hero = HeroMother.randomHero();
		HeroGender gender = HeroMother.randomHeroGender();
		when(genderFinder.invoke(any(HeroGenderId.class))).thenReturn(gender);
		
		when(colorFinder.invoke(HeroColorId.create(hero.eyeColorId()))).thenThrow(HeroColorNotFoundException.class);
		HeroColor hairColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.hairColorId()))).thenReturn(hairColor);
		
		assertThrows(HeroColorNotFoundException.class, () -> creator.invoke(
				new CreateHeroCommand(
						hero.id(), 
						hero.genderId(),
						hero.eyeColorId(),
						hero.hairColorId(),
						hero.name(), 
						hero.height(), 
						hero.weight()
					)
				));
		verify(repository, times(0)).create(any(Hero.class));
	}
	
	@Test
	public void hero_hair_color_not_found() {
		Hero hero = HeroMother.randomHero();
		
		HeroGender gender = HeroMother.randomHeroGender();
		when(genderFinder.invoke(any(HeroGenderId.class))).thenReturn(gender);
		HeroColor eyeColor = HeroMother.randomHeroColor();
		when(colorFinder.invoke(HeroColorId.create(hero.eyeColorId()))).thenReturn(eyeColor);
		when(colorFinder.invoke(HeroColorId.create(hero.hairColorId()))).thenThrow(HeroColorNotFoundException.class);
		
		assertThrows(HeroColorNotFoundException.class, () -> creator.invoke(
				new CreateHeroCommand(
						hero.id(), 
						hero.genderId(),
						hero.eyeColorId(),
						hero.hairColorId(),
						hero.name(), 
						hero.height(), 
						hero.weight()
					)
				));
		verify(repository, times(0)).create(any(Hero.class));
	}
}
