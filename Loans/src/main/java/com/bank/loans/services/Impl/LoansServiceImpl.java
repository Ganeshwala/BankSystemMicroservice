package com.bank.loans.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.loans.entities.Loans;
import com.bank.loans.repository.LoansRepository;
import com.bank.loans.services.LoansService;

@Service
public class LoansServiceImpl implements LoansService{

	@Autowired
	LoansRepository loanRepository;
	
	@Override
	public void createLoan(String mobileNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateLoanDeatil(Loans laonInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLoan(String mobileNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Loans fetchLoan(String mobileNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
