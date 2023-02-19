package com.ddominguezh.superhero.app.hero.infrastructure.controller;

import java.util.HashMap;

import javax.ws.rs.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddominguezh.superhero.app.hero.application.useCase.findHero.FindHeroResponse;
import com.ddominguezh.superhero.app.hero.application.useCase.findOneHero.FindOneHeroQuery;
import com.ddominguezh.superhero.shared.domain.DomainError;
import com.ddominguezh.superhero.shared.domain.bus.command.CommandBus;
import com.ddominguezh.superhero.shared.domain.bus.query.QueryBus;
import com.ddominguezh.superhero.shared.infrastructure.controller.ApiController;

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
	public FindHeroResponse index(@RequestParam(value = "name", defaultValue = "") String name) throws Exception{
		return null;
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>();
	}
}
