package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.gender.domain.repository.GenderRepository;

@Service
public class GenderFinder {

	@Autowired
	private GenderRepository repository;
	
	@Cacheable("genders")
	public FindGenderResponse invoke(FindGenderQuery query) {
		return FindGenderResponse.from(repository.findAll());
	}

}
