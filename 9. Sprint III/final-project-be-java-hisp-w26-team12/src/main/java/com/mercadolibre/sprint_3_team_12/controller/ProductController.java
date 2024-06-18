package com.mercadolibre.sprint_3_team_12.controller;

import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12.service.IProductService;
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
}
