package com.ddominguezh.superhero.app.color.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ddominguezh.superhero.app.color.domain.Color;
import com.ddominguezh.superhero.app.color.domain.repository.ColorRepository;

@Repository
public class H2ColorRepository implements ColorRepository{

	@Override
	public List<Color> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
