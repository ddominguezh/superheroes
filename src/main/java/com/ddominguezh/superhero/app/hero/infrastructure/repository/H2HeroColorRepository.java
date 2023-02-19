package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroColorRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;

@Repository
public class H2HeroColorRepository implements HeroColorRepository {

	@Override
	public Optional<HeroColor> findById(HeroColorId id) {
		// TODO Auto-generated method stub
		return null;
	}

}
