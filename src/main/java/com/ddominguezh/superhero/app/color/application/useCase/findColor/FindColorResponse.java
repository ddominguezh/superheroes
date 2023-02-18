package com.ddominguezh.superhero.app.color.application.useCase.findColor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.ddominguezh.superhero.app.color.domain.Color;
import com.ddominguezh.superhero.shared.domain.bus.query.Response;

public class FindColorResponse implements Response {

	private List<ColorResponse> colors;
	FindColorResponse(List<ColorResponse> colors){
		this.colors = colors;
	}

	public static FindColorResponse from(List<Color> colors) {
		return new FindColorResponse(
				colors.stream()
					.map(color -> ColorResponse.from(color))
					.collect(Collectors.toList())
				);
	}
	
	public int getSize() {
		return this.colors.size();
	}

	public List<ColorResponse> getColors(){
		return this.colors;
	}
}
