package com.kemalkeskin.bankCustomers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalkeskin.bankCustomers.model.BaseCustomer;

@Repository
public interface BaseCustomerRepository extends JpaRepository<BaseCustomer, Integer>{

}
