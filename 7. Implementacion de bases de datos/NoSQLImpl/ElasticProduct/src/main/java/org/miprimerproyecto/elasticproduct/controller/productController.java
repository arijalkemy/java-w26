package org.miprimerproyecto.elasticproduct.controller;

import org.miprimerproyecto.elasticproduct.entity.Product;
import org.miprimerproyecto.elasticproduct.service.imp.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private productService productService;

    @GetMapping("/list")
    public String list() {
        return productService.findAll().toString();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }
}
