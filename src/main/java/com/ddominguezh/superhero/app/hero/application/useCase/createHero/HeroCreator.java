package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById.GenderByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;

@Service
public class HeroCreator {

	@Autowired
	private HeroRepository repository;
	
	@Autowired
	private GenderByIdFinder genderFinder;
	
	public void invoke(CreateHeroCommand command) {
		HeroGender gender = genderFinder.invoke(HeroGenderId.create(command.getGenderId()));
		repository.create(
				Hero.create(
						command.getId(), 
						gender.id(),
						gender.name(),
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
