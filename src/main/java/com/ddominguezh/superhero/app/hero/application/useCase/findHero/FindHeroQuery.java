package com.ddominguezh.superhero.app.hero.application.useCase.findHero;

import com.ddominguezh.superhero.shared.domain.bus.query.Query;

public class FindHeroQuery implements Query {

	private String name;
	public FindHeroQuery(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public boolean isEmpty() {
		return this.name == null || "".equals(this.name);
	}
}
