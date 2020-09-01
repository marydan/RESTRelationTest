package com.stackroute.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.products.model.Customer;
import com.stackroute.products.service.CustomerService;

@RestController
@RequestMapping("ust/customer")
public class CustomerController {
	
	@Autowired
	CustomerService custservice;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomerdetails(@RequestBody Customer cust)
	{
    custservice.addCustomerDetails(cust);
    return new ResponseEntity<String>("Record Added",HttpStatus.OK);
		
	}
	
	@GetMapping("/showcustomers")
	public ResponseEntity<?> showCustomerdetails()
	{
		List<Customer> customers=custservice.viewcustomerDetails();
		
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/removeCustomer/{custid}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("custid") String id)
	{
		custservice.deleteCustomer(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}

}
