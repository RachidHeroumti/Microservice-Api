package com.mico_springboot.ProductService.repository;

import com.mico_springboot.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
