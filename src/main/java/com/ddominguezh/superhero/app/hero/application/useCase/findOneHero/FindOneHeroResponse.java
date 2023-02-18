package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindOneHeroResponse implements Response {

	private String id;
	private String name;
	private int height;
	private int weight;
	FindOneHeroResponse(String id, String name, int height, int weight){
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public static FindOneHeroResponse from(Hero hero) {
		return new FindOneHeroResponse(
				hero.id(), 
				hero.name(),
				hero.height(),
				hero.weight()
			);
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public Integer getHeight() {
		return this.height;
	}

	public Integer getWeight() {
		return this.weight;
	}
}
