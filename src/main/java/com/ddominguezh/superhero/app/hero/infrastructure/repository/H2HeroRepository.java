package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import org.springframework.stereotype.Repository;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

@Repository
public class H2HeroRepository implements HeroRepository {

	@Override
	public Hero findById(HeroId ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
