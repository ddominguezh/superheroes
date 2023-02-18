package com.ddominguezh.superhero.app.hero.application.useCase.deleteHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.application.useCase.findOneHero.FindOneHeroResponse;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinder;

@Service
public class HeroDeleter {

	@Autowired
	private HeroByIdFinder finder;
	
	@Autowired
	private HeroRepository repository;
	
	public FindOneHeroResponse invoke(DeleteHeroCommand deleteHeroCommand) {
		// TODO Auto-generated method stub
		return null;
	}

}
