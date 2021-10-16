package com.example.songr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc




class SongrApplicationTests {
	Album album ;
	/*
    Test initializing with constructor
     */
	@Test
	void contextLoads() {
		album = new Album("Hi", "test", 15, 15000, "fusses.com");
		Assertions.assertNotNull(album);

	}

	/*
	Test getter and setter
	 */

	@Test
	void testGetSet() {
		album = new Album("test", "test", 15, 15000, "fusses.com");
		Assertions.assertEquals(15000 , album.getLength());
		album.setLength(10000);
		Assertions.assertEquals(10000 , album.getLength());
	}

	@Autowired
	private MockMvc mockMvc;


	@Test
	void helloWorldIntegrationTest() throws Exception {

		mockMvc.perform(get("/hello")
						.param("name", "Hatem"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("text/html;charset=UTF-8"));

	}






}
