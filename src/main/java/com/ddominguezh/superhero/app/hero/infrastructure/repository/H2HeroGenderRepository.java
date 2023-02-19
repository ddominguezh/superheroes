package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroGenderRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;

@Repository
public class H2HeroGenderRepository implements HeroGenderRepository {

	@Override
	public Optional<HeroGender> findById(HeroGenderId id) {
		// TODO Auto-generated method stub
		return null;
	}

}
