package com.stackroute.products.dao;

import java.util.List;

import com.stackroute.products.model.Customer;

public interface CustomerDAO {

	Customer addCustomer(Customer customer);
	List<Customer> getAllcustomers();
	boolean delCustomer(String custid);
	
}
