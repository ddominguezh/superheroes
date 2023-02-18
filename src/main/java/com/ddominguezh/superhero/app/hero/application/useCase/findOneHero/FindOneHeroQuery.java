package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import com.ddominguezh.superhero.shared.domain.bus.query.Query;

public class FindOneHeroQuery implements Query {

	private String id;
	public FindOneHeroQuery(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	
}
