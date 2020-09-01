package com.stackroute.products.service;

import java.util.List;

import com.stackroute.products.model.Customer;

public interface CustomerService {
	Customer addCustomerDetails(Customer cust);
	List<Customer> viewcustomerDetails();
	boolean deleteCustomer(String id);
}
