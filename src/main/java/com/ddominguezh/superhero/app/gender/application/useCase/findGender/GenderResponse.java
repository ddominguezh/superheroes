package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

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
	
}
