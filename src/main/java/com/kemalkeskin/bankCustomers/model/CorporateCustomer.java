package com.kemalkeskin.bankCustomers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "corporate_customers")
public class CorporateCustomer extends BaseCustomer {
	
	@Column(name = "company_name")
	private String  companyName;
	
	@Column(name = "tax_number")
	private String taxNumbers;
	
	public CorporateCustomer() {
		
	}

	public CorporateCustomer(String companyName, String taxNumbers) {
		super();
		this.companyName = companyName;
		this.taxNumbers = taxNumbers;
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

	@Override
	public String toString() {
		return "CorporateCustomer [companyName=" + companyName + ", taxNumbers=" + taxNumbers + "]";
	}
	
	
	
	

}
