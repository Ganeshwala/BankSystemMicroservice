package com.bank.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.loans.entities.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long>{

}
