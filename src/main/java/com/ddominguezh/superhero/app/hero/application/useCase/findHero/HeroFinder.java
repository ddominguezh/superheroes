package com.ddominguezh.superhero.app.hero.application.useCase.findHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;

@Service
public class HeroFinder {

	@Autowired
	private HeroRepository repository;

	public FindHeroResponse invoke(FindHeroQuery query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
