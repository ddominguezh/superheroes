package com.ddominguezh.superhero.app.gender.domain;

import com.ddominguezh.superhero.app.gender.domain.valueObject.GenderId;
import com.ddominguezh.superhero.app.gender.domain.valueObject.GenderName;

public class Gender {

	private GenderId id;
	private GenderName name;
	public Gender() {
		this(
			new GenderId(), 
			new GenderName()
		);
	}
	protected Gender(GenderId id, GenderName name) {
		this.id = id;
		this.name = name;
	}
	public static Gender create(int id, String name) {
		return new Gender(
				GenderId.create(id), 
				GenderName.create(name)	
			);
	}
	public int id() {
		return this.id.value();
	}
	public String name() {
		return this.name.value();
	}
}
