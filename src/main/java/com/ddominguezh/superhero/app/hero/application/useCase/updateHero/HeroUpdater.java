package com.ddominguezh.superhero.app.hero.application.useCase.updateHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.useCase.findColorById.ColorByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById.GenderByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinder;

@Service
public class HeroUpdater {

	@Autowired
	private HeroRepository repository;
	
	@Autowired
	private HeroByIdFinder heroFinder;
	
	@Autowired
	private GenderByIdFinder genderFinder;
	
	@Autowired
	private ColorByIdFinder colorFinder;
	
	public void invoke(UpdateHeroCommand updateHeroCommand) {
		// TODO Auto-generated method stub
		
	}

}
