package com.ddominguezh.superhero.app.hero.application.useCase.findHero;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroName;

@Service
public class HeroFinder {

	@Autowired
	private HeroRepository repository;

	public FindHeroResponse invoke(FindHeroQuery query) {
		if(query.isEmpty()) {
			return FindHeroResponse.from(repository.findAll());
		}
		return FindHeroResponse.from(repository.findAll(HeroName.create(query.getName())));
	}
	
}
