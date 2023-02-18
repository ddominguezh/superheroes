package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindOneHeroResponse implements Response {

	private String id;
	
	FindOneHeroResponse(String id){
		this.id = id;
	}

	public static FindOneHeroResponse from(Hero hero) {
		return new FindOneHeroResponse(hero.id());
	}
	
	public String getId() {
		return this.id;
	}
}
