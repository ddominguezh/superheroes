package com.ddominguezh.superhero.app.gender.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.gender.domain.Gender;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class H2GenderRepositoryTest {

	@Autowired
	private H2GenderRepository repository;
	
	@Test
	public void get_all_genders() {
		List<Gender> genders = repository.findAll();
		assertEquals(4, genders.size());
	}
}
