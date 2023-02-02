package com.example.calculadora;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.loader.WebappLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.WebApplicationContext;

import com.example.calculadora.servicios.CalculadoraServiceImpl;

@SpringBootTest(classes = CalculadoraApplication.class ,webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculadoraApplicationTests {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
	
	
	@Test
	public void post_suma() throws Exception
	{
		MvcResult result = this.mockMvc.perform(post("/api/ejecuta?num1=1&num2=2&operacion=+")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		assertEquals("3.0", result.getResponse().getContentAsString());
	}
	
	@Test
	public void post_resta() throws Exception
	{
		MvcResult result = this.mockMvc.perform(post("/api/ejecuta?num1=2&num2=1&operacion=-")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		assertEquals("1.0", result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void post_bad_param() throws Exception
	{
		MvcResult result = this.mockMvc.perform(post("/api/ejecuta?op1=2&num2=1&operacion=-")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException );
	
		
		result = this.mockMvc.perform(post("/api/ejecuta?num1=2&op2=1&operacion=-")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException );
	
		
		result = this.mockMvc.perform(post("/api/ejecuta?op1=2&op2=1&op=-")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException );
	}
	
	

}
