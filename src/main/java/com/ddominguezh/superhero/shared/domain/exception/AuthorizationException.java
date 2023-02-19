package com.ddominguezh.superhero.shared.domain.exception;

import org.springframework.http.HttpStatus;

import com.ddominguezh.superhero.shared.domain.DomainError;

public class AuthorizationException extends DomainError {

	public AuthorizationException() {
		super(HttpStatus.UNAUTHORIZED.value()+"", "Authorization invalid");
	}

}
