package com.ddominguezh.superhero.app.color.application.useCase.findColor;

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

import com.ddominguezh.superhero.app.color.domain.Color;
import com.ddominguezh.superhero.app.color.domain.ColorMother;
import com.ddominguezh.superhero.app.color.domain.repository.ColorRepository;
import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
public class ColorFinderTest {

	@InjectMocks
	private ColorFinder finder;
	
	@Mock
	private ColorRepository repository;
	
	@Test
	public void get_empty_color_list() {
		when(repository.findAll()).thenReturn(new ArrayList<Color>());
		FindColorResponse response = finder.invoke(new FindColorQuery());
		assertEquals(0, response.getSize());
	}
	
	@Test
	public void get_emtpy_color_list_when_retun_null() {
		when(repository.findAll()).thenReturn(null);
		FindColorResponse response = finder.invoke(new FindColorQuery());
		assertEquals(0, response.getSize());
	}
	
	@Test
	public void get_all_colors() {
		List<Color> colors = ColorMother.randomColors();
		when(repository.findAll()).thenReturn(colors);
		FindColorResponse response = finder.invoke(new FindColorQuery());
		assertEquals(colors.size(), response.getSize());
		for(int i = 0 ; i < response.getSize() ; i++ ) {
			Color color = colors.get(i);
			ColorResponse colorResponse = response.getColors().get(i);
			assertEquals(color.getId(), colorResponse.getId());
			assertEquals(color.getName(), colorResponse.getName());
		}
	}
}
