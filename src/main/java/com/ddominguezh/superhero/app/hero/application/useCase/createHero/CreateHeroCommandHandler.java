package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddominguezh.superhero.shared.domain.bus.command.CommandHandler;

@ManagedBean
public class CreateHeroCommandHandler implements CommandHandler<CreateHeroCommand> {

	@Autowired
	private HeroCreator creator;
	
	@Override
	public void handle(CreateHeroCommand command) {
		creator.invoke(command);
	}

}
