package com.stackroute.products.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.products.model.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	SessionFactory sessfact;
	
	public Customer addCustomer(Customer customer) {
  sessfact.getCurrentSession().save(customer);
	return customer;
	}

	public List<Customer> getAllcustomers() {
		
		List<Customer> customerlist=sessfact.getCurrentSession().createQuery("from Customer").list();
		// TODO Auto-generated method stub
		return customerlist;
	}

	public boolean delCustomer(String custid) {
	
Customer customer=(Customer)sessfact.getCurrentSession().createQuery("from Customer where custid='" + custid + "'").uniqueResult();	
		sessfact.getCurrentSession().delete(customer);
		
		return false;
	}

}
