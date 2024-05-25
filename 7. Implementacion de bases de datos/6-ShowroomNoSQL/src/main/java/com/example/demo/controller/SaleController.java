package com.example.demo.controller;

import com.example.demo.model.dto.clothesDTO.ClothesResponseDTO;
import com.example.demo.model.dto.saleDTO.SaleRequestDTO;
import com.example.demo.model.dto.saleDTO.SaleResponseDTO;
import com.example.demo.service.saleService.ISaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/sale")
public class SaleController {

    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleResponseDTO> save(@RequestBody SaleRequestDTO sale){
        return new ResponseEntity<>(saleService.createSale(sale), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> findAll(){
        return new ResponseEntity<>(saleService.getSales(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(saleService.getSaleById(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> update(@PathVariable Long id, @RequestBody SaleRequestDTO sale){
        return new ResponseEntity<>(saleService.updateSale(id, sale), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<>(saleService.deleteSale(id), HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<ClothesResponseDTO>> findAllByLocalDate(@RequestParam LocalDate date){
        return new ResponseEntity<>(saleService.getClothesSoldOnDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<List<ClothesResponseDTO>> findAllClothesBySaleId(@PathVariable Long id){
        return new ResponseEntity<>(saleService.getClothesBySale(id), HttpStatus.OK);
    }
}
