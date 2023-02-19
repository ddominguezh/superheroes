package com.ddominguezh.superhero.app.hero.domain.repository;

import java.util.Optional;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;

public interface HeroGenderRepository {

	Optional<HeroGender> findById(HeroGenderId id);

}
