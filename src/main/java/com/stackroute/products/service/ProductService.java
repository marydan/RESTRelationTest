package com.stackroute.products.service;

import java.util.List;

import com.stackroute.products.exceptions.ProductAlreadyExistException;
import com.stackroute.products.exceptions.ProductNotFoundException;
import com.stackroute.products.model.Product;

public interface ProductService {

	public Product addProductDetails(Product prod) throws ProductAlreadyExistException;
	 List<Product> viewallProducts();
	 
	 Product findbyProductIdService(int id);
	 
	 
	public boolean deleteProductbyId(int id) throws ProductNotFoundException;

	public Product updateProductDetails(Product newprod) throws ProductNotFoundException;

}
