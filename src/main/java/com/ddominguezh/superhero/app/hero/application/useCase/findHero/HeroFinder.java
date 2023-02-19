package com.ddominguezh.superhero.app.hero.application.useCase.findHero;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.shared.domain.criteria.Criteria;
import com.ddominguezh.superhero.shared.domain.criteria.Filter;
import com.ddominguezh.superhero.shared.domain.criteria.FilterOperator;
import com.ddominguezh.superhero.shared.domain.criteria.Filters;
import com.ddominguezh.superhero.shared.domain.criteria.Order;

@Service
public class HeroFinder {

	@Autowired
	private HeroRepository repository;

	public FindHeroResponse invoke(FindHeroQuery query) {
		List<Filter> filters = new ArrayList<Filter>();
		if(query.getName() != null && !query.getName().isEmpty()) {
			filters.add(Filter.create("name", FilterOperator.CONTAINS.value(), query.getName()));
		}
		return FindHeroResponse.from(repository.findAll(new Criteria(new Filters(filters), Order.asc("id"))));
	}
	
}
