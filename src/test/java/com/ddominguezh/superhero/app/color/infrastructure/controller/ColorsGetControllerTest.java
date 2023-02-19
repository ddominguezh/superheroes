package com.ddominguezh.superhero.app.color.infrastructure.controller;

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

import com.ddominguezh.superhero.app.color.application.useCase.findColor.ColorResponse;
import com.ddominguezh.superhero.app.color.application.useCase.findColor.FindColorResponse;
import com.ddominguezh.superhero.app.color.domain.Color;
import com.ddominguezh.superhero.shared.SuperheroApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@AutoConfigureMockMvc
public class ColorsGetControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void ping_color_endpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/color/all")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.header("Authorization", "Bearer MTIzYTRkZjgtYjA2OS0xMWVkLWFmYTEtMDI0MmFjMTIwMDAy"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void color_endpoint_unauthorized() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/color/all")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.header("Authorization", "Bearer MTIzYTRkZjgtYjA2OS0xMWVkLWFmYTEtMDI0MmFjMTIwMDAdy"))
				.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}
	
	@Test
	public void get_all_colors() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/color/all")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.header("Authorization", "Bearer MTIzYTRkZjgtYjA2OS0xMWVkLWFmYTEtMDI0MmFjMTIwMDAy"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn()
				.getResponse()
				.getContentAsString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FindColorResponse colors = gson.fromJson(response, FindColorResponse.class);
		
		List<ColorResponse> expected = new ArrayList<ColorResponse>() {
			{
				add(ColorResponse.from(Color.create(1, "blue")));
				add(ColorResponse.from(Color.create(2, "green")));
				add(ColorResponse.from(Color.create(3, "yellow")));
				add(ColorResponse.from(Color.create(4, "black")));
				add(ColorResponse.from(Color.create(5, "white")));
				add(ColorResponse.from(Color.create(6, "red")));
			}
		};
		
		assertEquals(expected.size(), colors.getSize());
		for(int i = 0 ; i < expected.size() ; i++) {
			assertEquals(expected.get(i), colors.getColors().get(i));
		}
	}
}
