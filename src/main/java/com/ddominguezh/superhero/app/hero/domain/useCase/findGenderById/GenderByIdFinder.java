package com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.exception.HeroGenderNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroGenderRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;

@Service
public class GenderByIdFinder {

	@Autowired
	private HeroGenderRepository repository;
	
	public HeroGender invoke(HeroGenderId id) {
		Optional<HeroGender> gender = repository.findById(id);
		if(gender.isEmpty()) {
			throw new HeroGenderNotFoundException(id.value());
		}
		return gender.get();
	}

}
