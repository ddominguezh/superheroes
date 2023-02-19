package com.ddominguezh.superhero.app.hero.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroName;
import com.ddominguezh.superhero.shared.domain.criteria.Criteria;

public interface HeroRepository {

	Optional<Hero> findById(HeroId ID);
	void delete(Hero hero);
	void create(Hero hero);
	void update(Hero hero);
	List<Hero> findAll(Criteria criteria);
	
}
