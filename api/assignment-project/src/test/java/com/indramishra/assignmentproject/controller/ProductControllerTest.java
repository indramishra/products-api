package com.indramishra.assignmentproject.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.indramishra.assignmentproject.model.Product;
import com.indramishra.assignmentproject.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private ProductService service;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Test
	public void findAllProductTest() throws Exception {
		when(service.findAllProduct()).thenReturn(Arrays.asList(new Product(1L, "mobile", 15000, 6, "c1"),
				new Product(2L, "mouse", 1500, 6, "c2")));
		
		
		MvcResult result = mockMvc.perform(get("/getProducts").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().json("[{proctId: 1,productName: mobile,productPrice: 15000,productQuantity: 6,category: c1}, {proctId: 2,productName: mouse,productPrice: 1500,productQuantity: 6,category: c2}]"))
				.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		
		
		assertTrue(resultContent.isEmpty() == Boolean.FALSE);
	}

}
