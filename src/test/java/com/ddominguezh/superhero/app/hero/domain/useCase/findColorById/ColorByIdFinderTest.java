package com.ddominguezh.superhero.app.hero.domain.useCase.findColorById;

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
import com.ddominguezh.superhero.app.hero.domain.repository.HeroColorRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class ColorByIdFinderTest {

	@InjectMocks
	private ColorByIdFinder finder;
	
	@Mock
	private HeroColorRepository repository;
	
	@Test
	public void get_color() {
		HeroColor color = HeroMother.randomHeroColor();
		when(repository.findById(any(HeroColorId.class))).thenReturn(Optional.of(color));
		HeroColor response = finder.invoke(HeroColorId.create(color.id()));
		assertEquals(color.id(), response.id());
		assertEquals(color.name(), response.name());
	}
}
