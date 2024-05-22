package com.showroom.showroomelastic.controller;

import com.showroom.showroomelastic.dto.ClothResponseDTO;
import com.showroom.showroomelastic.dto.SaleRequestDTO;
import com.showroom.showroomelastic.dto.SaleResponseDto;
import com.showroom.showroomelastic.service.ISaleService;
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
    public ResponseEntity<SaleResponseDto> addSale(@RequestBody SaleRequestDTO sale) {
        return new ResponseEntity<>(saleService.save(sale), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDto>> getAllSales() {
        return new ResponseEntity<>(saleService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<SaleResponseDto> getSale(@PathVariable String code) {
        return new ResponseEntity<>(saleService.getById(code),HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<SaleResponseDto> updateCloth(@PathVariable String code,@RequestBody SaleRequestDTO sale) {
        return new ResponseEntity<>(saleService.update(code, sale),HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCloth(@PathVariable String code) {
        return new ResponseEntity<>(saleService.delete(code),HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<SaleResponseDto> getSaleByDate(@RequestParam String date) {
        return new ResponseEntity<>(saleService.getByDate(date),HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<ClothResponseDTO>> getClothes(@PathVariable String number) {
        return new ResponseEntity<>(saleService.getClothes(number),HttpStatus.OK);
    }

}
