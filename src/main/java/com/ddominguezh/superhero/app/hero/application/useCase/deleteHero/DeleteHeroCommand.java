package com.ddominguezh.superhero.app.hero.application.useCase.deleteHero;

import com.ddominguezh.cqrs.shared.domain.bus.command.Command;

public class DeleteHeroCommand implements Command {

	private String id;
	public DeleteHeroCommand(String id){
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
}
