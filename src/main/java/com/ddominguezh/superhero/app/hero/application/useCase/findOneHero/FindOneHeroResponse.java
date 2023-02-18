package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindOneHeroResponse implements Response {

	private String id;
	
	public String getId() {
		return this.id;
	}
}
