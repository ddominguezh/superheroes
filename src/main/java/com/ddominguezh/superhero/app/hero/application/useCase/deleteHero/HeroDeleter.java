package com.ddominguezh.superhero.app.hero.application.useCase.deleteHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

@Service
public class HeroDeleter {

	@Autowired
	private HeroByIdFinder finder;
	
	@Autowired
	private HeroRepository repository;
	
	public void invoke(DeleteHeroCommand command) {
		repository.delete(finder.invoke(HeroId.create(command.getId())));
	}

}
