package com.ddominguezh.superhero.app.hero.application.useCase.updateHero;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddominguezh.superhero.shared.domain.bus.command.CommandHandler;

@ManagedBean
public class UpdateHeroCommandHandler implements CommandHandler<UpdateHeroCommand> {

	@Autowired
	private HeroUpdater updater;
	
	@Override
	public void handle(UpdateHeroCommand command) {
		updater.invoke(command);
	}

}
