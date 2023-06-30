package com.ab.models;


public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private Address shippingAddress;
	private String dateOfBirth; 
	private String email;
	private String password;
	private String mobileNo;
	
	
	//constructor
	
	public Customer(int customerId, String firstName, String lastName, String email, String mobileNo) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	
	public Customer(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}



	//getters
	
	public int getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Address getAddress() {
		return shippingAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	//setters
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + shippingAddress + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", password="
				+ password + ", mobileNo=" + mobileNo;
	}
}
