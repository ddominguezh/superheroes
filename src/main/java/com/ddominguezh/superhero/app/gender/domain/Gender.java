package com.ddominguezh.superhero.app.gender.domain;

import com.ddominguezh.superhero.app.gender.domain.valueObject.GenderId;
import com.ddominguezh.superhero.app.gender.domain.valueObject.GenderName;
import com.ddominguezh.superhero.shared.domain.IntValueObject;
import com.ddominguezh.superhero.shared.domain.StringValueObject;

public class Gender {

	private GenderId id;
	private GenderName name;
	protected Gender() {
		this(
			GenderId.create(IntValueObject.Empty()), 
			GenderName.create(StringValueObject.Empty())
		);
	}
	protected Gender(GenderId id, GenderName name) {
		this.id = id;
		this.name = name;
	}
	public static Gender create(int id, String name) {
		return new Gender(
				GenderId.create(IntValueObject.Empty()), 
				GenderName.create(StringValueObject.Empty())	
			);
	}
	public int id() {
		return this.id.value();
	}
	public String name() {
		return this.name.value();
	}
}
