package com.ddominguezh.superhero.app.hero.domain.repository;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

public interface HeroRepository {

	Hero findById(HeroId ID);

}
