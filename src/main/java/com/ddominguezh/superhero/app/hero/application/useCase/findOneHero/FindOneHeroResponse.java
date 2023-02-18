package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindOneHeroResponse implements Response {

	private String id;
	private String name;
	FindOneHeroResponse(String id, String name){
		this.id = id;
		this.name = name;
	}

	public static FindOneHeroResponse from(Hero hero) {
		return new FindOneHeroResponse(hero.id(), hero.name());
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
}
