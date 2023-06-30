package com.ab.services;

import com.ab.daos.CustomerDAO;
import com.ab.models.Customer;

public class CustomerServiceRegisterLoginImpl implements CustomerServiceRegisterLogin{
	
	private CustomerDAO customerDAO;
	
	public CustomerServiceRegisterLoginImpl(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}

	@Override
	public Customer customerRegister(Customer customer) {
		
		return this.customerDAO.customerRegister(customer);
	}

	@Override
	public Customer customerLogin(String emailId, String password) {
		return this.customerDAO.customerLogin(emailId, password);
	}

	@Override
	public Customer viewCustomerDetails(int customerId) {
		
		return customerDAO.viewCustomerDetails(customerId);
	}
	


}
