package com.mercadolibre.sprint_3_team_12_malacara.controller;

import com.mercadolibre.sprint_3_team_12_malacara.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12_malacara.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/product/{sellerId}")
    ResponseEntity<ResponseProductDTO> getProductsBySeller(@PathVariable Long sellerId) {
        return ResponseEntity.ok(productService.getProductsBySeller(sellerId));
    }

    @GetMapping("/product/{sellerId}/{quantity}")
    ResponseEntity<ResponseProductDTO> getProductsBySellerAndQuantity(@PathVariable Long sellerId, @PathVariable double quantity) {
        return ResponseEntity.ok(productService.getProductsBySellerAndByQuantity(sellerId, quantity));
    }



}
