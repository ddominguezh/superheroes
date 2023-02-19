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

import com.ddominguezh.superhero.app.hero.application.useCase.createHero.CreateHeroCommand;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroColorNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroGenderNotFoundException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroIdFormatException;
import com.ddominguezh.superhero.app.hero.domain.exception.HeroNameFormatException;
import com.ddominguezh.superhero.app.hero.infrastructure.controller.request.HeroRequest;
import com.ddominguezh.superhero.shared.domain.DomainError;
import com.ddominguezh.superhero.shared.domain.bus.command.CommandBus;
import com.ddominguezh.superhero.shared.domain.bus.query.QueryBus;
import com.ddominguezh.superhero.shared.infrastructure.controller.ApiController;

@Controller(value="HeroPostController")
@RequestMapping("hero")
public class HeroPostController  extends ApiController{

	public HeroPostController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@CrossOrigin
	@RequestMapping(
			value = "/{id}",
			method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
		)
	@ResponseBody
	public void index(@PathVariable("id") String id, @RequestBody HeroRequest hero) throws Exception{
		dispatch(
			new CreateHeroCommand(
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

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>(){
			{
				put(HeroIdFormatException.class, HttpStatus.BAD_REQUEST);
				put(HeroNameFormatException.class, HttpStatus.BAD_REQUEST);
				put(HeroGenderNotFoundException.class, HttpStatus.NOT_FOUND);
				put(HeroColorNotFoundException.class, HttpStatus.NOT_FOUND);
			}
		};
	}

}
