package com.implementaciondb.ejercicio10_showroom.controller;

import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleResponseDto;
import com.implementaciondb.ejercicio10_showroom.service.interfaces.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponseDto> createSale(@RequestBody SaleRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.saveSale(saleRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDto>> getAllSales() {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findAllSales());
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleResponseDto> getSaleById(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findSaleById(number));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<SaleResponseDto> deleteSaleById(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.deleteSaleById(number));
    }

    @GetMapping(params = "date")
    public ResponseEntity<List<GarmentResponseDto>> getClothesByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findClothesByDate(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<GarmentResponseDto>> getClothesBySale(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findClothesBySale(number));
    }

}
