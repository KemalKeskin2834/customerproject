package com.kemalkeskin.bankCustomers.service.dtoS;

import jakarta.validation.constraints.Size;

public class IndividualCustomerRequest {

	private String customerNumbers;

	
	@Size(min = 3,message = "minimum character size 3")
	private String firstName;

	
	@Size(min = 3,message = "minimum character size 3")
	private String lastName;

	@Size(min = 11,max = 11,message = "national ıd length is 11")
	private String nationalId;

	
	private int birthOfYear;

	public IndividualCustomerRequest() {

	}

	public IndividualCustomerRequest(String customerNumbers, String firstName, String lastName, String nationalId,
			int birthOfYear) {
		
		this.customerNumbers = customerNumbers;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.birthOfYear = birthOfYear;
	}

	public String getCustomerNumbers() {
		return customerNumbers;
	}

	public void setCustomerNumbers(String customerNumbers) {
		this.customerNumbers = customerNumbers;
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

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public int getBirthOfYear() {
		return birthOfYear;
	}

	public void setBirthOfYear(int birthOfYear) {
		this.birthOfYear = birthOfYear;
	}
	
	

}
