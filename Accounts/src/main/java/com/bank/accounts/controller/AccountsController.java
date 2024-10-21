package com.bank.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path="/account",produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(
		name = "CRUD REST APIs for Accounts in Banking System",
		description = "CURD Rest API in Banking System to CREATE,UPDATE,READ,DELETE account details."
		)
public class AccountsController {
	
	@Autowired
	private AccountService accountService;

	@Operation(
				summary = "Create Account Rest API",
				description = "Rest API to create new account deatile for new customer."
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP status Created"
			)
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
	
	@Operation(
			summary = "Update Account Deatils Rest API",
			description = "REST API to update Customer & Account details base on account number."
			)
	// to give multiple response description
	@ApiResponses({
				@ApiResponse(
							responseCode = "200",
							description = "HTTP Status OK"
						),
				@ApiResponse(
						responseCode = "500",
						description = "HTTP Status Internal Server Error"
						)
	})
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateAccountDeatils(@RequestBody CustomerDto customerDto){
		boolean isUpdated = accountService.updateAccount(customerDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber){
		boolean isDeleted = accountService.deleteAccount(mobileNumber);
		if(isDeleted) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
		}
	}
}
