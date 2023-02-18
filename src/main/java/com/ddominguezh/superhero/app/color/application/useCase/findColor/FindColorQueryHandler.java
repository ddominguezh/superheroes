package com.ddominguezh.superhero.app.color.application.useCase.findColor;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddominguezh.superhero.shared.domain.bus.query.QueryHandler;

@ManagedBean
public class FindColorQueryHandler implements QueryHandler<FindColorQuery, FindColorResponse> {

	@Autowired
	private ColorFinder finder;
	
	@Override
	public FindColorResponse handle(FindColorQuery query) {
		return finder.invoke(query);
	}

}
