package com.ddominguezh.superhero.app.hero.infrastructure.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddominguezh.cqrs.client.shared.infrastructure.controller.ApiController;
import com.ddominguezh.cqrs.shared.domain.bus.command.CommandBus;
import com.ddominguezh.cqrs.shared.domain.bus.query.QueryBus;
import com.ddominguezh.spring.core.shared.domain.Authorization;
import com.ddominguezh.spring.core.shared.domain.DomainError;
import com.ddominguezh.spring.core.shared.domain.config.annotations.RequestAuthorization;
import com.ddominguezh.spring.core.shared.domain.exception.AuthorizationException;
import com.ddominguezh.superhero.app.hero.application.useCase.deleteHero.DeleteHeroCommand;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroIdFormatException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNotFoundException;

@Controller(value="HeroDeleteController")
@RequestMapping("hero")
public class HeroDeleteController extends ApiController{

	public HeroDeleteController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@CrossOrigin
	@RequestMapping(
			value = "/{id}",
			method=RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE
		)
	@ResponseBody
	public void index(@PathVariable("id") String id, @RequestAuthorization Authorization authorization) throws Exception{
		dispatch(new DeleteHeroCommand(id));
	}

	@SuppressWarnings("serial")
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>(){
			{
				put(HeroNotFoundException.class, HttpStatus.NOT_FOUND);
				put(HeroIdFormatException.class, HttpStatus.BAD_REQUEST);
				put(AuthorizationException.class, HttpStatus.UNAUTHORIZED);
			}
		};
	}

}