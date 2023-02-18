package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

import java.util.Objects;

import com.ddominguezh.superhero.app.gender.domain.Gender;

public class GenderResponse {

	private int id;
	private String name;
	GenderResponse(int id, String name){
		this.id = id;
		this.name = name;
	}
	public static GenderResponse from(Gender gender) {
		return new GenderResponse(gender.id(), gender.name());
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
		GenderResponse other = (GenderResponse) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	
}
