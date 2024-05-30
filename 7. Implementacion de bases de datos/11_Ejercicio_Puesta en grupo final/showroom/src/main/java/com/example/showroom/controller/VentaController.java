package com.example.showroom.controller;

import com.example.showroom.dto.PrendaResponseDto;
import com.example.showroom.dto.VentaDto;
import com.example.showroom.dto.VentaResponseDto;
import com.example.showroom.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    @Autowired
    IVentaService service;

    @PostMapping
    public ResponseEntity<VentaResponseDto> createSale(@RequestBody VentaDto ventaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveSale(ventaDto));
    }

    public ResponseEntity<List<VentaResponseDto>> getAllSales() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllSales());
    }

    @GetMapping("/{number}")
    public ResponseEntity<VentaResponseDto> getSaleById(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findSaleById(number));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteSaleById(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteSaleById(number));
    }

    @GetMapping(params = "date")
    public ResponseEntity<List<PrendaResponseDto>> getClothesByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findClothesByDate(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<PrendaResponseDto>> getClothesBySale(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findClothesBySale(number));
    }

}
