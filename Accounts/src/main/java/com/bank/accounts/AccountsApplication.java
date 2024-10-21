package com.bank.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Rest Api Documentation ",
				description = "Create module Account, will going to use it for MicroServices",
				version = "v1",
				contact = @Contact(
						name = "Chintan Ganeshwala",
						email = "ganeshwalachintan@gmail.com"
						),
				license = @License(
						name = "Apache 2.0"
						)
				),  
				externalDocs = @ExternalDocumentation(
							description = "THis is External MicroServices Documentation"
						)
		)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
