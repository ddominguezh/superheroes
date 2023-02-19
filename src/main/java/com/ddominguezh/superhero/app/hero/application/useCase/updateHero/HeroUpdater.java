package com.ddominguezh.superhero.app.hero.application.useCase.updateHero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.useCase.findColorById.ColorByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById.GenderByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinder;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

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
	
	public void invoke(UpdateHeroCommand command) {
		Hero hero = heroFinder.invoke(HeroId.create(command.getId()));
		HeroGender gender = genderFinder.invoke(HeroGenderId.create(command.getGenderId()));
		HeroColor eyeColor = colorFinder.invoke(HeroColorId.create(command.getEyeColorId()));
		HeroColor hairColor = colorFinder.invoke(HeroColorId.create(command.getHairColorId()));
		repository.update(
				Hero.create(
						hero.id(), 
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
