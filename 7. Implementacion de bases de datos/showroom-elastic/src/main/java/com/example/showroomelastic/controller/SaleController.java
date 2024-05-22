package com.example.showroomelastic.controller;

import com.example.showroomelastic.dto.SaleRequestDto;
import com.example.showroomelastic.dto.SaleResponseDto;
import com.example.showroomelastic.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    @Autowired
    ISaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponseDto> createSale(@RequestBody SaleRequestDto ventaRequestDto) {
        return new ResponseEntity<>(saleService.createSale(ventaRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDto>> getSales() {
        return new ResponseEntity<>(saleService.getSales(), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDto> getSaleById(@PathVariable String id) {
        return new ResponseEntity<>(saleService.getSaleById(id), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleResponseDto> updateSale(@PathVariable String id, @RequestBody SaleRequestDto ventaRequestDto) {
        return new ResponseEntity<>(saleService.updateSale(id, ventaRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable String id) {
        return new ResponseEntity<>(saleService.deleteSale(id), HttpStatus.CREATED);
    }

    @GetMapping("/searchByDate")
    public ResponseEntity<List<SaleResponseDto>> searchByDate(@RequestParam String date) {
        return new ResponseEntity<>(saleService.searchByDate(date), HttpStatus.CREATED);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<SaleResponseDto> searchByNumber(@PathVariable String number) {
        return new ResponseEntity<>(saleService.searchByNumber(number), HttpStatus.CREATED);
    }
}
