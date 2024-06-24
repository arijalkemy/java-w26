package com.mercadolibre.project_java_w26_team13.controller;

import com.mercadolibre.project_java_w26_team13.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

IProductService productService;

ProductController(IProductService productService){
    this.productService = productService;
}

    @GetMapping("/api/v1/fresh-products/list")
    public ResponseEntity<?> getList(@RequestHeader("Authorization") String authorizationHeader,
                                     @RequestParam(value = "category", required = false) String category) {

        return ResponseEntity.ok(productService.getProductListByCategory(authorizationHeader, category));

    }

//    @GetMapping("/api/v1/fresh-products/list")
//    public ResponseEntity<?> getList(@RequestHeader("Authorization") String authorizationHeader) {
//        return ResponseEntity.ok(productService.getProductList(authorizationHeader));
//    }
//
//    @GetMapping("/api/v1/fresh-products/list")
//    public ResponseEntity<?> getListByCategory(@RequestHeader("Authorization") String authorizationHeader,
//                                     @RequestParam("category") String category) {
//        return ResponseEntity.ok(productService.getProductListByCategory(authorizationHeader, category));
//    }
}
