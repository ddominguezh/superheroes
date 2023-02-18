package com.ddominguezh.superhero.app.gender.application.useCase.findGender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.gender.domain.Gender;
import com.ddominguezh.superhero.app.gender.domain.GenderMother;
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
	
	@Test
	public void get_all_genders() {
		List<Gender> genders = GenderMother.randomGenders();
		when(repository.findAll()).thenReturn(genders);
		FindGenderResponse response = finder.invoke(new FindGenderQuery());
		assertEquals(genders.size(), response.getSize());
		for(int i = 0 ; i < response.getSize() ; i++ ) {
			Gender gender = genders.get(i);
			GenderResponse genderResponse = response.getGenders().get(i);
			assertEquals(gender.id(), genderResponse.getId());
			assertEquals(gender.name(), genderResponse.getName());
		}
	}
}
