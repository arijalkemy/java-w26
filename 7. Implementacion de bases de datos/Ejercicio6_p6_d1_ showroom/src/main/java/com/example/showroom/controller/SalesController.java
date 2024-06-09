package com.example.showroom.controller;

import com.example.showroom.service.ISalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SalesController {

    private final ISalesService salesService;

    @PostMapping()
    public ResponseEntity<?> addSale() {
        return ResponseEntity.status(HttpStatus.CREATED).body("metodo");
    }

    @GetMapping()
    public ResponseEntity<?> getAllSales() {
        return ResponseEntity.status(HttpStatus.OK).body(salesService.getClass());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSalesByNumber(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("metodo");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSale(){
        return ResponseEntity.status(HttpStatus.OK).body("metodo");
    }

}
