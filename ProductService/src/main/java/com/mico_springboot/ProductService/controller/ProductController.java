package com.mico_springboot.ProductService.controller;

import com.mico_springboot.ProductService.dto.ProductRequest;
import com.mico_springboot.ProductService.dto.ProductResponse;
import com.mico_springboot.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/product/")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("create")
    public ResponseEntity<ProductResponse> CreateProduct(@RequestBody ProductRequest p){
        return productService.createProduct(p);
    }
    @GetMapping("get-all")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return productService.getAllProducts();
    }
}
