package com.bank.loans.services;

import com.bank.loans.entities.Loans;

public interface LoansService {

	public void createLoan(String mobileNumber);
	
	public boolean updateLoanDeatil(Loans laonInfo);
	
	public boolean deleteLoan(String mobileNumber);
	
	public Loans fetchLoan(String mobileNumber);
}
