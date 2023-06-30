package com.ab.controllers;
import com.ab.models.Customer;
import com.ab.services.CustomerServiceRegisterLogin;

public class CustomerServiceRegisterLoginController{
	
	private CustomerServiceRegisterLogin customerServiceRegisterLogin;

	public CustomerServiceRegisterLoginController(CustomerServiceRegisterLogin customerServiceRegisterLogin) {
		this.customerServiceRegisterLogin = customerServiceRegisterLogin;
	}
	
	
	public Customer customerRegister(Customer customer) {
		
		return this.customerServiceRegisterLogin.customerRegister(customer);
	}


	public Customer customerLogin(String emailId, String password) {
		return this.customerServiceRegisterLogin.customerLogin(emailId, password);
	}	
	
	public Customer viewCustomerDetails(int customerId) {
		
		return customerServiceRegisterLogin.viewCustomerDetails(customerId);
	}
	

}
