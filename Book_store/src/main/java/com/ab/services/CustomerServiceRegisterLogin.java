package com.ab.services;
import com.ab.models.Customer;

public interface CustomerServiceRegisterLogin {
	
	public Customer customerRegister(Customer customer);
	public Customer customerLogin(String emailId, String password);
	public Customer viewCustomerDetails(int customerId);
	
	
}
