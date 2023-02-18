package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

@Service
public class OneHeroFinder {

	@Autowired
	private HeroRepository repository;
	
	public FindOneHeroResponse invoke(FindOneHeroQuery query) {
		Optional<Hero> hero = this.repository.findById(HeroId.create(query.getId()));
		if(hero.isEmpty()) {
			throw new HeroNotFoundException();
		}
		return FindOneHeroResponse.from(hero.get());
	}

}
