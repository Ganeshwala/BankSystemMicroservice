package com.bank.cards.service;

import org.springframework.stereotype.Service;

import com.bank.cards.dto.CardsDto;

@Service
public interface CardsService {

	void createCard(String mobileNumber);
	
	CardsDto fetchCard(String mobileNumber);
	
	boolean updateCard(CardsDto cardsDto);
	
	boolean deleteCard(String mobileNumber);
}
