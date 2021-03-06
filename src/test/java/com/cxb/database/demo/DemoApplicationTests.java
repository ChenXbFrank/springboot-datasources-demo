package com.cxb.database.demo;

import com.cxb.database.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cxb.database.controller.TestController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoApplicationTests {

	private MockMvc mvc;
	
	@Before
	private void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		 mvc.perform(MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON))
         .andExpect(MockMvcResultMatchers.status().isOk())
         .andDo(MockMvcResultHandlers.print())
         .andReturn();
	}

}
