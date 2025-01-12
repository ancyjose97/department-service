package com.cts.departmentservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(
		
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Ancy Jose",
						email = "ancymaria7@gmail.com",
						url = "javaguides.net"
						),
				license = @License(
						name = "Apache 2.0",
						url = "javaguides.net/license"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "Department-Service Doc",
				url = "javaguides.net/Department_Service.html"
				)
		)

@SpringBootApplication
public class DepartmentServiceApplication {
	
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
