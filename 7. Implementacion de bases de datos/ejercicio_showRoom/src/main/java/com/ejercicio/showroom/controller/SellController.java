package com.ejercicio.showroom.controller;

import com.ejercicio.showroom.dto.ClotheDTO;
import com.ejercicio.showroom.dto.MessageResponseDTO;
import com.ejercicio.showroom.dto.SellDTO;
import com.ejercicio.showroom.service.interfaces.ISellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sells")
public class SellController {
    @Autowired
    private ISellService sellService;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> createSell(@RequestBody SellDTO sellDTO) {
        return ResponseEntity.ok(
                sellService.createSell(sellDTO)
        );
    }

    @GetMapping
    public ResponseEntity<List<SellDTO>> getAllSells() {
        return ResponseEntity.ok(
                sellService.getAllSells()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellDTO> getSellById(@PathVariable int id) {
        return ResponseEntity.ok(
                sellService.getSellById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SellDTO> updateSell(@PathVariable int id, @RequestBody SellDTO sellDTO) {
        return ResponseEntity.ok(
                sellService.updateSell(id, sellDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSell(@PathVariable int id) {
        sellService.deleteSell(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(params = "date")
    public ResponseEntity<List<SellDTO>> getAllSellsByDate(@RequestParam LocalDate date) {
        return ResponseEntity.ok(
                sellService.getAllByDate(date)
        );
    }

    @GetMapping("/clothes/{sellId}")
    public ResponseEntity<List<ClotheDTO>> getAllSellsByDate(@PathVariable int sellId) {
        return ResponseEntity.ok(
                sellService.getAllClothesFromSale(sellId)
        );
    }
}
