package com.bank.cards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.cards.constants.CardsConstants;
import com.bank.cards.dto.CardsDto;
import com.bank.cards.dto.ResponseDto;
import com.bank.cards.service.CardsService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@Tag(
        name = "CRUD REST APIs for Cards in EazyBank",
        description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE card details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CardsController {

	private CardsService cardsService;
	
	 @PostMapping("/create")
	    public ResponseEntity<ResponseDto> createCard(@Valid @RequestParam
	                                                      @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
	                                                      String mobileNumber) {
		 cardsService.createCard(mobileNumber);
	            return ResponseEntity
	                    .status(HttpStatus.CREATED)
	                    .body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
	    }
	 
	 @GetMapping("/fetch")
	    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam
	                                                               @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
	                                                               String mobileNumber) {
	        CardsDto cardsDto = cardsService.fetchCard(mobileNumber);
	        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<ResponseDto> updateCardDetails(@Valid @RequestBody CardsDto cardsDto) {
	        boolean isUpdated = cardsService.updateCard(cardsDto);
	        if(isUpdated) {
	            return ResponseEntity
	                    .status(HttpStatus.OK)
	                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
	        }else{
	            return ResponseEntity
	                    .status(HttpStatus.EXPECTATION_FAILED)
	                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE));
	        }
	    }
	 
	 @DeleteMapping("/delete")
	    public ResponseEntity<ResponseDto> deleteCardDetails(@RequestParam
	                                                                @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
	                                                                String mobileNumber) {
	        boolean isDeleted = cardsService.deleteCard(mobileNumber);
	        if(isDeleted) {
	            return ResponseEntity
	                    .status(HttpStatus.OK)
	                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
	        }else{
	            return ResponseEntity
	                    .status(HttpStatus.EXPECTATION_FAILED)
	                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_DELETE));
	        }
	    }
}
