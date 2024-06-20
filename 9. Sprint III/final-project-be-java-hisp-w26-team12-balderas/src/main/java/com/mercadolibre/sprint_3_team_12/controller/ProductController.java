package com.mercadolibre.sprint_3_team_12.controller;

import com.mercadolibre.sprint_3_team_12.dto.request.ProductAddDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductInjectionDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.MessageDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    /**
     * Endpoint used to create a list of products, Req 6
     * @param productInjectionDTO
     * @return
     */
    @PostMapping("/createproduct")
    ResponseEntity<?> postProducts(@RequestBody ProductInjectionDTO productInjectionDTO){
        return new ResponseEntity<>(productService.postProducts(productInjectionDTO), HttpStatus.CREATED);
    }


    /**
     * Endpoint used to update a  product, Req 6
     * @param productAddDTO
     * @return
     */
    @PutMapping("/updateproduct")
    ResponseEntity<?> updateProduct(@RequestBody ProductAddDTO productAddDTO){
        return new ResponseEntity<>(productService.updateProduct(productAddDTO), HttpStatus.CREATED);
    }
}
