package com.stackroute.products.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import com.stackroute.products.config.HibernateConfig;
import com.stackroute.products.model.Product;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes=HibernateConfig.class)
@TestExecutionListeners( {DependencyInjectionTestExecutionListener.class,TransactionalTestExecutionListener.class})


public class ProductDAOTest {
	
	@Autowired
	SessionFactory sessfact;
	
	ProductDAO productdao;
	
	Product product;
	
	@Before
	public void init() throws Exception
	{
		productdao=new ProductDAOImpl(sessfact);
		
		product=new Product();
		product.setProductid(6000);
		product.setPname("UPS-Polo");
		product.setPrice(25000);
		
	}
	
	
	@Test
	public void whenaddProductitshouldbeStroed()
	{
		Product prdresult=productdao.addProduct(product);
		
		Product prdfind=productdao.findByProductid(6000);
		
		Assert.assertEquals(prdresult, prdfind);
	}
	
  @Test
  public void deleteproductGivenProductid()
  {
	  boolean result=productdao.deleteProduct(6000);
	  
	  Product prd=productdao.findByProductid(6000);
	  
	  Assert.assertEquals(prd, null);
  }
	
}
