package com.ab.services;

import com.ab.models.Customer;

public interface CustomerEditDetailsService {
	
	public Customer editFirstName(String firstName, int customerId);
	public Customer editLastName(String lastName, int customerId);
	public Customer editEmail(String email, int customerId);
	public Customer editPassword(String password, int customerId);
	public Customer editMobileNo(String mobileNo, int customerId);

}
