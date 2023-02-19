package com.ddominguezh.superhero.app.hero.application.useCase.findHero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindHeroResponse implements Response {

	private List<HeroResponse> heroes;
	protected FindHeroResponse(List<HeroResponse> heroes) {
		this.heroes = heroes;
	}
	public static FindHeroResponse from(List<Hero> heroes) {
		List<HeroResponse> heroesResponse = new ArrayList<HeroResponse>();
		if(heroes != null) {
			heroesResponse = heroes.stream().map(hero -> HeroResponse.from(hero)).collect(Collectors.toList());
		}
		return new FindHeroResponse(heroesResponse); 
	}
	public List<HeroResponse> getHeroes() {
		return this.heroes;
	}
	public int getSize() {
		return this.heroes.size();
	}

}
