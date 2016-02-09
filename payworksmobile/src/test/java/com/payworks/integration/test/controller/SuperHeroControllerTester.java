package com.payworks.integration.test.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.paywork.utils.Constants;
import com.payworks.boot.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SuperHeroControllerTester {

	private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

	/**
	 * Test /create route
	 * @throws Exception
	 */
	@Test
	public void createSuperHero() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/create").contentType(MediaType.APPLICATION_JSON).content(Constants.createHero))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("SuperHero added!")); 
		
	}
	
	/**
	 * Test /heroes route
	 * @throws Exception
	 */
	@Test
	public void superHeroes() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/heroes").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(Constants.heroes));
		
	}
	
	/**
	 * Test /hero route
	 * @throws Exception
	 */
	@Test
	public void getHero() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hero").param("name", "Batman").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(Constants.hero));
	}
	
	
}
