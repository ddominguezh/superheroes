package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddominguezh.cqrs.shared.domain.bus.query.QueryHandler;

@ManagedBean
public class FindOneHeroQueryHandler implements QueryHandler<FindOneHeroQuery, FindOneHeroResponse> {

	@Autowired
	private OneHeroFinder finder;
	
	@Override
	public FindOneHeroResponse handle(FindOneHeroQuery query) {
		return finder.invoke(query);
	}

}
