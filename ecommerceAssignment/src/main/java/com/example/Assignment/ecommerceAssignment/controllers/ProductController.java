package com.example.Assignment.ecommerceAssignment.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment.ecommerceAssignment.payloads.ProductDto;
import com.example.Assignment.ecommerceAssignment.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@PostMapping("/")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productdto){	
		
		ProductDto createdProduct = productservice.createProduct(productdto);
		return new ResponseEntity<ProductDto>(createdProduct, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{pId}")
	public ResponseEntity<ProductDto> updateUser(@Valid @RequestBody ProductDto productdto, @PathVariable Integer pId) {
		ProductDto updatedProduct = this.productservice.updateProduct(productdto, pId);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	
	@GetMapping("/{pId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Integer pId) {
		return ResponseEntity.ok(this.productservice.getProductById(pId));
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		return ResponseEntity.ok(this.productservice.getAllProducts());
	}
	
	@DeleteMapping("/delete/{pId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer pId) {
		this.productservice.deleteProductById(pId);
		return ResponseEntity.ok(Map.of("message", "Product got deleted"));
	}
	

	
}
