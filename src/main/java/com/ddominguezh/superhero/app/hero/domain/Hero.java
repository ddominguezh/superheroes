package com.ddominguezh.superhero.app.hero.domain;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroHeight;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroName;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroWeight;

public class Hero {

	private HeroId id;
	private HeroGender gender;
	private HeroColor eyeColor;
	private HeroColor hairColor;
	private HeroName name;
	private HeroHeight height;
	private HeroWeight weight;
	protected Hero() {
		this(
			new HeroId(), 
			new HeroGender(),
			new HeroColor(),
			new HeroColor(),
			new HeroName(), 
			new HeroHeight(), 
			new HeroWeight()
		);
	}
	protected Hero(
			HeroId id, 
			HeroGender gender,
			HeroColor eyeColor,
			HeroColor hairColor,
			HeroName name, 
			HeroHeight height, 
			HeroWeight weight) {
		this.id = id;
		this.gender = gender;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public static Hero create(
			String id, 
			int genderId,
			String genderName,
			int eyeColorId,
			String eyeColorName,
			int hairColorId,
			String hairColorName,
			String name, 
			int height, 
			int weight) {
		return new Hero(
				HeroId.create(id),
				HeroGender.create(genderId, genderName),
				HeroColor.create(eyeColorId, eyeColorName),
				HeroColor.create(hairColorId, hairColorName),
				HeroName.create(name),
				HeroHeight.create(height),
				HeroWeight.create(weight)
			);
	}
	public String id() {
		return this.id.value();
	}
	public int genderId() {
		return this.gender.id();
	}
	public String genderName() {
		return this.gender.name();
	}
	public int eyeColorId() {
		return this.eyeColor.id();
	}
	public String eyeColorName() {
		return this.eyeColor.name();
	}
	public int hairColorId() {
		return this.hairColor.id();
	}
	public String hairColorName() {
		return this.hairColor.name();
	}
	public String name() {
		return this.name.value();
	}
	public int height() {
		return this.height.value();
	}
	public int weight() {
		return this.weight.value();
	}
}
