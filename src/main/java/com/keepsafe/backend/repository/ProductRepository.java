package com.keepsafe.backend.repository;

import com.keepsafe.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// This repository handles database operations for products.
// JpaRepository provides save(), findById(), findAll(), and deleteById(),
// so we don't have to write these methods ourselves.
public interface ProductRepository extends JpaRepository<Product, Long> {
}
