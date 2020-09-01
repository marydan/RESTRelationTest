package com.stackroute.products.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.products.model.Product;


@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessfact;
	
	ProductDAOImpl(SessionFactory sess)
	{
		sessfact=sess;
	}
	
	
	public Product addProduct(Product product) {
		 
		sessfact.getCurrentSession().save(product);
		return product;
	}

	public List<Product> getallProducts() {
	return sessfact.getCurrentSession().createQuery("from Product").list();
		
	}

	public boolean deleteProduct(int pid) {
	
		Product product=findByProductid(pid);
	
sessfact.getCurrentSession().delete(product);
		
		return true;
	}

	public Product findByProductid(int id) {
		
		Product productobj=(Product)sessfact.getCurrentSession().createQuery("from Product where productid="+id).uniqueResult();
		return productobj;
	}

	public Product updateProduct(Product newprd) {

		Product productold=findByProductid(newprd.getProductid());
		
		productold.setPname(newprd.getPname());
		productold.setPrice(newprd.getPrice());
 		
		sessfact.getCurrentSession().update(productold);
		
		return productold;
	}

}
