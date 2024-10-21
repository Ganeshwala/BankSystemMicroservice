package com.bank.loans.services;

import com.bank.loans.dto.LoansDto;

public interface LoansService {

	public void createLoan(String mobileNumber);
	
	public boolean updateLoan(LoansDto laonInfo);
	
	public boolean deleteLoan(String mobileNumber);
	
	public LoansDto fetchLoan(String mobileNumber);
}
