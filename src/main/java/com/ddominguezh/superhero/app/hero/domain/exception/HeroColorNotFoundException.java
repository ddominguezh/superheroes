package com.ddominguezh.superhero.app.hero.domain.exception;

import org.springframework.http.HttpStatus;

import com.ddominguezh.spring.core.shared.domain.DomainError;

@SuppressWarnings("serial")
public class HeroColorNotFoundException extends DomainError {

	public HeroColorNotFoundException(int id) {
		super(HttpStatus.NOT_FOUND.value() + "", "Hero Color (" + id +  ") Not Found");
	}

}
