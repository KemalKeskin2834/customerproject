package com.kemalkeskin.bankCustomers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "individual_customers")
public class IndividualCustomer extends BaseCustomer {
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "national_ıd")
	private String nationalId;
	
	@Column(name = "birth_of_year")
	private int birthOfYear;
	
	public IndividualCustomer() {
		
	}

	public IndividualCustomer(String firstName, String lastName, String nationalId, int birthOfYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
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

	@Override
	public String toString() {
		return "IndividualCustomer [firstName=" + firstName + ", lastName=" + lastName + ", nationalId=" + nationalId
				+ ", birthOfYear=" + birthOfYear + "]";
	}
	
	
	
	

}
