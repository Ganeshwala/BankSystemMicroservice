package com.bank.accounts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.bank.accounts.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException customerException,WebRequest webRequest){
		ErrorResponseDto errorResponseDto = new ErrorResponseDto();
		errorResponseDto.setApiPath(webRequest.getDescription(false));
		errorResponseDto.setErrorCode(HttpStatus.BAD_REQUEST);
		errorResponseDto.setErrorMsg(customerException.getMessage());
		errorResponseDto.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
	}
}
