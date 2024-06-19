package com.mercadolibre.sprint3_individual_perez.controller;

import com.mercadolibre.sprint3_individual_perez.dto.request.ProductRequestDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint3_individual_perez.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/fresh-products/")
public class ProductController {
    /** UTIL AND SCALABILITY CONTROLLER
     *
     */
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    ResponseEntity<ResponseProductDTO> getProducts(@RequestParam(required = false) String category) {
        return ResponseEntity.ok(productService.selectMethod(category));
    }

    @PostMapping("/new-product")
    ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

}
