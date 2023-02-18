package com.ddominguezh.superhero.app.color.domain.repository;

import java.util.List;

import com.ddominguezh.superhero.app.color.domain.Color;

public interface ColorRepository {

	List<Color> findAll();
	
}
