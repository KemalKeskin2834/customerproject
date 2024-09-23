package com.kemalkeskin.bankCustomers.service.dtoS;

public class IndividualCustomerResponse {

	private String firstName;
	
	private String lastName;
	
	private int birthOfYear;
	
	public IndividualCustomerResponse() {

	}

	public IndividualCustomerResponse(String firstName, String lastName, int birthOfYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfYear = birthOfYear;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getBirthOfYear() {
		return birthOfYear;
	}

	public void setBirthOfYear(int birthOfYear) {
		this.birthOfYear = birthOfYear;
	}
	
	
	
	
}
