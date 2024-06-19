package com.ejerciciosjpa.extrajpa.controller;

import com.ejerciciosjpa.extrajpa.dto.SaleRequestDto;
import com.ejerciciosjpa.extrajpa.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    ISaleService saleService;
    @PostMapping
    public ResponseEntity<?> addSale(@RequestBody SaleRequestDto request){
        return new ResponseEntity<>(saleService.createSale(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllSales(){
        return new ResponseEntity<>(saleService.getAllSales(),HttpStatus.OK);
    }
    @GetMapping("/number/{number}")
    public ResponseEntity<?> getSalesBynumber(@PathVariable Long number){
        return new ResponseEntity<>(saleService.getSaleById(number),HttpStatus.OK);
    }
    @PutMapping("/{number}")
    public ResponseEntity<?> updateSale(@PathVariable Long number, @RequestBody SaleRequestDto request){
        return new ResponseEntity<>(saleService.updateSale(number,request),HttpStatus.OK);
    }
    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable Long number){
        saleService.deleteSale(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("date/{date}")
    public ResponseEntity<?> getSalesByDate(@PathVariable LocalDate date){
        return new ResponseEntity<>(saleService.getAllSalesByDate(date),HttpStatus.OK);
    }
    @GetMapping("cloth/{number}")
    public ResponseEntity<?> getClothesByNumber(@PathVariable Long number){
        return new ResponseEntity<>(saleService.getAllClothesBySale(number),HttpStatus.OK);
    }


}
