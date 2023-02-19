package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.HeroMother;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroName;
import com.ddominguezh.superhero.shared.SuperheroApplication;
import com.ddominguezh.superhero.shared.domain.criteria.Criteria;
import com.ddominguezh.superhero.shared.domain.criteria.Filter;
import com.ddominguezh.superhero.shared.domain.criteria.FilterOperator;
import com.ddominguezh.superhero.shared.domain.criteria.Filters;
import com.ddominguezh.superhero.shared.domain.criteria.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@Transactional
public class H2HeroRepositoryTest {

	private static final String heroId = "7f675eca-afbf-11ed-afa1-0242ac120002";
	@Autowired
	private H2HeroRepository repository;
	
	@Test
	public void hero_detail() {
		Optional<Hero> hero = repository.findById(HeroId.create(heroId));
		assertTrue(hero.isPresent());
		assertEquals(heroId, hero.get().id());
		assertEquals(3, hero.get().genderId());
		assertEquals("MEN", hero.get().genderName());
		assertEquals(4, hero.get().eyeColorId());
		assertEquals("black", hero.get().eyeColorName());
		assertEquals(2, hero.get().hairColorId());
		assertEquals("green", hero.get().hairColorName());
		assertEquals("Spiderman", hero.get().name());
		assertEquals(165, hero.get().height());
		assertEquals(80, hero.get().weight());
	}
	
	@Test
	public void hero_not_found() {
		Optional<Hero> hero = repository.findById(HeroId.create(UUID.randomUUID().toString()));
		assertTrue(hero.isEmpty());
	}
	
	@Test
	public void delete_hero() {
		Optional<Hero> hero = repository.findById(HeroId.create(heroId));
		repository.delete(hero.get());
		hero = repository.findById(HeroId.create(heroId));
		assertTrue(hero.isEmpty());
	}
	
	@Test
	public void create_hero() {
		Hero newHero = HeroMother.randomHero();
		repository.create(newHero);
		Optional<Hero> hero = repository.findById(HeroId.create(newHero.id()));
		assertTrue(hero.isPresent());
	}
	
	@Test
	public void update_hero() {
		Hero updadaHero = HeroMother.randomHeroWithId(heroId);
		repository.update(updadaHero);
		Optional<Hero> hero = repository.findById(HeroId.create(heroId));
		assertTrue(hero.isPresent());
		assertEquals(updadaHero.id(), hero.get().id());
		assertEquals(updadaHero.genderId(), hero.get().genderId());
		assertEquals(updadaHero.eyeColorId(), hero.get().eyeColorId());
		assertEquals(updadaHero.hairColorId(), hero.get().hairColorId());
		assertEquals(updadaHero.name(), hero.get().name());
		assertEquals(updadaHero.height(), hero.get().height());
		assertEquals(updadaHero.weight(), hero.get().weight());
	}
	
	@Test
	public void get_all_heroes() {
		List<Hero> heroes = repository.findAll();
		assertEquals(3, heroes.size());
	}
	
	@Test
	public void get_all_heroes_contains_name() {
		List<Hero> heroes = repository.findAll(HeroName.create("man"));
		assertEquals(2, heroes.size());
	}
}
