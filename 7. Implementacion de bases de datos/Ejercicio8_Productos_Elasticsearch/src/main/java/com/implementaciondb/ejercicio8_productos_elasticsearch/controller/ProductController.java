package com.implementaciondb.ejercicio8_productos_elasticsearch.controller;

import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ProductRequestDto;
import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ProductResponseDto;
import com.implementaciondb.ejercicio8_productos_elasticsearch.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable String id,
            @RequestBody ProductRequestDto product
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
    }

}
