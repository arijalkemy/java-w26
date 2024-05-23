package org.example.showroomsql.controller;

import org.example.showroomsql.dto.RequestSaleDTO;
import org.example.showroomsql.dto.ResponseClothesDTO;
import org.example.showroomsql.dto.ResponseSaleDTO;
import org.example.showroomsql.service.IClothesService;
import org.example.showroomsql.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/sale")
public class SaleController {

    @Autowired
    ISaleService service;

    @PostMapping()
    private ResponseEntity<ResponseSaleDTO> createSale(@RequestBody RequestSaleDTO request){
        return ResponseEntity.ok(service.createSale(request));
    }

    @GetMapping()
    private ResponseEntity<List<ResponseSaleDTO>> getAllSales(){
        return ResponseEntity.ok(service.getAllSales());
    }

    @GetMapping("/{number}")
    private ResponseEntity<ResponseSaleDTO> getSaleByNumber(@PathVariable Long number){
        return ResponseEntity.ok(service.getSaleByNumber(number));
    }

    @PutMapping("/{number}")
    private ResponseEntity<ResponseSaleDTO> updateSale(@PathVariable Long number, @RequestBody RequestSaleDTO request){
        return ResponseEntity.ok(service.updateSale(number, request));
    }

    @DeleteMapping("/{number}")
    private ResponseEntity<String> deleteSale(@PathVariable Long number){
        return ResponseEntity.ok(service.deleteSale(number));
    }

    @GetMapping("/clothes/{number}")
    private ResponseEntity<List<ResponseClothesDTO>> getClothesBySale(@PathVariable Long number){
        return ResponseEntity.ok(service.getClothesBySale(number));
    }

    @GetMapping(params = "date")
    private ResponseEntity<List<ResponseClothesDTO>> getSalesByDate(@RequestParam LocalDate date){
        return ResponseEntity.ok(service.getSalesByDate(date));
    }
}
