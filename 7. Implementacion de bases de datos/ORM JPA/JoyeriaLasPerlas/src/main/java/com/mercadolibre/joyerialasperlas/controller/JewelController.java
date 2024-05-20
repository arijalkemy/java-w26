package com.mercadolibre.joyerialasperlas.controller;

import com.mercadolibre.joyerialasperlas.dto.JewelDTO;
import com.mercadolibre.joyerialasperlas.dto.JewelResponseDTO;
import com.mercadolibre.joyerialasperlas.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {
    @Autowired
    private IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<Long> createJewel(@RequestBody JewelDTO jewel) {
        return new ResponseEntity<>(jewelService.createJewel(jewel), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<JewelResponseDTO>> getJewels() {
        return ResponseEntity.ok(jewelService.getAllJewels());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<JewelResponseDTO> deleteJewel(@PathVariable Long id) {
        return ResponseEntity.ok(jewelService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewelResponseDTO> updateJewel(@PathVariable Long id, @RequestBody JewelDTO updatedJewel) {
        return ResponseEntity.ok(jewelService.updateJewel(id, updatedJewel));
    }
}
