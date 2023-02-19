package com.ddominguezh.superhero.app.hero.domain.valueObject;

public class HeroGender {

	private HeroGenderId id;
	private HeroGenderName name;
	public HeroGender() {
		this(new HeroGenderId(), new HeroGenderName());
	}
	protected HeroGender(HeroGenderId id, HeroGenderName name) {
		this.id = id;
		this.name = name;
	}
	public static HeroGender create(int id, String name) {
		return new HeroGender(
				HeroGenderId.create(id), 
				HeroGenderName.create(name)
			);
	}
	public int id() {
		return this.id.value();
	}
	public String name() {
		return this.name.value();
	}
}
