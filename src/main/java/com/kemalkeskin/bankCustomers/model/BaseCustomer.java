package com.kemalkeskin.bankCustomers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "base_customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "customer_numbers")
	private String customerNumbers;
	
	
	public BaseCustomer() {
		
	}


	public BaseCustomer(int id, String customerNumbers) {
		this.id = id;
		this.customerNumbers = customerNumbers;
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


	@Override
	public String toString() {
		return "BaseCustomer [id=" + id + ", customerNumbers=" + customerNumbers + "]";
	}
	
	

	
}
