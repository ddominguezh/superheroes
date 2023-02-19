package com.ddominguezh.superhero.app.hero.infrastructure.controller;

import java.util.UUID;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.HeroMother;
import com.ddominguezh.superhero.app.hero.infrastructure.controller.request.HeroRequest;
import com.ddominguezh.superhero.shared.SuperheroApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@AutoConfigureMockMvc
@Transactional
public class HeroPostControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void ping_hero_enpoint() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(from(hero))))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void create_hero() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + hero.id())
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(from(hero))))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private HeroRequest from(Hero hero) {
		HeroRequest request = new HeroRequest();
		request.setGenderId(hero.genderId());
		request.setEyeColorId(hero.eyeColorId());
		request.setHairColorId(hero.hairColorId());
		request.setName(hero.name());
		request.setHeight(hero.height());
		request.setWeight(hero.weight());
		return request;
	}
}
