package com.restapi.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getStatusForNumber ()
	  throws Exception {
	    this.mockMvc.perform(get("/api/v1/num_to_english/12345678")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.status").value("Success"));
	    
	    this.mockMvc.perform(get("/api/v1/num_to_english/string")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.status").value("Input parameter is not a number."));
	    
	    this.mockMvc.perform(get("/api/v1/num_to_english/123abc")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.status").value("Input parameter is not a number."));
	    
	    this.mockMvc.perform(get("/api/v1/num_to_english/12345678910111111")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.status").value("Number length cannot be more than 15 numbers long."));
	}
	
	@Test
	public void getNumberToEnglish ()
	  throws Exception {
	    this.mockMvc.perform(get("/api/v1/num_to_english/1")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.numInEnglish").value("One"));
	    
	    this.mockMvc.perform(get("/api/v1/num_to_english/123")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.numInEnglish").value("One Hundred Twenty Three"));
	    
	    this.mockMvc.perform(get("/api/v1/num_to_english/12345678")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.numInEnglish").value("Twelve Million Three Hundred Forty Five Thousand Six Hundred Seventy Eight"));
	}
	
	@Test
	public void getNegativeNumberToEnglish ()
	  throws Exception {
	    this.mockMvc.perform(get("/api/v1/num_to_english/-1")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.numInEnglish").value("Minus One"));
	    
	    this.mockMvc.perform(get("/api/v1/num_to_english/-123")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.numInEnglish").value("Minus One Hundred Twenty Three"));
	    
	    this.mockMvc.perform(get("/api/v1/num_to_english/-12345678")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.numInEnglish").value("Minus Twelve Million Three Hundred Forty Five Thousand Six Hundred Seventy Eight"));
	}
}	
	

