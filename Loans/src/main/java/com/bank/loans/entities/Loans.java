package com.bank.loans.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Loans extends BaseEntities{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long loanId;
	
	public String mobileNumber;
	
	public String loanNumber;
	
	private String loanType;
	
	public int totalLoan;
	
	public int amountPaid;
	
	private int outstandingAmount;
}
