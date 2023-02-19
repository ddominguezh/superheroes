package com.ddominguezh.superhero.app.hero.application.useCase.updateHero;

import com.ddominguezh.superhero.shared.domain.bus.command.Command;

public class UpdateHeroCommand implements Command {

	private String id;
	private int genderId;
	private int eyeColorId;
	private int hairColorId;
	private String name;
	private int height;
	private int weight;
	public UpdateHeroCommand(String id, int genderId, int eyeColorId, int hairColorId, String name, int height, int weight) {
		this.id = id;
		this.genderId = genderId;
		this.eyeColorId = eyeColorId;
		this.hairColorId = hairColorId;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public String getId() {
		return this.id;
	}
	public int getGenderId() {
		return genderId;
	}
	public int getEyeColorId() {
		return eyeColorId;
	}
	public int getHairColorId() {
		return hairColorId;
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
