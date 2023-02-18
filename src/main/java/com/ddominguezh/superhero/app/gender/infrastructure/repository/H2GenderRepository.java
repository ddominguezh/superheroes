package com.ddominguezh.superhero.app.gender.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ddominguezh.superhero.app.gender.domain.Gender;
import com.ddominguezh.superhero.app.gender.domain.repository.GenderRepository;

@Repository
public class H2GenderRepository implements GenderRepository {

	@Override
	public List<Gender> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
