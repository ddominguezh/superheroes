package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;

@Service
public class HeroCreator {

	@Autowired
	private HeroRepository repository;
	
	public void invoke(CreateHeroCommand command) {
		repository.create(
				Hero.create(
						command.getId(), 
						command.getGenderId(),
						null,
						command.getEyeColorId(),
						null,
						command.getHairColorId(),
						null,
						command.getName(),
						command.getHeight(),
						command.getWeight()
					)
				);
	}
}
