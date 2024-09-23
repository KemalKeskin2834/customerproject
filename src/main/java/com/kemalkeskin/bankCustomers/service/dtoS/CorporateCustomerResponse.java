package com.kemalkeskin.bankCustomers.service.dtoS;

public class CorporateCustomerResponse {
	
	private int id;
	
	private String  companyName;
	
	private String taxNumbers;
	
	
	public CorporateCustomerResponse() {
		
	}

	public CorporateCustomerResponse(int id, String companyName, String taxNumbers) {
		this.id=id;
		this.companyName = companyName;
		this.taxNumbers = taxNumbers;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
