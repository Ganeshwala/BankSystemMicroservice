package com.bank.accounts.service;

import org.springframework.stereotype.Service;

import com.bank.accounts.dto.CustomerDto;

@Service
public interface AccountService {

	/**
	 * 
	 * @param customerDto
	 */
	public void createAccount(CustomerDto customerDto);
	

	public CustomerDto fetchAccount(String mobileNumber);
	
	public boolean updateAccount(CustomerDto customerDto);
	
	public boolean deleteAccount(String mobileNumber);
}
