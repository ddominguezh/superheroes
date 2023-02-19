package com.ddominguezh.superhero.app.hero.domain.useCase.findColorById;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroColorRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;

@Service
public class ColorByIdFinder {

	@Autowired
	private HeroColorRepository repository;
	
	public HeroColor invoke(HeroColorId id) {
		Optional<HeroColor> color = repository.findById(id);
		return color.get();
	}

}
