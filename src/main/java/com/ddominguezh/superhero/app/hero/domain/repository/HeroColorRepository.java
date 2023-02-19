package com.ddominguezh.superhero.app.hero.domain.repository;

import java.util.Optional;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;

public interface HeroColorRepository {

	Optional<HeroColor> findById(HeroColorId id);
	
}
