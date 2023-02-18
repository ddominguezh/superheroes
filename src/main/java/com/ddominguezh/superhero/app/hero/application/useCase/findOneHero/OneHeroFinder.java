package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

@Service
public class OneHeroFinder {

	@Autowired
	private HeroRepository repository;
	
	public FindOneHeroResponse invoke(FindOneHeroQuery query) {
		return FindOneHeroResponse.from(this.repository.findById(HeroId.create(query.getId())));
	}

}
