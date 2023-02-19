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

import com.ddominguezh.superhero.app.hero.application.useCase.deleteHero.DeleteHeroCommand;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroIdFormatException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNotFoundException;
import com.ddominguezh.superhero.shared.domain.Authorization;
import com.ddominguezh.superhero.shared.domain.DomainError;
import com.ddominguezh.superhero.shared.domain.bus.command.CommandBus;
import com.ddominguezh.superhero.shared.domain.bus.query.QueryBus;
import com.ddominguezh.superhero.shared.domain.config.annotations.RequestAuthorization;
import com.ddominguezh.superhero.shared.infrastructure.controller.ApiController;

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

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>(){
			{
				put(HeroNotFoundException.class, HttpStatus.NOT_FOUND);
				put(HeroIdFormatException.class, HttpStatus.BAD_REQUEST);
			}
		};
	}

}