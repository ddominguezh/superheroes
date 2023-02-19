package com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddominguezh.superhero.app.hero.domain.HeroMother;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroGenderRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class GenderByIdFinderTest {

	@InjectMocks
	private GenderByIdFinder finder;
	
	@Mock
	private HeroGenderRepository repository;
	
	@Test
	public void get_gender() {
		HeroGender gender = HeroMother.randomHeroGender();
		when(repository.findById(any(HeroGenderId.class))).thenReturn(Optional.of(gender));
		HeroGender response = finder.invoke(HeroGenderId.create(gender.id()));
		assertEquals(gender.id(), response.id());
		assertEquals(gender.name(), response.name());
	}
}
