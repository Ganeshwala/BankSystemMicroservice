package com.bank.accounts.repository;

import org.springframework.stereotype.Repository;

import com.bank.accounts.entity.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Optional<Customer> findByMobileNumber(String mobileNumber);

}
