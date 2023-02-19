package com.ddominguezh.superhero.app.hero.application.useCase.findHero;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddominguezh.superhero.shared.domain.bus.query.QueryHandler;

@ManagedBean
public class FindHeroQueryHandler implements QueryHandler<FindHeroQuery, FindHeroResponse> {

	@Autowired
	private HeroFinder finder;
	
	@Override
	public FindHeroResponse handle(FindHeroQuery query) {
		return finder.invoke(query);
	}

}
