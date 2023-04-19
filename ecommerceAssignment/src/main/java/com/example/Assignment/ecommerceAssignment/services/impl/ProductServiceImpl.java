package com.example.Assignment.ecommerceAssignment.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment.ecommerceAssignment.entities.Product;
import com.example.Assignment.ecommerceAssignment.exceptions.ResourceNotFoundException;
import com.example.Assignment.ecommerceAssignment.payloads.ProductDto;
import com.example.Assignment.ecommerceAssignment.repositories.ProductRepository;
import com.example.Assignment.ecommerceAssignment.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	private ProductRepository prodrepo;

	@Override
	public ProductDto createProduct(ProductDto productdto) {
		Product product = this.productdtoToProduct(productdto);

		Product savedProduct = prodrepo.save(product);

		return this.productToProductDto(savedProduct);
	}

	@Override
	public ProductDto updateProduct(ProductDto productdto, int productId) {
		Product product = this.prodrepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Product ID", productId));

		product.setP_name(productdto.getP_name());
		product.setP_cost(productdto.getP_cost());
		product.setP_description(productdto.getP_description());

		this.prodrepo.save(product);

		return this.productToProductDto(product);

	}

	@Override
	public ProductDto getProductById(Integer productId) {
		Product product = this.prodrepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Product ID", productId));
		return this.productToProductDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> findAll = this.prodrepo.findAll();
		
		List<ProductDto> collectedProducts = findAll.stream().map(prod-> this.productToProductDto(prod)).collect(Collectors.toList());
		
		return collectedProducts;
	}

	@Override
	public void deleteProductById(Integer productId) {
		Product product = this.prodrepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Product ID", productId));
		
		prodrepo.delete(product);
		
	}

	public Product productdtoToProduct(ProductDto productdto) {
		Product product = this.modelmapper.map(productdto, Product.class);
		return product;
	}

	public ProductDto productToProductDto(Product product) {
		return this.modelmapper.map(product, ProductDto.class);
	}
}
