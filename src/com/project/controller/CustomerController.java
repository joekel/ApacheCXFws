package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Customer;
import com.project.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController   {
	
	// Add the indbinder .. to convert trim input
	//remove leading and trailing whitespace
	//resolve issue for our validation 
	
	@InitBinder
	public void initBinder (WebDataBinder dataBinder){
		
		StringTrimmerEditor stringTrimmmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmmerEditor);
		}
	
	// need the inject customer service layer 
	@Autowired
	private CustomerService customerService ;
	
	@GetMapping("/list")
	public String Listcustomer (Model themodel){
		
		//get customer from DAO
		
		List<Customer> thecustomers = customerService.getCustomers();
		
		// Add the dao to the model
		themodel.addAttribute("customers", thecustomers);
		
		return "list-customers";
	}

	
	@GetMapping("/ShowformAdd")
	public String ShowformAdd(Model themodel){
		//create model attribute bind form data 
		Customer thecustomer = new Customer();
		themodel.addAttribute("customer",thecustomer);
		return "customer-form";
		
	}
	
	
	@PostMapping("/saveCustomer")
	public String SaveCustomer( @Valid @ModelAttribute("customer") Customer thecustomer , BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
			return "customer-form" ;
		}
		//save customer using our service
		customerService.savecustomer(thecustomer);
		return "redirect:/customer/list";
	}
	
	
	
	@GetMapping("/showformforupdate")
	public String showformforupdate (@RequestParam("customerID") int theID , Model themodel   ) {
		
		//logger.info("showing form for update");
		
		//get the customer from the database
		
		Customer thecustomer = customerService.getcustomer(theID);
		
		//set the customer as a model attribute to pre-population form
		
		themodel.addAttribute("customer", thecustomer);
		
		//send it over the form 
		
		return "customer-form";
	}
	
	
	@GetMapping("/delete")
	public String delet(@RequestParam("customerID") int theID){
		
		// delete the customer 
		customerService.deletecustomer(theID);
		
		return "redirect:/customer/list";
	}
	
//	
//	@GetMapping("/rest")
//	public  String rest ( Model themodel) {
//		
//				
//		return "restClient";
//	}
//	
//	
	
	
	
	
	
}
