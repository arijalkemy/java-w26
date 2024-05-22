package com.w26.elasticsearch.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.elasticsearch.elasticsearch.dto.ProductDTO;
import com.w26.elasticsearch.elasticsearch.service.interfaces.IProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    IProductService productService;

    @GetMapping("") 
    public ResponseEntity<?> getProductos() {
        return ResponseEntity.ok().body(productService.getAllProducts()); 
    }

    @PostMapping("")
    public ResponseEntity<?> postProductos(@Valid @RequestBody ProductDTO product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product)); 
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putProductos(@PathVariable String id, @Valid @RequestBody ProductDTO product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
    }

}
