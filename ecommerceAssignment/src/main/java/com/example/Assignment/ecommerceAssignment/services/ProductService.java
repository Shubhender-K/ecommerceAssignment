package com.example.Assignment.ecommerceAssignment.services;

import java.util.List;

import com.example.Assignment.ecommerceAssignment.payloads.ProductDto;

public interface ProductService {
	
	ProductDto createProduct(ProductDto productdto);
	
	ProductDto updateProduct(ProductDto productdto,int productId);
	
	ProductDto getProductById(Integer productId);
	
	List<ProductDto> getAllProducts();
	
	void deleteProductById(Integer productId);

}
