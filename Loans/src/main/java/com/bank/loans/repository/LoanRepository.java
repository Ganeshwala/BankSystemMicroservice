package com.bank.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.loans.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}
