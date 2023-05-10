package com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;

@Service
public class HeroByIdFinder {

	@Autowired
	private HeroRepository repository;

	public Hero invoke(HeroId id) {
		Optional<Hero> hero = this.repository.findById(id);
		if(hero.isEmpty()) {
			throw new HeroNotFoundException();
		}
		return hero.get();
	}
}

