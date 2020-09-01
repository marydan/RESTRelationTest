package com.stackroute.products.dao;

import java.util.List;

import com.stackroute.products.model.Product;

public interface ProductDAO {

	public Product addProduct(Product product);
	public List<Product> getallProducts();
	public boolean deleteProduct(int pid);
	public Product findByProductid(int id);
	public Product updateProduct(Product newprd);
	
}
