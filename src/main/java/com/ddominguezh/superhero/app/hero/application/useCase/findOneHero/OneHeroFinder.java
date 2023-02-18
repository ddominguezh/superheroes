package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

@Service
public class OneHeroFinder {

	@Autowired
	private HeroByIdFinder finder;
	
	public FindOneHeroResponse invoke(FindOneHeroQuery query) {
		return FindOneHeroResponse.from(finder.invoke(HeroId.create(query.getId())));
	}

}
