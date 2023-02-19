package com.ddominguezh.superhero.app.hero.infrastructure.controller.request;

public class HeroRequest {

	private int genderId;
	private int eyeColorId;
	private int hairColorId;
	private String name;
	private int height;
	private int weight;
	public int getGenderId() {
		return genderId;
	}
	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}
	public int getEyeColorId() {
		return eyeColorId;
	}
	public void setEyeColorId(int eyeColorId) {
		this.eyeColorId = eyeColorId;
	}
	public int getHairColorId() {
		return hairColorId;
	}
	public void setHairColorId(int hairColorId) {
		this.hairColorId = hairColorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
