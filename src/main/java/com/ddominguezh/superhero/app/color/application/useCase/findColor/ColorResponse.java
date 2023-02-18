package com.ddominguezh.superhero.app.color.application.useCase.findColor;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorResponse other = (ColorResponse) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
}
