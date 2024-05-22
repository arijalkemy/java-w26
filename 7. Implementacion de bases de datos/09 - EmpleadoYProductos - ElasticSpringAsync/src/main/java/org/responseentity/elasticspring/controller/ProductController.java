package org.responseentity.elasticspring.controller;

import org.responseentity.elasticspring.dto.request.ProductRequestDto;
import org.responseentity.elasticspring.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping
    public ResponseEntity<?> postProduct(@RequestBody ProductRequestDto productRequestDto){
        return new ResponseEntity<>(iProductService.addProduct(productRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putProduct(@PathVariable String id, @RequestBody ProductRequestDto productRequestDto){
        return new ResponseEntity<>(iProductService.editProduct(id, productRequestDto), HttpStatus.OK);
    }

}
