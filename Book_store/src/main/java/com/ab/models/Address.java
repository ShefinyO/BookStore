package com.ab.models;

public class Address {
	
	private int addressId;
	private String firstLine;
	private String secondLine;
	private String postcode;
	
	public Address(int addressId, String firstLine, String postcode) {
		this.addressId = addressId;
		this.firstLine = firstLine;
		this.postcode = postcode;
	}

	public Address(int addressId, String firstLine, String secondLine, String postcode) {
		this.addressId = addressId;
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.postcode = postcode;
	}

	public int getAddressId() {
		return addressId;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "addressId=" + addressId + ", firstLine=" + firstLine + ", secondLine=" + secondLine
				+ ", postcode=" + postcode;
	}
	
	
}
