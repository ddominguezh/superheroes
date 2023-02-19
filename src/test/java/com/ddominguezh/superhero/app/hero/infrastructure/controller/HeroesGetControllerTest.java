package com.ddominguezh.superhero.app.hero.infrastructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.superhero.app.hero.application.useCase.findHero.FindHeroResponse;
import com.ddominguezh.superhero.shared.SuperheroApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@AutoConfigureMockMvc
@Transactional
public class HeroesGetControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void ping_heroes_enpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hero/search")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void get_all_heroes() throws UnsupportedEncodingException, Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/hero/search")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn()
				.getResponse()
				.getContentAsString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FindHeroResponse heroes = gson.fromJson(response, FindHeroResponse.class);
		assertEquals(3, heroes.getSize());
	}
	
	@Test
	public void get_heroes_filter_by_name() throws UnsupportedEncodingException, Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/hero/search?name=man")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn()
				.getResponse()
				.getContentAsString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FindHeroResponse heroes = gson.fromJson(response, FindHeroResponse.class);
		assertEquals(2, heroes.getSize());
	}
}
