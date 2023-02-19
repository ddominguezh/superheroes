package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.useCase.findColorById.ColorByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById.GenderByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;

@Service
public class HeroCreator {

	@Autowired
	private HeroRepository repository;
	
	@Autowired
	private GenderByIdFinder genderFinder;
	
	@Autowired
	private ColorByIdFinder colorFinder;
	
	public void invoke(CreateHeroCommand command) {
		HeroGender gender = genderFinder.invoke(HeroGenderId.create(command.getGenderId()));
		HeroColor eyeColor = colorFinder.invoke(HeroColorId.create(command.getEyeColorId()));
		HeroColor hairColor = colorFinder.invoke(HeroColorId.create(command.getHairColorId()));
		repository.create(
				Hero.create(
						command.getId(), 
						gender.id(),
						gender.name(),
						eyeColor.id(),
						eyeColor.name(),
						hairColor.id(),
						hairColor.name(),
						command.getName(),
						command.getHeight(),
						command.getWeight()
					)
				);
	}
}
