package com.ddominguezh.superhero.app.hero.infrastructure.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

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
	
	@Test
	public void create_hero_id_bad_format() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + randomAlphabetic(36))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(from(hero))))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void create_hero_name_null() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HeroRequest request = from(hero);
		request.setName(null);
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + hero.id())
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(request)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void create_hero_name_empty() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HeroRequest request = from(hero);
		request.setName("");
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + hero.id())
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(request)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void create_hero_name_max_length() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HeroRequest request = from(hero);
		request.setName(randomAlphabetic(256));
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + hero.id())
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(request)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void create_hero_gender_not_found() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HeroRequest request = from(hero);
		request.setGenderId(Integer.MAX_VALUE);
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + hero.id())
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(request)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void create_hero_eye_color_not_found() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HeroRequest request = from(hero);
		request.setEyeColorId(Integer.MAX_VALUE);
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + hero.id())
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(request)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void create_hero_hair_color_not_found() throws Exception {
		Hero hero = HeroMother.randomHero();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HeroRequest request = from(hero);
		request.setHairColorId(Integer.MAX_VALUE);
		mockMvc.perform(MockMvcRequestBuilders.post("/hero/" + hero.id())
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(gson.toJson(request)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
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
