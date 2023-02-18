package com.ddominguezh.superhero.app.color.domain;

import com.ddominguezh.superhero.app.color.domain.valueObject.ColorId;
import com.ddominguezh.superhero.app.color.domain.valueObject.ColorName;

public class Color {

	private ColorId id;
	private ColorName name;
	Color(ColorId id, ColorName name){
		this.id = id;
		this.name = name;
	}
	public static Color create(int id, String name) {
		return new Color(
				ColorId.create(id), 
				ColorName.create(name)
			);
	}
	public int getId() {
		return this.id.getValue();
	}
	public String getName() {
		return this.name.getValue();
	}
}
