package com.ddominguezh.superhero.app.color.domain;

import com.ddominguezh.superhero.app.color.domain.valueObject.ColorId;
import com.ddominguezh.superhero.app.color.domain.valueObject.ColorName;
import com.ddominguezh.superhero.shared.domain.IntValueObject;
import com.ddominguezh.superhero.shared.domain.StringValueObject;

public class Color {

	private ColorId id;
	private ColorName name;
	public Color(){
		this(
			new ColorId(), 
			new ColorName()
		);
	}
	protected Color(ColorId id, ColorName name){
		this.id = id;
		this.name = name;
	}
	public static Color create(int id, String name) {
		return new Color(
				ColorId.create(id), 
				ColorName.create(name)
			);
	}
	public int id() {
		return this.id.value();
	}
	public String name() {
		return this.name.value();
	}
}
