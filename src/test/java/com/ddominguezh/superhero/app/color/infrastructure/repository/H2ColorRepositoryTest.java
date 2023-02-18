package com.ddominguezh.superhero.app.color.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.color.domain.Color;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class H2ColorRepositoryTest {

	@Autowired
	private H2ColorRepository repository;
	
	@Test
	public void get_all_colors() {
		List<Color> colors = repository.findAll();
		assertEquals(6, colors.size());
	}
}
