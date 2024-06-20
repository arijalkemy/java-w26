package com.mercadolibre.pf_be_hisp_w26_t10_garcia.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    @GetMapping("/api/v1/fresh-products/{idProduct}/warehouse/list")
    public ResponseEntity<?> getItemQtyByWh(@PathVariable Integer idProduct) {
        return new ResponseEntity<>(this.productService.getProductWh(idProduct), HttpStatus.OK);
    }
}
