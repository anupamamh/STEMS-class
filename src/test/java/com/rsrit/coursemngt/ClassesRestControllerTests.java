package com.rsrit.coursemngt;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import com.rsrit.coursemngt.model.Classes;
import com.rsrit.coursemngt.service.ClassesService;

//@RunWith(SpringRunner.class)
//@WebMvcTest
public class ClassesRestControllerTests {

	//@InjectMocks
	MockMvc webMvc;

	//@MockBean
	ClassesService service;

	//@Test
	public void getClassesShouldReturnClasses() throws Exception {
		when(service.getClassByName(Mockito.anyString()))
				.thenReturn(new Classes(1, "java", 20, null, null, null, null, null, null));

		MvcResult result = webMvc.perform(get("/classes")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("className", containsString("java"))).andReturn();

	}
	
	//@Test
	public void getClassbyId() throws Exception {
		when(service.getClassById(Mockito.anyInt())).thenReturn(new Classes(1, "java", 20, null, null, null, null, null, null));
		
//		webMvc.perform(get("/classes/{id}")).andDo(print()).andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("classId")
	}

}
