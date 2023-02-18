package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

import java.util.List;

import com.ddominguezh.superhero.app.gender.domain.Gender;
import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindGenderResponse implements Response {

	public Integer getSize() {
		return 0;
	}

	public static FindGenderResponse from(List<Gender> findAll) {
		// TODO Auto-generated method stub
		return null;
	}

}
