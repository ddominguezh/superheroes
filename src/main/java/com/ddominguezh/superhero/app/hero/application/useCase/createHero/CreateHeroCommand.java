package com.ddominguezh.superhero.app.hero.application.useCase.createHero;

import com.ddominguezh.superhero.shared.domain.bus.command.Command;

public class CreateHeroCommand implements Command {

	private String id;
	private String name;
	private int height;
	private int weight;
	protected CreateHeroCommand(String id, String name, int height, int weight) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getHeight() {
		return this.height;
	}
	public int getWeight() {
		return this.weight;
	}
}
