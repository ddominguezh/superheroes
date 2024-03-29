package com.ddominguezh.superhero.app.hero.infrastructure.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.ddominguezh.superhero.app.hero.application.useCase.updateHero.UpdateHeroCommand;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroColorNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroGenderNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroIdFormatException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNameFormatException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNotFoundException;
import com.ddominguezh.superhero.app.hero.infrastructure.controller.request.HeroRequest;

@Controller(value="HeroPutController")
@RequestMapping("hero")
public class HeroPutController extends ApiController{

	public HeroPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@CrossOrigin
	@RequestMapping(
			value = "/{id}",
			method=RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE
		)
	@ResponseBody
	public void index(@PathVariable("id") String id, @RequestBody HeroRequest hero, @RequestAuthorization Authorization authorization) throws Exception{
		dispatch(
				new UpdateHeroCommand(
					id,
					hero.getGenderId(),
					hero.getEyeColorId(),
					hero.getHairColorId(),
					hero.getName(),
					hero.getHeight(),
					hero.getWeight()
				)
			);
	}

	@SuppressWarnings("serial")
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>(){
			{
				put(HeroNotFoundException.class, HttpStatus.NOT_FOUND);
				put(HeroIdFormatException.class, HttpStatus.BAD_REQUEST);
				put(HeroNameFormatException.class, HttpStatus.BAD_REQUEST);
				put(HeroGenderNotFoundException.class, HttpStatus.NOT_FOUND);
				put(HeroColorNotFoundException.class, HttpStatus.NOT_FOUND);
				put(AuthorizationException.class, HttpStatus.UNAUTHORIZED);
			}
		};
	}

}
