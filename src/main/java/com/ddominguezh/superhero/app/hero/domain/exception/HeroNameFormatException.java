package com.ddominguezh.superhero.app.hero.domain.exception;

import org.springframework.http.HttpStatus;

import com.ddominguezh.spring.core.shared.domain.DomainError;

@SuppressWarnings("serial")
public class HeroNameFormatException extends DomainError {

	public HeroNameFormatException(int minLength, int maxLength) {
		super(HttpStatus.BAD_REQUEST.value()+"", "Hero Name Format Exception. Length(" + minLength + ", " + maxLength + ")");
	}

}
