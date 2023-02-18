package com.ddominguezh.superhero.app.hero.domain.exception;

import org.springframework.http.HttpStatus;

import com.ddominguezh.superhero.shared.domain.DomainError;

public class HeroIdFormatException extends DomainError {

	public HeroIdFormatException() {
		super(HttpStatus.BAD_REQUEST.value() + "", "Hero Id format exception");
	}

}
