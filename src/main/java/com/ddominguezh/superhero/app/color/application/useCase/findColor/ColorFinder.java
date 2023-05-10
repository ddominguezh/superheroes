package com.ddominguezh.superhero.app.color.application.useCase.findColor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;
import com.ddominguezh.superhero.app.color.domain.repository.ColorRepository;

@Service
public class ColorFinder {

	@Autowired
	private ColorRepository repository;
	
	@Cacheable("colors")
	public FindColorResponse invoke(FindColorQuery findColorQuery) {
		return FindColorResponse.from(repository.findAll());
	}

}
