package com.bank.loans.services;

import com.bank.loans.entities.Loan;

public interface loanService {

	public void createLoan(String mobileNumber);
	
	public boolean updateLoanDeatil(Loan laonInfo);
	
	public boolean deleteLoan(String mobileNumber);
	
	public Loan fetchLoan(String mobileNumber);
}
