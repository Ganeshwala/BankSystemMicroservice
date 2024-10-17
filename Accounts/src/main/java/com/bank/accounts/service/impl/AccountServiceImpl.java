package com.bank.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.accounts.constants.AccountConstants;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.entity.Accounts;
import com.bank.accounts.entity.Customer;
import com.bank.accounts.exception.CustomerAlreadyExistsException;
import com.bank.accounts.mapper.CustomerMapper;
import com.bank.accounts.repository.AccountsRepository;
import com.bank.accounts.repository.CustomerRepository;
import com.bank.accounts.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountsRepository accountsRepo;
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public void createAccount(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Optional<Customer> customerMobileNumber = customerRepo.findByMobileNumber(customerDto.getMobileNumber());
		if(customerMobileNumber.isPresent()) {
			throw new CustomerAlreadyExistsException("customer Already registered with give number"+customerDto.getMobileNumber());
		}
		customer.setCreatedDT(LocalDateTime.now());
		customer.setCreateBy(customerDto.getName());
		Customer saveCustomer = customerRepo.save(customer);
		accountsRepo.save(createNewAccount(saveCustomer));
	}

	private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setCreatedDT(LocalDateTime.now());
        newAccount.setCreateBy(customer.getName());
        return newAccount;
    }
	
}
