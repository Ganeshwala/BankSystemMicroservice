package com.bank.accounts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@MappedSuperclass
public class BaseEntity {

	@Column(name="created_at",updatable = false)
	private LocalDateTime createdDT;
	
	@Column(name="created_by",updatable = false)
	private String createBy;
	
	@Column(name="updated_at",insertable = false)
	private LocalDateTime updateDT;
	
	@Column(name="updated_by",insertable = false)
	private String updatedBy;
}
