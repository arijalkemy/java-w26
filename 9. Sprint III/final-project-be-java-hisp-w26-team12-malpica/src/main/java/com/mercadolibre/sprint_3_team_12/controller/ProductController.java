package com.mercadolibre.sprint_3_team_12.controller;

import com.mercadolibre.sprint_3_team_12.dto.request.ProductNameDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    /**
     * Req 06 - US 0006
     * Post a new product
     */
    @PostMapping("/addProduct")
    ResponseEntity<?> postProduct(@RequestBody ProductNameDTO newProduct) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.postProduct(newProduct));
    }

    /**
     * Req 06
     * Modifiy a product
     */
    @PutMapping("/modifyProduct")
    ResponseEntity<?> putProduct(@RequestBody ProductNameDTO product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.putProduct(product));
    }

    /**
     * Req 06
     * Controller to get all products, now with the name of the product
     */
    @GetMapping("/listProdName")
    ResponseEntity<List<ProductNameDTO>> getProductsWithName() {
        return ResponseEntity.ok(productService.getAllProductsWithName());
    }

}
