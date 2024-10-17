package com.bank.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer extends BaseEntity{

	@Id
	@SequenceGenerator(initialValue = 100,allocationSize = 1,name = "customerSeq",sequenceName = "CustomerSequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customerSeq")
	private Long customerId;
	
	private String name;
	
	private String email;
	
	private String mobileNumber;
}
