package com.ddominguezh.superhero.app.hero.domain;

import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroHeight;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroName;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroWeight;
import com.ddominguezh.superhero.shared.domain.Identifier;

public class Hero {

	private HeroId id;
	private HeroName name;
	private HeroHeight height;
	private HeroWeight weight;
	protected Hero() {
		this(new HeroId(), new HeroName(), new HeroHeight(), new HeroWeight());
	}
	protected Hero(
			HeroId id, 
			HeroName name, 
			HeroHeight height, 
			HeroWeight weight) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public static Hero create(String id, String name, int height, int weight) {
		return new Hero(
				HeroId.create(id),
				HeroName.create(name),
				HeroHeight.create(height),
				HeroWeight.create(weight)
			);
	}
	public String id() {
		return this.id.value();
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
