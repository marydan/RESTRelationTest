package com.stackroute.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.products.dao.ProductDAO;
import com.stackroute.products.exceptions.ProductAlreadyExistException;
import com.stackroute.products.exceptions.ProductNotFoundException;
import com.stackroute.products.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productdao;

	public Product addProductDetails(Product prod) throws ProductAlreadyExistException {
		
		Product existprod=findbyProductIdService(prod.getProductid());
		
		 if(existprod==null)
	    productdao.addProduct(prod);
		 else
			 throw new ProductAlreadyExistException("Duplicate product");
		 
		 return prod;
		 
	}

	public List<Product> viewallProducts() {
	 return productdao.getallProducts();
	}

	public Product findbyProductIdService(int id) {
		
		return productdao.findByProductid(id);
	}

	public boolean deleteProductbyId(int id) throws ProductNotFoundException {
		
		Product prd=findbyProductIdService(id);
		
		if(prd==null)
		{
			throw new ProductNotFoundException("invalid product");
		}
		
	   else
		productdao.deleteProduct(id);
		
		return true;
	}

	public Product updateProductDetails(Product newprod) throws ProductNotFoundException {
	
		Product prd=findbyProductIdService(newprod.getProductid());
		
		if(prd==null)
			throw new ProductNotFoundException("invalid product");
		else
			productdao.updateProduct(newprod);
		
		return newprod;
	}

}
