package com.ddominguezh.superhero.app.gender.domain.repository;

import java.util.List;

import com.ddominguezh.superhero.app.gender.domain.Gender;

public interface GenderRepository {

	List<Gender> findAll();
	
}
