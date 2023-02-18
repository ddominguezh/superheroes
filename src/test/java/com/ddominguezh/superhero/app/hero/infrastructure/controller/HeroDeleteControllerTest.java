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

import com.ddominguezh.superhero.shared.SuperheroApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@AutoConfigureMockMvc
@Transactional
public class HeroDeleteControllerTest {

	private static final String heroId = "7f675eca-afbf-11ed-afa1-0242ac120002";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void ping_hero_enpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/hero/" + heroId)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void delete_hero() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/hero/" + heroId)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
		mockMvc.perform(MockMvcRequestBuilders.delete("/hero/" + heroId)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void hero_not_found() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/hero/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void delete_hero_bad_request() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/hero/" + randomAlphabetic(36))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
}
