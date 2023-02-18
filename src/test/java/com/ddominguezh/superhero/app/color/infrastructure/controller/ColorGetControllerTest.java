package com.ddominguezh.superhero.app.color.infrastructure.controller;

import static org.junit.Assert.assertTrue;

import java.util.Map;

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

import com.ddominguezh.superhero.app.color.applicattion.useCase.findColor.FindColorResponse;
import com.ddominguezh.superhero.shared.SuperheroApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SuperheroApplication.class)
@AutoConfigureMockMvc
public class ColorGetControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void ping_color_enpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/color")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void get_all_colors() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/color")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn()
				.getResponse()
				.getContentAsString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FindColorResponse colors = gson.fromJson(response, FindColorResponse.class);
		assertTrue(colors.size() > 0);
	}
}
