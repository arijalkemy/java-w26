package com.example.productoselastic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productoselastic.dto.ProductRequestDto;
import com.example.productoselastic.dto.ProductResponseDto;
import com.example.productoselastic.service.IProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    IProductService productService;


    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        return new ResponseEntity<>(productService.create(productRequestDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestParam String id, @RequestBody ProductRequestDto productRequestDto)
    {
        return new ResponseEntity<>(
            productService.update(id, productRequestDto),
            HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProduct()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.CREATED);
    }
}
