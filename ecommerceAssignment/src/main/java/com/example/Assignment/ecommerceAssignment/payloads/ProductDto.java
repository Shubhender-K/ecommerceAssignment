package com.example.Assignment.ecommerceAssignment.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

	@NotEmpty(message = "Product name must not be empty")
	private String p_name;

	private Integer p_cost;

	@NotEmpty(message = "Product description must not be empty")
	private String p_description;
}
