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

import com.ddominguezh.superhero.app.gender.application.useCase.findGender.FindGenderResponse;
import com.ddominguezh.superhero.app.hero.application.useCase.findOneHero.FindOneHeroQuery;
import com.ddominguezh.superhero.app.hero.application.useCase.findOneHero.FindOneHeroResponse;
import com.ddominguezh.superhero.shared.SuperheroApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@AutoConfigureMockMvc
public class HeroGetControllerTest {

	private static final String heroId = "7f675eca-afbf-11ed-afa1-0242ac120002";
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void ping_hero_enpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hero/" + heroId)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void get_hero() throws UnsupportedEncodingException, Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/hero/" + heroId)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn()
				.getResponse()
				.getContentAsString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FindOneHeroResponse hero = gson.fromJson(response, FindOneHeroResponse.class);
		assertEquals(heroId, hero.getId());
	}
}
