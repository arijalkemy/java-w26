package com.mercadolibre.clothes.controller;

import com.mercadolibre.clothes.dto.cloth.ClothResponseDTO;
import com.mercadolibre.clothes.dto.sale.SaleRequestDTO;
import com.mercadolibre.clothes.dto.sale.SaleResponseDTO;
import com.mercadolibre.clothes.service.sale.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/sale")
public class SalesController {
    @Autowired
    ISalesService salesService;

    @PostMapping
    public ResponseEntity<Long> createSale(@RequestBody SaleRequestDTO saleRequestDTO){
        return new ResponseEntity<>(salesService.createSale(saleRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAllSales(@RequestParam(required = false) String date){
        return ResponseEntity.ok(salesService.getAllSales(date));
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleResponseDTO> getSale(@PathVariable Long number){
        return ResponseEntity.ok(salesService.getSaleById(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleResponseDTO> updateSale(@PathVariable Long number, SaleRequestDTO saleRequestDTO){
        return ResponseEntity.ok(salesService.updateSale(number, saleRequestDTO));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteSale(@PathVariable Long number){
        salesService.deleteSale(number);
        return new ResponseEntity<>("Sale deleted", HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<Set<ClothResponseDTO>> getClothesFromSale(@PathVariable Long number){
        return ResponseEntity.ok(salesService.getClothesFromSale(number));
    }
}
