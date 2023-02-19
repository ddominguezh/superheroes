package com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroGenderRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;

@Service
public class GenderByIdFinder {

	@Autowired
	private HeroGenderRepository repository;
	
	public HeroGender invoke(HeroGenderId id) {
		// TODO Auto-generated method stub
		return null;
	}

}
