package com.ab.daos;

import com.ab.models.Customer;

public interface CustomerDAO {
	
	public Customer customerRegister(Customer customer);
	public Customer customerLogin(String emailId, String password);
	public Customer viewCustomerDetails(int customerId);
	public Customer editFirstName(String firstName, int customerId);
	public Customer editLastName(String lastName, int customerId);
	public Customer editEmail(String email, int customerId);
	public Customer editPassword(String password, int customerId);
	public Customer editMobileNo(String mobileNo, int customerId);
	
}
