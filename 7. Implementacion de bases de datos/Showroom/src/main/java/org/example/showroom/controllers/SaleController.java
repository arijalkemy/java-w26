package org.example.showroom.controllers;

import org.example.showroom.models.DTO.SaleRequestDTO;
import org.example.showroom.models.DTO.SaleResponseDTO;
import org.example.showroom.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    ISaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> postNewSale(@RequestBody SaleRequestDTO newSale) {
        return new ResponseEntity<>(saleService.createNewSale(newSale),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAllSales() {
        return new ResponseEntity<>(saleService.findAllSales(),HttpStatus.OK);
    }

    @GetMapping(value = "/{number}")
    public ResponseEntity<SaleResponseDTO> findSaleByNumber(@PathVariable Long number) {
        return new ResponseEntity<>(saleService.findSaleByNumber(number),HttpStatus.OK);
    }

}
