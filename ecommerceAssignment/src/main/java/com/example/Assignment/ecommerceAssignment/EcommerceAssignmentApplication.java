package com.example.Assignment.ecommerceAssignment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Ecommerce API", version = "2.0",description = "Ecommerce API Documentation"))
public class EcommerceAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceAssignmentApplication.class, args);
	}
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
