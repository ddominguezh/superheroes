package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

import java.util.List;
import java.util.stream.Collectors;

import com.ddominguezh.superhero.app.gender.domain.Gender;
import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindGenderResponse implements Response {

	private List<GenderResponse> genders;
	
	public FindGenderResponse(List<GenderResponse> genders) {
		this.genders = genders;
	}

	public static FindGenderResponse from(List<Gender> genders) {
		return new FindGenderResponse(
				genders.stream()
					.map(gender -> GenderResponse.from(gender))
					.collect(Collectors.toList())
			);
	}

	public List<GenderResponse> getGenders(){
		return this.genders;
	}
	
	public Integer getSize() {
		return this.genders.size();
	}
}
