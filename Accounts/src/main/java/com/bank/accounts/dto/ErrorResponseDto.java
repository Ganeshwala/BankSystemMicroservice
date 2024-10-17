package com.bank.accounts.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

	private String apiPath;
	
	private HttpStatus erroeCode;
	
	private String errorMsg;
	
	private LocalDateTime erroeTime;
}
