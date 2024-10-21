package com.bank.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accounts.constants.AccountConstants;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.dto.ResponseDto;
import com.bank.accounts.service.AccountService;

@RestController
@RequestMapping(path="/account",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {
	
	@Autowired
	private AccountService accountService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customer){
		accountService.createAccount(customer);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> fetchCustomerDeatils(@RequestParam String mobileNumber){
		CustomerDto fetchAccount = accountService.fetchAccount(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(fetchAccount);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateAccountDeatils(@RequestBody CustomerDto customerDto){
		boolean isUpdated = accountService.updateAccount(customerDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
		}
	}
}
