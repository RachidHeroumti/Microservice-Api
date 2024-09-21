package com.mico_springboot.ProductService.service;

import com.mico_springboot.ProductService.dto.ProductRequest;
import com.mico_springboot.ProductService.dto.ProductResponse;
import com.mico_springboot.ProductService.model.Product;
import com.mico_springboot.ProductService.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRepo productRepo ;

    public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest) {
        Product product = buildProductFromRequest(productRequest);

        try {
            productRepo.save(product);
            log.info("Product {} is saved", product.getId());
        } catch (DataAccessException e) {
            log.error("Error while saving product", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        ProductResponse productResponse = convertToProductResponse(product);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }


    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        try {
            List<Product> products = productRepo.findAll();

            if (products.isEmpty()) {
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
            }
            List<ProductResponse> productResponses = products.stream()
                    .map(this::convertToProductResponse)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(productResponses, HttpStatus.OK);
        } catch (DataAccessException e) {
            log.error("Error while getting products", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    private Product buildProductFromRequest(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }

    private ProductResponse convertToProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }

}
