package com.ddominguezh.superhero.app.hero.application.useCase.findHero;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroName;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class HeroFinderTest {

	@InjectMocks
	private HeroFinder finder;
	
	@Mock
	public HeroRepository repository;
	
	@Test
	public void get_empty_heroes_list() {
		when(repository.findAll()).thenReturn(new ArrayList<Hero>());
		FindHeroResponse response = finder.invoke(new FindHeroQuery(null));
		verify(repository, times(1)).findAll();
		verify(repository, times(0)).findAll(any(HeroName.class));
		assertEquals(0, response.getSize());
	}
	
	@Test
	public void get_emtpy_heroes_list_when_retun_null() {
		when(repository.findAll()).thenReturn(null);
		FindHeroResponse response = finder.invoke(new FindHeroQuery(null));
		verify(repository, times(1)).findAll();
		verify(repository, times(0)).findAll(any(HeroName.class));
		assertEquals(0, response.getSize());
	}
	
	@Test
	public void get_heroes() {
		List<Hero> heroes = HeroMother.randomHeroes();
		when(repository.findAll()).thenReturn(heroes);
		FindHeroResponse response = finder.invoke(new FindHeroQuery(null));
		verify(repository, times(1)).findAll();
		verify(repository, times(0)).findAll(any(HeroName.class));
		assertEquals(heroes.size(), response.getSize());
		for(int i = 0 ; i < heroes.size() ; i++ ) {
			Hero hero = heroes.get(i);
			HeroResponse heroResponse = response.getHeroes().get(i);
			assertEquals(hero.id(), heroResponse.getId());
			assertEquals(hero.genderId(), heroResponse.getGenderId());
			assertEquals(hero.genderName(), heroResponse.getGenderName());
			assertEquals(hero.eyeColorId(), heroResponse.getEyeColorId());
			assertEquals(hero.eyeColorName(), heroResponse.getEyeColorName());
			assertEquals(hero.hairColorId(), heroResponse.getHairColorId());
			assertEquals(hero.hairColorName(), heroResponse.getHairColorName());
			assertEquals(hero.name(), heroResponse.getName());
			assertEquals(hero.height(), heroResponse.getHeight());
			assertEquals(hero.weight(), heroResponse.getWeight());
		}
	}
	
	@Test
	public void get_empty_heroes_list_when_filter_by_name() {
		when(repository.findAll(any(HeroName.class))).thenReturn(new ArrayList<Hero>());
		FindHeroResponse response = finder.invoke(new FindHeroQuery(randomAlphabetic(10)));
		verify(repository, times(0)).findAll();
		verify(repository, times(1)).findAll(any(HeroName.class));
		assertEquals(0, response.getSize());
	}
	
	@Test
	public void get_emtpy_heroes_list_when_filter_by_name_and_retun_null() {
		when(repository.findAll(any(HeroName.class))).thenReturn(null);
		FindHeroResponse response = finder.invoke(new FindHeroQuery(randomAlphabetic(10)));
		verify(repository, times(0)).findAll();
		verify(repository, times(1)).findAll(any(HeroName.class));
		assertEquals(0, response.getSize());
	}
	
	@Test
	public void get_heroeswhen_filter_by_name() {
		List<Hero> heroes = HeroMother.randomHeroes();
		when(repository.findAll(any(HeroName.class))).thenReturn(heroes);
		FindHeroResponse response = finder.invoke(new FindHeroQuery(randomAlphabetic(10)));
		verify(repository, times(0)).findAll();
		verify(repository, times(1)).findAll(any(HeroName.class));
		assertEquals(heroes.size(), response.getSize());
		for(int i = 0 ; i < heroes.size() ; i++ ) {
			Hero hero = heroes.get(i);
			HeroResponse heroResponse = response.getHeroes().get(i);
			assertEquals(hero.id(), heroResponse.getId());
			assertEquals(hero.genderId(), heroResponse.getGenderId());
			assertEquals(hero.genderName(), heroResponse.getGenderName());
			assertEquals(hero.eyeColorId(), heroResponse.getEyeColorId());
			assertEquals(hero.eyeColorName(), heroResponse.getEyeColorName());
			assertEquals(hero.hairColorId(), heroResponse.getHairColorId());
			assertEquals(hero.hairColorName(), heroResponse.getHairColorName());
			assertEquals(hero.name(), heroResponse.getName());
			assertEquals(hero.height(), heroResponse.getHeight());
			assertEquals(hero.weight(), heroResponse.getWeight());
		}
	}
}
