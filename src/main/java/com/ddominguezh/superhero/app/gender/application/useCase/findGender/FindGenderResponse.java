package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ddominguezh.cqrs.shared.domain.bus.query.Response;
import com.ddominguezh.superhero.app.gender.domain.Gender;

public class FindGenderResponse implements Response {

	private List<GenderResponse> genders;
	
	public FindGenderResponse(List<GenderResponse> genders) {
		this.genders = genders;
	}

	public static FindGenderResponse from(List<Gender> genders) {
		List<GenderResponse> gendersResponse = new ArrayList<GenderResponse>();
		if(genders != null) {
			gendersResponse = genders.stream()
					.map(gender -> GenderResponse.from(gender))
					.collect(Collectors.toList());
		}
		return new FindGenderResponse(gendersResponse);
	}

	public List<GenderResponse> getGenders(){
		return this.genders;
	}
	
	public Integer getSize() {
		return this.genders.size();
	}
}
