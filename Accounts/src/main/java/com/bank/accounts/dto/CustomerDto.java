package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
		name = "Customer",
		description = "Schema to hold Customer and Account Information"
)
public class CustomerDto {

	private String name;
	
	private String email;
	
	private String mobileNumber;
	
	private AccountsDto accountsDto;
}
