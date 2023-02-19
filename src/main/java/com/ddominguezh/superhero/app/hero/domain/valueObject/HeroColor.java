package com.ddominguezh.superhero.app.hero.domain.valueObject;

public class HeroColor {

	private HeroColorId id;
	private HeroColorName name;
	public HeroColor() {
		this(new HeroColorId(), new HeroColorName());
	}
	protected HeroColor(HeroColorId id, HeroColorName name) {
		this.id = id;
		this.name = name;
	}
	public static HeroColor create(int id, String name) {
		return new HeroColor(
				HeroColorId.create(id), 
				HeroColorName.create(name)
			);
	}
	public int id() {
		return this.id.value();
	}
	public String name() {
		return this.name.value();
	}
}
