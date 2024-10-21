package com.bank.loans.entities;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;

@MappedSuperclass // this annotation will allowed to map this class with any other // like inheritance
@Data
@ToString
public class BaseEntities {

	public LocalDateTime createdAt;
	
	public String createdBy;
	
	public LocalDateTime updatedAt;
	
	public String updatedBy;
}
