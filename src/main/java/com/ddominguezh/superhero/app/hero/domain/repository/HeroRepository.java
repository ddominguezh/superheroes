package com.ddominguezh.superhero.app.hero.domain.repository;

import java.util.Optional;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

public interface HeroRepository {

	Optional<Hero> findById(HeroId ID);
	void delete(Hero hero);
	void create(Hero hero);
	
}
