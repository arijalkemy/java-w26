package com.example.showroom.controller;

import com.example.showroom.model.dto.*;
import com.example.showroom.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SalesController {

    @Autowired
    private ISalesService salesService;

    @PostMapping()
    public ResponseEntity<InfoMessageDto> addSale(@RequestBody RequestedAddSaleDto newSale) {
        return new ResponseEntity<>(salesService.addSale(newSale), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<RespSalesDto>> getAllSales() {
        return new ResponseEntity<>(salesService.getAllSales(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespSalesDto> getSalesById(@PathVariable Long id) {
        return new ResponseEntity<>(salesService.getSalesById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfoMessageDto> updateSale(@PathVariable Long id, @RequestBody RequestUpdateSaleDto updatedSale) {
        if (!id.equals(updatedSale.getId())) {
            return new ResponseEntity<>(new InfoMessageDto("ID en la ruta y en el cuerpo de la solicitud no coinciden"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(salesService.updateSale(updatedSale), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InfoMessageDto> deleteSaleById(@PathVariable Long id) {
        return new ResponseEntity<>(salesService.deleteSaleById(id), HttpStatus.OK);
    }

    @GetMapping(params = "date")
    public ResponseEntity<List<RespSalesDto>> getSalesByDate(@RequestParam String date) {
        return new ResponseEntity<>(salesService.getSalesByDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<List<RespClothesDto>> getClothesBySale(@PathVariable Long id) {
        return new ResponseEntity<>(salesService.getClothesBySale(id), HttpStatus.OK);
    }
}