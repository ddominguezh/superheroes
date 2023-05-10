package com.ddominguezh.superhero.app.hero.infrastructure.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddominguezh.cqrs.client.shared.infrastructure.controller.ApiController;
import com.ddominguezh.cqrs.shared.domain.bus.command.CommandBus;
import com.ddominguezh.cqrs.shared.domain.bus.query.QueryBus;
import com.ddominguezh.spring.core.shared.domain.Authorization;
import com.ddominguezh.spring.core.shared.domain.DomainError;
import com.ddominguezh.spring.core.shared.domain.config.annotations.RequestAuthorization;
import com.ddominguezh.spring.core.shared.domain.exception.AuthorizationException;
import com.ddominguezh.superhero.app.hero.application.useCase.findHero.FindHeroQuery;
import com.ddominguezh.superhero.app.hero.application.useCase.findHero.FindHeroResponse;

@Controller(value="HeroesGetController")
@RequestMapping("hero")
public class HeroesGetController extends ApiController {

	public HeroesGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@CrossOrigin
	@RequestMapping(
			value = "/search",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
		)
	@ResponseBody
	public FindHeroResponse index(@RequestParam(value = "name", defaultValue = "") String name, @RequestAuthorization Authorization authorization) throws Exception{
		return ask(new FindHeroQuery(name));
	}

	@SuppressWarnings("serial")
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(AuthorizationException.class, HttpStatus.UNAUTHORIZED);
			}
		};
	}
}
