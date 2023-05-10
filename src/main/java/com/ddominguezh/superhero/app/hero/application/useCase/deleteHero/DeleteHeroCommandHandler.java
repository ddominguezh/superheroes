package com.ddominguezh.superhero.app.hero.application.useCase.deleteHero;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddominguezh.cqrs.shared.domain.bus.command.CommandHandler;

@ManagedBean
public class DeleteHeroCommandHandler implements CommandHandler<DeleteHeroCommand>{

	@Autowired
	private HeroDeleter deleter;
	
	@Override
	public void handle(DeleteHeroCommand command) {
		deleter.invoke(command);
	}

}
