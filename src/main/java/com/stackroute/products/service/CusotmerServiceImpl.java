package com.stackroute.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.products.dao.CustomerDAO;
import com.stackroute.products.model.Customer;

@Service
public class CusotmerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO custdao;
	
	public Customer addCustomerDetails(Customer cust) {

		 custdao.addCustomer(cust);
		return cust;
	}

	public List<Customer> viewcustomerDetails() {
		 
		return custdao.getAllcustomers();
	}

	public boolean deleteCustomer(String id) {
	custdao.delCustomer(id);
		return false;
	}

	
	
}
