package org.ggomezr.showroommysql.application.controller;

import org.ggomezr.showroommysql.application.service.interfaces.IClothingService;
import org.ggomezr.showroommysql.application.service.interfaces.ISaleService;
import org.ggomezr.showroommysql.domain.dto.SaleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping()
    public ResponseEntity<?> createSale(@RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(saleService.createSale(saleDTO), HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createSalesBatch(@RequestBody List<SaleDTO> saleDTOList) {
        return new ResponseEntity<>(saleService.createSalesBatch(saleDTOList), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllSales() {
        return new ResponseEntity<>(saleService.getAllSales(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getSaleById(@PathVariable Long code) {
        return new ResponseEntity<>(saleService.getSaleById(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateSale(@RequestBody SaleDTO saleDTO, @PathVariable Long code) {
        return new ResponseEntity<>(saleService.updateSale(saleDTO, code), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteSale(@PathVariable Long code) {
        return new ResponseEntity<>(saleService.deleteSale(code), HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<?> getSalesByDate(@RequestParam LocalDate date) {
        return new ResponseEntity<>(saleService.getSalesByDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{code}")
    public ResponseEntity<?> getSaleByCode(@PathVariable Long code) {
        return new ResponseEntity<>(saleService.getSaleByCode(code), HttpStatus.OK);
    }
}
