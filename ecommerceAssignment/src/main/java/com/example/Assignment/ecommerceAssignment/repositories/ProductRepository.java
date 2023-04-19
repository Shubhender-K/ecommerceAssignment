package com.example.Assignment.ecommerceAssignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Assignment.ecommerceAssignment.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
