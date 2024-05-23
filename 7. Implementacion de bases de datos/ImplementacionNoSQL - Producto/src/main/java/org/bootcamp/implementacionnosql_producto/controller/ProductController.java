package org.bootcamp.implementacionnosql_producto.controller;

import org.bootcamp.implementacionnosql_producto.dto.ProductDTO;
import org.bootcamp.implementacionnosql_producto.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }
}
