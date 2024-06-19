package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller responsible for /fresh-products implementation.
 */
@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    IProductService productService;

    /**
     * Get all data about item by warehause
     *
     * @param idProduct Item number to search
     * @return Data about quantities per warehouse
     */
    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<?> getItemQtyByWh(@PathVariable Integer idProduct) {
        return new ResponseEntity<>(this.productService.getProductWh(idProduct), HttpStatus.OK);
    }

    /**
     * @return "List<Product>" List All Products
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProductsGeneralDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getProducts());
    }

}
