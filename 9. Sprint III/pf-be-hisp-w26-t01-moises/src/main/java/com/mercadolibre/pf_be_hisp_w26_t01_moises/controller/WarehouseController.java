package com.mercadolibre.pf_be_hisp_w26_t01_moises.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IWarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fresh-products")
@RequiredArgsConstructor
public class WarehouseController {
    private final IWarehouseService warehouseService;


    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<?> getStockWarehouseByProductId(@PathVariable Integer idProduct){
        return new ResponseEntity<>(warehouseService.findStockWarehouseByProductId(idProduct), HttpStatus.OK);
    }
}
