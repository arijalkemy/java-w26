package com.mercadolibre.Productos_NOSQL.controller;

import com.mercadolibre.Productos_NOSQL.dto.ProductRequestDto;
import com.mercadolibre.Productos_NOSQL.dto.ProductResponseDto;
import com.mercadolibre.Productos_NOSQL.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService service;

    @GetMapping("")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllProducts());
    }

    @PostMapping("")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable String id, @RequestBody ProductRequestDto product){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(id,product));
    }
}
