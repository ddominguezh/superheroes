package com.ddominguezh.superhero.app.hero.domain.exception;

public class HeroNotFoundException extends RuntimeException {

	public HeroNotFoundException() {
		super("Hero not found");
	}
}
