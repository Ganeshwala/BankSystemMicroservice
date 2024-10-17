package com.bank.accounts.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@MappedSuperclass
public class BaseEntity {

	@Column(name="created_at",updatable = false)
	private LocalDate createdDT;
	
	@Column(name="created_by",updatable = false)
	private String createBy;
	
	@Column(name="updated_at",insertable = false)
	private LocalDate updateDT;
	
	@Column(name="updated_by",insertable = false)
	private String updatedBy;
}
