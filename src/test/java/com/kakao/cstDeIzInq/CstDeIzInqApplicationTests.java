package com.kakao.cstDeIzInq;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakao.cstDeIzInq.domain.YearSumAmDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CstDeIzInqApplicationTests {


	    @Autowired
	    private WebApplicationContext ctx;
	    private MockMvc mockMvc;

	    @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
	    }

	    @After
	    public void tearDown() throws Exception {
	    }


	    @Test
	    public void yearMostSumAmTest() {
	    try {
         String json = "{'select':'1'}";

	     this.mockMvc.perform(
	                post("/getBaseJsonData")
	                .contentType(MediaType.APPLICATION_JSON).content(json))
	                .andExpect(status().isOk()).andDo(print());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail(e.getMessage());
	        }
	    }
	    @Test
	    public void yearNoDeTest() {
	    try {
         String json = "{'select':'2'}";

	     this.mockMvc.perform(
	                post("/getBaseJsonData")
	                .contentType(MediaType.APPLICATION_JSON).content(json))
	                .andExpect(status().isOk()).andDo(print());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail(e.getMessage());
	        }
	    }
	    @Test
	    public void yearManSumAmTest() {
	    try {
         String json = "{'select':'3'}";

	     this.mockMvc.perform(
	                post("/getBaseJsonData")
	                .contentType(MediaType.APPLICATION_JSON).content(json))
	                .andExpect(status().isOk()).andDo(print());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail(e.getMessage());
	        }
	    }
	    @Test
	    public void manSumAmTest1() {
	    try {
         String json = "{'select':'4','brNm':'강남점'}";

	     this.mockMvc.perform(
	                post("/getBaseJsonData")
	                .contentType(MediaType.APPLICATION_JSON).content(json))
	                .andExpect(status().isOk()).andDo(print());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail(e.getMessage());
	        }
	    }
	    
	    @Test
	    public void manSumAmTest2() {
	    try {
         String json = "{'select':'4','brNm':'분당점'}";

	     this.mockMvc.perform(
	                post("/getBaseJsonData")
	                .contentType(MediaType.APPLICATION_JSON).content(json))
	                .andExpect(status().isOk()).andDo(print());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail(e.getMessage());
	        }
	    }
}
