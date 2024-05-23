package org.example.showroom.controller;

import org.apache.coyote.Response;
import org.example.showroom.dto.clothe.ClotheResponseDto;
import org.example.showroom.dto.sale.SaleRequestDto;
import org.example.showroom.dto.sale.SaleResponseDto;
import org.example.showroom.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    private final ISaleService saleService;

    public SaleController(@Autowired ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleResponseDto> save(@RequestBody SaleRequestDto sale) {
        return new ResponseEntity<>(saleService.save(sale), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDto>> getAll() {
        return new ResponseEntity<>(saleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<List<ClotheResponseDto>> getClothesSale(@PathVariable Long id) {
        return new ResponseEntity<>(saleService.findClothes(id), HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<SaleResponseDto> delete(@RequestParam("id") Long id) {
        saleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
