package com.kemalkeskin.bankCustomers.service.dtoS;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Size;

public class CorporateCustomerRequest {
	
	@JsonIgnore
	private int id;
	
	private String customerNumbers;
	
	@Size(min = 3,message = "minimum character size 3")
	private String  companyName;
	
	@Size(min = 11,max = 11, message = "minimum character size 3")
	private String taxNumbers;
	
	
	public CorporateCustomerRequest() {
		
	}

	public CorporateCustomerRequest(int id,String customerNumbers,String companyName, String taxNumbers) {
	
		this.id=id;
		this.customerNumbers=customerNumbers;
		this.companyName = companyName;
		this.taxNumbers = taxNumbers;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerNumbers() {
		return customerNumbers;
	}

	public void setCustomerNumbers(String customerNumbers) {
		this.customerNumbers = customerNumbers;
	}

	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getTaxNumbers() {
		return taxNumbers;
	}


	public void setTaxNumbers(String taxNumbers) {
		this.taxNumbers = taxNumbers;
	}

}
