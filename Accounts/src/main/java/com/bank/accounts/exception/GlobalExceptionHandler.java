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
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception customerException,WebRequest webRequest){
		ErrorResponseDto errorResponseDto = new ErrorResponseDto();
		errorResponseDto.setApiPath(webRequest.getDescription(false));
		errorResponseDto.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponseDto.setErrorMsg(customerException.getMessage());
		errorResponseDto.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<>(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException customerException,WebRequest webRequest){
		ErrorResponseDto errorResponseDto = new ErrorResponseDto();
		errorResponseDto.setApiPath(webRequest.getDescription(false));
		errorResponseDto.setErrorCode(HttpStatus.BAD_REQUEST);
		errorResponseDto.setErrorMsg(customerException.getMessage());
		errorResponseDto.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest){
		ErrorResponseDto errorResponseDto = new ErrorResponseDto();
		errorResponseDto.setApiPath(webRequest.getDescription(false));
		errorResponseDto.setErrorCode(HttpStatus.BAD_REQUEST);
		errorResponseDto.setErrorMsg(exception.getMessage());
		errorResponseDto.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
	}
}
