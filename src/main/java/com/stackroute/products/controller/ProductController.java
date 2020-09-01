package com.stackroute.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.products.exceptions.ProductAlreadyExistException;
import com.stackroute.products.exceptions.ProductNotFoundException;
import com.stackroute.products.model.Product;
import com.stackroute.products.service.ProductService;

@RestController
@RequestMapping("ust/product")
public class ProductController {
	
	
	@Autowired
	ProductService prodserve;
	
	@GetMapping("/home")
	public ResponseEntity<?> onLoad()
	{
		return new ResponseEntity<String>("Welcome" , HttpStatus.OK);
	}

	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product)
	{
		
		try
		{
			Product prodobj=prodserve.addProductDetails(product);
			return new ResponseEntity<String>("Added",HttpStatus.OK);
		}
		catch(ProductAlreadyExistException e)
		{
		return new ResponseEntity<String>("Duplicate Product",HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/viewProducts")
	public ResponseEntity<?> showallProduct()
	{
		List<Product> products=prodserve.viewallProducts();
		
		return new ResponseEntity<List>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProductdetails(@PathVariable("id") int pid)
	{
		try
		{
		prodserve.deleteProductbyId(pid);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		catch(ProductNotFoundException ex)
		{
			return new ResponseEntity<String>("Product not found",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/modifyProduct")
	public ResponseEntity<?> updateproduct(@RequestBody Product modiprod)
	{
		try
		{
		Product updatedprod=prodserve.updateProductDetails(modiprod);
			return new ResponseEntity<Product>(updatedprod,HttpStatus.OK);
		}
		catch(ProductNotFoundException ex)
		{
			return new ResponseEntity<String>("Not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/findProduct/{pid}")
	public ResponseEntity<?> viewProduct(@PathVariable("pid") int pid)
	{
		Product prod=prodserve.findbyProductIdService(pid);
		return new ResponseEntity<Product>(prod,HttpStatus.OK);
		
	}
}
