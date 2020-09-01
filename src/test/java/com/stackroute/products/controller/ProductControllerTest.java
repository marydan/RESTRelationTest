package com.stackroute.products.controller;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.products.config.HibernateConfig;
import com.stackroute.products.model.Product;
import com.stackroute.products.service.ProductService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {HibernateConfig.class})
@WebAppConfiguration

public class ProductControllerTest {

	MockMvc mockmvc;
	
	@Mock
	ProductService productservice;
	
	@InjectMocks
	ProductController productcontrol;
	
	Product product;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		mockmvc=MockMvcBuilders.standaloneSetup(productcontrol).build();
		product=new Product();
		product.setProductid(12345);
		product.setPname("Smart Phone");
		product.setPrice(8000);
	}
	
	
	@Test
	public void addUrlshouldreturnOk() throws Exception
	{
		
		mockmvc.perform(MockMvcRequestBuilders.post("/ust/product/addProduct")
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonConvert(product)))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andDo(MockMvcResultHandlers.print());
						
			
	}
	
	public String jsonConvert(Object obj) throws JsonProcessingException 
	{
		String result;
		
		ObjectMapper objmap=new ObjectMapper();
		
		result=objmap.writeValueAsString(obj);
		
		return result;
		
	}
	
	
	
	
	
}
