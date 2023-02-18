package com.ddominguezh.superhero.app.hero.domain.exception;

import org.springframework.http.HttpStatus;

import com.ddominguezh.superhero.shared.domain.DomainError;

public class HeroNotFoundException extends DomainError {

	public HeroNotFoundException() {
		super(HttpStatus.NOT_FOUND.value()+"", "Hero not found");
	}
}
