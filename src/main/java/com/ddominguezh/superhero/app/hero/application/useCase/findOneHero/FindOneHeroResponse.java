package com.ddominguezh.superhero.app.hero.application.useCase.findOneHero;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindOneHeroResponse implements Response {

	private String id;
	private int genderId;
	private String genderName;
	private int eyeColorId;
	private String eyeColorName;
	private int hairColorId;
	private String hairColorName;
	private String name;
	private int height;
	private int weight;

	protected FindOneHeroResponse(String id, int genderId, String genderName, int eyeColorId, String eyeColorName,
			int hairColorId, String hairColorName, String name, int height, int weight) {
		this.id = id;
		this.genderId = genderId;
		this.genderName = genderName;
		this.eyeColorId = eyeColorId;
		this.eyeColorName = eyeColorName;
		this.hairColorId = hairColorId;
		this.hairColorName = hairColorName;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public static FindOneHeroResponse from(Hero hero) {
		return new FindOneHeroResponse(
				hero.id(),
				hero.genderId(),
				hero.genderName(),
				hero.eyeColorId(),
				hero.eyeColorName(),
				hero.hairColorId(),
				hero.hairColorName(),
				hero.name(),
				hero.height(),
				hero.weight()
			);
	}

	public String getId() {
		return id;
	}

	public int getGenderId() {
		return genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public int getEyeColorId() {
		return eyeColorId;
	}

	public String getEyeColorName() {
		return eyeColorName;
	}

	public int getHairColorId() {
		return hairColorId;
	}

	public String getHairColorName() {
		return hairColorName;
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}
	
}
