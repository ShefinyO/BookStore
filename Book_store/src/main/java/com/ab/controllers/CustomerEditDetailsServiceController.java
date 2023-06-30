package com.ab.controllers;

import com.ab.models.Customer;
import com.ab.services.CustomerEditDetailsService;

public class CustomerEditDetailsServiceController {
	
	private CustomerEditDetailsService customerEditDetailsService;

	public CustomerEditDetailsServiceController(CustomerEditDetailsService customerEditDetailsService) {
		
		this.customerEditDetailsService = customerEditDetailsService;
	}
	
	public Customer editFirstName(String firstName, int customerId) {
		
		return customerEditDetailsService.editFirstName(firstName, customerId);
	}


	public Customer editLastName(String lastName, int customerId) {
		
		return customerEditDetailsService.editLastName(lastName, customerId);
	}

	
	public Customer editEmail(String email, int customerId) {
		
		return customerEditDetailsService.editEmail(email, customerId);
	}

	
	public Customer editPassword(String password, int customerId) {
		
		return customerEditDetailsService.editPassword(password, customerId);
	}

	
	public Customer editMobileNo(String mobileNo, int customerId) {
		
		return customerEditDetailsService.editMobileNo(mobileNo, customerId);
	}
	
	

}
