package com.bank.loans.mapper;

import com.bank.loans.dto.LoansDto;
import com.bank.loans.entities.Loans;

public class LoansMapper {

	public static LoansDto mappedLoansToLoansDto(Loans loans,LoansDto loansDto) {
		
		loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
	}
	
	public static Loans mappedLoansDtoToLoans(LoansDto loansDto,Loans loans) {
		loans.setLoanNumber(loansDto.getLoanNumber());
		loans.setLoanType(loansDto.getLoanType());
		loans.setMobileNumber(loansDto.getMobileNumber());
		loans.setTotalLoan(loansDto.getTotalLoan());
		loans.setAmountPaid(loansDto.getAmountPaid());
		loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
	}
}