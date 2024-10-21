package com.bank.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.accounts.constants.AccountConstants;
import com.bank.accounts.dto.AccountsDto;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.entity.Accounts;
import com.bank.accounts.entity.Customer;
import com.bank.accounts.exception.CustomerAlreadyExistsException;
import com.bank.accounts.exception.ResourceNotFoundException;
import com.bank.accounts.mapper.AccountsMapper;
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

	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		Customer customer = customerRepo.findByMobileNumber(mobileNumber).orElseThrow(
				()->new ResourceNotFoundException("Customer", "MobileNumber", mobileNumber)
				);
		
		Accounts account = accountsRepo.findByCustomerId(customer.getCustomerId()).orElseThrow(
				()-> new ResourceNotFoundException("Account", "Customer Id", customer.getCustomerId().toString())
				);
		CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
		customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
		return customerDto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		 boolean isUpdated = false;
		 AccountsDto accountsDto = customerDto.getAccountsDto();
		 if(accountsDto != null) {
			 Accounts accounts = accountsRepo.findById(accountsDto.getAccountNumber()).orElseThrow(
					 ()->new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString()));
			 
			 Accounts mapToAccounts = AccountsMapper.mapToAccounts(accountsDto, accounts);
			 accounts = accountsRepo.save(mapToAccounts);
			 
			 Long customerId = accounts.getCustomerId();
			 Customer customer = customerRepo.findById(customerId).orElseThrow(
					 ()->new ResourceNotFoundException("Customer", "CustomerId", customerId.toString()));
			 CustomerMapper.mapToCustomer(customerDto, customer);
			 customerRepo.save(customer);
			 isUpdated = true;
		 }
		return isUpdated;
	}

	@Override
	public boolean deleteAccount(String mobileNumber) {
		Customer customer = customerRepo.findByMobileNumber(mobileNumber).orElseThrow(
				()-> new ResourceNotFoundException("Customer", "MobileNumber", mobileNumber));
		
		accountsRepo.deleteByCustomerId(customer.getCustomerId());
		customerRepo.deleteById(customer.getCustomerId());
		return true;
	}
	
}
