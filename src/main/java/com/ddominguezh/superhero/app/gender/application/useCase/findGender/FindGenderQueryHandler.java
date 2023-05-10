package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddominguezh.cqrs.shared.domain.bus.query.QueryHandler;

@ManagedBean
public class FindGenderQueryHandler implements QueryHandler<FindGenderQuery, FindGenderResponse>{

	@Autowired
	private GenderFinder finder;
	
	@Override
	public FindGenderResponse handle(FindGenderQuery query) {
		return finder.invoke(query);
	}

}
