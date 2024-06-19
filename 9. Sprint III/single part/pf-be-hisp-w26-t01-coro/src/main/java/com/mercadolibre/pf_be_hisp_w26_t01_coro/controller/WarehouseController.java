package com.mercadolibre.pf_be_hisp_w26_t01_coro.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.IWarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products")
@RequiredArgsConstructor
public class WarehouseController {
    private final IWarehouseService warehouseService;


    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<?> getStockWarehouseByProductId(@PathVariable Integer idProduct){
        return new ResponseEntity<>(warehouseService.findStockWarehouseByProductId(idProduct), HttpStatus.OK);
    }
    @PostMapping("/warehouse")
    public ResponseEntity<?> createWarehouse(@RequestBody WarehouseRequestDTO warehouseRequestDTO){
        return new ResponseEntity<>(warehouseService.createWarehouse(warehouseRequestDTO), HttpStatus.CREATED);
    }
}
