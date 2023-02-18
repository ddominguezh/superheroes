package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

import com.ddominguezh.superhero.shared.domain.bus.command.Command;

public class CreateHeroCommand implements Command {

	private String id;
	private String name;
	protected CreateHeroCommand(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
}
