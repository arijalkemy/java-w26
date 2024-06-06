package org.example.integradorproductemployee.controller;

import lombok.RequiredArgsConstructor;
import org.example.integradorproductemployee.entity.dto.ProductDTO;
import org.example.integradorproductemployee.entity.dto.ProductUtilDTO;
import org.example.integradorproductemployee.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {


    private final IProductService productService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getProductById(@PathVariable String id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.ok("Created");
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?> updateProduct(@RequestBody ProductUtilDTO productUtilDTO){
        productService.updateProduct(productUtilDTO);
        return ResponseEntity.ok("Updated");
    }
}
