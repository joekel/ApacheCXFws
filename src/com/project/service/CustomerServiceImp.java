package com.project.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CustomerDAO;
import com.project.entity.Customer;
import com.project.exception.SomeBusinessException;

@Service
//@Configurable 
public class CustomerServiceImp  implements CustomerService {

	// need to inject Customer Dao
	
//	
//	
//	public CustomerServiceImp() {
//		super();
//	}

	public @Autowired CustomerDAO customerDAO;
	
	


//	ApplicationContext context = new ClassPathXmlApplicationContext("com/config/beand.xml");
//	CustomerDAO objA = (CustomerDAO) context.getBean("customerDAO");


	//public ApplicationContext appcontext = com.config.appcontext.getAppcontect();

//	public void CustomerDAO() {
//		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		System.out.println("list cust");

		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void savecustomer(Customer thecustomer) {

		customerDAO.savecustomers(thecustomer);

	}

	@Override
	@Transactional

	public Customer getcustomer(int theID) {
		System.out.println(theID);
		System.out.println(" getcustomer id");
		Customer the = customerDAO.getcustomer(theID);
		return the;

	}

	@Override
	@Transactional

	public Response deletecustomer(int theID) {
		
		Response response;
		
		if (customerDAO.getcustomer(theID) != null) {
			response = Response.ok().build();
			customerDAO.deletecustomer(theID);
		} else {
			throw new SomeBusinessException("Business Exception");
		}

		return response;
	}

}
