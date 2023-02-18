package com.ddominguezh.superhero.app.color.application.useCase.findColor;

import com.ddominguezh.superhero.app.color.domain.Color;

public class ColorResponse {

	private int id;
	private String name;
	ColorResponse(int id, String name){
		this.id = id;
		this.name = name;
	}
	public static ColorResponse from(Color color) {
		return new ColorResponse(color.id(), color.name());
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
