package com.project.dao;

import java.util.List;

import com.project.entity.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomers() ;

	public void savecustomers(Customer thecustomer);

	public Customer getcustomer(int theID);

	public void deletecustomer(int theID); 

}
