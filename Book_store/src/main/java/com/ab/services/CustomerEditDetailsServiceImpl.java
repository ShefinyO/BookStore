package com.ab.services;

import com.ab.daos.CustomerDAO;
import com.ab.models.Customer;

public class CustomerEditDetailsServiceImpl implements CustomerEditDetailsService{

	
	private CustomerDAO customerDao;
	
	
	public CustomerEditDetailsServiceImpl(CustomerDAO customerDao) {
		
		this.customerDao = customerDao;
	}

	@Override
	public Customer editFirstName(String firstName, int customerId) {
		// TODO Auto-generated method stub
		return customerDao.editFirstName(firstName, customerId);
	}

	@Override
	public Customer editLastName(String lastName, int customerId) {
		// TODO Auto-generated method stub
		return customerDao.editLastName(lastName, customerId);
	}

	@Override
	public Customer editEmail(String email, int customerId) {
		// TODO Auto-generated method stub
		return customerDao.editEmail(email, customerId);
	}

	@Override
	public Customer editPassword(String password, int customerId) {
		// TODO Auto-generated method stub
		return customerDao.editPassword(password, customerId);
	}

	@Override
	public Customer editMobileNo(String mobileNo, int customerId) {
		// TODO Auto-generated method stub
		return customerDao.editMobileNo(mobileNo, customerId);
	}

	
	
}
