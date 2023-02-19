package com.ddominguezh.superhero.app.gender.infrastructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
import com.ddominguezh.superhero.app.gender.application.useCase.findGender.GenderResponse;
import com.ddominguezh.superhero.app.gender.domain.Gender;
import com.ddominguezh.superhero.shared.SuperheroApplication;
import com.ddominguezh.superhero.shared.infrastructure.controller.WithAuthorizationController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@AutoConfigureMockMvc
public class GendersGetControllerTest extends WithAuthorizationController {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void ping_gender_endpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/gender/all")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.header("Authorization", authorizedToken()))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void gender_endpoint_unauthorized() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/gender/all")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.header("Authorization", unauthorizedToken()))
				.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}
	
	@Test
	public void get_all_genders() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/gender/all")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.header("Authorization", authorizedToken()))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn()
				.getResponse()
				.getContentAsString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FindGenderResponse genders = gson.fromJson(response, FindGenderResponse.class);
		
		List<GenderResponse> expected = new ArrayList<GenderResponse>() {
			{
				add(GenderResponse.from(Gender.create(1, "UNDEFINED")));
				add(GenderResponse.from(Gender.create(2, "WOMEN")));
				add(GenderResponse.from(Gender.create(3, "MEN")));
				add(GenderResponse.from(Gender.create(4, "TRANSGENDER")));
			}
		};
		
		assertEquals(expected.size(), genders.getSize());
		for(int i = 0 ; i < expected.size() ; i++) {
			assertEquals(expected.get(i), genders.getGenders().get(i));
		}
	}
}
