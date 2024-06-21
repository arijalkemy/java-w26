package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.controller;


import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations.SearchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class FrescosController {

    @Autowired
    private SearchServiceImp searchServiceImp;


    /**
     * US-03: supports filtered and unfiltered searches
     * @param idProduct
     * @param order
     * @return
     */
    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/fresh-products/{idProduct}/batch/list")
    public ResponseEntity<?> getFescos(@PathVariable Integer idProduct, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(searchServiceImp.searchProduct(idProduct, order), HttpStatus.OK);
    }


}
