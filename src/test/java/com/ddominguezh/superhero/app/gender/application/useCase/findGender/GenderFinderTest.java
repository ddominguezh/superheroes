package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.color.application.useCase.findColor.FindColorQuery;
import com.ddominguezh.superhero.app.color.application.useCase.findColor.FindColorResponse;
import com.ddominguezh.superhero.app.color.domain.Color;
import com.ddominguezh.superhero.app.gender.domain.Gender;
import com.ddominguezh.superhero.app.gender.domain.repository.GenderRepository;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class GenderFinderTest {

	@InjectMocks
	private GenderFinder finder;
	
	@Mock
	private GenderRepository repository;
	
	@Test
	public void get_empty_gender_list() {
		when(repository.findAll()).thenReturn(new ArrayList<Gender>());
		FindGenderResponse response = finder.invoke(new FindGenderQuery());
		assertEquals(0, response.getSize());
	}
	
	@Test
	public void get_emtpy_gender_list_when_retun_null() {
		when(repository.findAll()).thenReturn(null);
		FindGenderResponse response = finder.invoke(new FindGenderQuery());
		assertEquals(0, response.getSize());
	}
	
}
