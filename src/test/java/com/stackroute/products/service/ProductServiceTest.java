package com.stackroute.products.service;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.products.dao.ProductDAO;
import com.stackroute.products.exceptions.ProductAlreadyExistException;
import com.stackroute.products.exceptions.ProductNotFoundException;
import com.stackroute.products.model.Product;

public class ProductServiceTest {
	
@Mock
ProductDAO daoobj;


@InjectMocks
ProductServiceImpl serviceobj;

Product product;

@Before
public void init() throws Exception
{
	MockitoAnnotations.initMocks(this);
	product=new Product();
	product.setProductid(333);
	product.setPname("UPS");
	product.setPrice(34000);

}


@Test
public void whengivenproductaddRecord() throws ProductAlreadyExistException
{
	
	
	Mockito.when(serviceobj.addProductDetails(product)).thenReturn(product);
	
	//Product prdfind=serviceobj.findbyProductIdService(333);
	
	Product prdcheck=serviceobj.addProductDetails(product);
	
 
	Assert.assertEquals(product, prdcheck);
	
	
}



@Test
public void whenproductidgivenThenreturnproduct() 
{
	Mockito.when(serviceobj.findbyProductIdService(333)).thenReturn(product);
	
	Product prdfind=serviceobj.findbyProductIdService(333);
	
	Assert.assertEquals(product, prdfind);
	
}
//
//@Test
//public void whenidgiventhenDeleteProduct() throws Exception
//{
//
//	 //Product prd=serviceobj.addProductDetails(product);
//	product=new Product();
//	product.setProductid(300);
//	product.setPname("Abc");
//	product.setPrice(100);
//	
//	Mockito.when(serviceobj.addProductDetails(product)).thenReturn(product);
//	//Mockito.when(serviceobj.deleteProductbyId(100)).thenReturn(true);
//	
//	Product prd=serviceobj.findbyProductIdService(300);
//	
//	Assert.assertEquals(prd, product);
//	
//	//boolean ans=serviceobj.deleteProductbyId(100);
//	
//	//Assert.assertTrue(ans);
//	
//}

}
