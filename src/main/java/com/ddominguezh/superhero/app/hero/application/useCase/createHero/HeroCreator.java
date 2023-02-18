package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;

@Service
public class HeroCreator {

	@Autowired
	private HeroRepository repository;
	
	public void invoke(CreateHeroCommand command) {
		
	}
}
