package com.project.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.security.access.annotation.Secured;

import com.project.entity.Customer;



@Produces({"application/xml","application/json"})
public interface CustomerService  {

	
	@Secured(value="ROLE_CUSTOMER")
	@GET
	@Path("/costomer/")
	public List<Customer> getCustomers();
	
	
	@Secured(value="ROLE_CUSTOMER")
	@PUT
	@Path("/costomer/")
	public  void savecustomer(Customer thecustomer) ;
	
	
	@Secured(value="ROLE_CUSTOMER")
	@GET
	@Path("/costomer/{theID}/")
	public Customer getcustomer(@PathParam("theID") int theID);
	
	
	@Secured(value="ROLE_ADMIN")
	@DELETE
	@Path("/costomer/{theID}/")
	public Response deletecustomer(@PathParam("theID") int theID);
}
