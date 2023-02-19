package com.ddominguezh.superhero.app.hero.domain.exception;

import org.springframework.http.HttpStatus;

import com.ddominguezh.superhero.shared.domain.DomainError;

public class HeroGenderNotFoundException extends DomainError {

	public HeroGenderNotFoundException(int id) {
		super(HttpStatus.NOT_FOUND.value() + "", "Hero Gender (" + id +  ") Not Found");
	}

}
