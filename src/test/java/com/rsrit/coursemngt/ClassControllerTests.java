	package com.rsrit.coursemngt;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.rsrit.coursemngt.model.Class;
import com.rsrit.coursemngt.service.ClassesService;

//@RunWith(SpringRunner.class)
//@WebMvcTest
public class ClassControllerTests {

	// @InjectMocks
	MockMvc webMvc;

	// @MockBean
	ClassesService service;
//	Class addClass = new Class(1.0,"java",2.0 ,"Anupama",[1.0],Timestamp.from(Instant.now()),2,null,null );
	 @Test
	public void getClassesShouldReturnClasses() throws Exception {
		when(service.getClassByName(Mockito.anyString()))
				.thenReturn(new Class(1l ,"java",20l ,"Sandeep",Arrays.asList(new Long[]{1l,2l,3l}),Timestamp.from(Instant.now()) ,2 ,null, null));
 
		MvcResult result = webMvc.perform(get("/classes")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("className", containsString("java"))).andReturn();

	}

	// @Test
	public void getClassbyId() throws Exception {
		when(service.getClassById(Mockito.anyInt()))
				.thenReturn(new Class(1l ,"java",20l ,"Sandeep",Arrays.asList(new Long[]{1l,2l,3l}),Timestamp.from(Instant.now()) ,2 ,null, null));

		// webMvc.perform(get("/classes/{id}")).andDo(print()).andExpect(status().isOk()).andExpect((ResultMatcher)
		// jsonPath("classId")
	}

}
