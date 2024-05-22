package com.example.showroom.controller;

import com.example.showroom.model.dto.InfoMessageDto;
import com.example.showroom.model.dto.RequestedAddSaleDto;
import com.example.showroom.model.dto.RespClothesDto;
import com.example.showroom.model.dto.RespSalesDto;
import com.example.showroom.service.ISalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SalesController {

    private final ISalesService salesService;

    @PostMapping
    public ResponseEntity<InfoMessageDto> addSale(
            @RequestBody RequestedAddSaleDto newSale
    ) {
        InfoMessageDto response = salesService.addSale(newSale);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RespSalesDto>> getAllSales() {
        List<RespSalesDto> response = salesService.getAllSales();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespSalesDto> getSalesById(@PathVariable Long id) {
        RespSalesDto respSalesDto = salesService.getSaleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(respSalesDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespSalesDto> updateSale(
            @PathVariable Long id,
            @RequestBody RequestedAddSaleDto updatedSale
    ) {
        RespSalesDto respSalesDto = salesService.updateSale(id, updatedSale);
        return ResponseEntity.ok(respSalesDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InfoMessageDto> deleteSale(@PathVariable Long id) {
        InfoMessageDto response = salesService.deleteSaleById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RespSalesDto>> getSalesByDate(
            @RequestParam String date
    ) {
        List<RespSalesDto> response = salesService.getSalesByDate(date);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<List<RespClothesDto>> getClothesBySaleId(@PathVariable Long id) {
        List<RespClothesDto> response = salesService.getClothesBySale(id);
        return ResponseEntity.ok(response);
    }
}
