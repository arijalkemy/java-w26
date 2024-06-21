package com.mercadolibre.pf_be_hisp_w26_t1_cassini.controller;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;


    @GetMapping(path = "/list")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatusCode.valueOf(200));
    }

    @GetMapping(path = "/list",params = {"category"})
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByCategory(@RequestParam("category") String category) {
        return new ResponseEntity<>(productService.getAllByCategory(category), HttpStatusCode.valueOf(200));
    }

}
