package com.mercadolibre.clothes.controller;

import com.mercadolibre.clothes.dto.cloth.ClothRequestDTO;
import com.mercadolibre.clothes.dto.cloth.ClothResponseDTO;
import com.mercadolibre.clothes.service.cloth.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {
    @Autowired
    IClothesService clothesService;

    @PostMapping
    public ResponseEntity<Long> createCloth(@RequestBody ClothRequestDTO clothRequestDTO){
        return new ResponseEntity<>(clothesService.createCloth(clothRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClothResponseDTO>> getClothes(@RequestParam(required = false) String type){
        return ResponseEntity.ok(clothesService.getAllClothes(type));
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothResponseDTO> getCloth(@PathVariable Long code){
        return ResponseEntity.ok(clothesService.getClothByCode(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClothResponseDTO> updateCloth(@PathVariable Long code, ClothRequestDTO clothRequestDTO){
        return ResponseEntity.ok(clothesService.updateClothByCode(code, clothRequestDTO));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteCloth(@PathVariable Long code){
        clothesService.deleteCloth(code);
        return ResponseEntity.ok("Cloth deleted successfully");
    }

    @GetMapping("/{size}")
    public ResponseEntity<List<ClothResponseDTO>> getClothes(@PathVariable Integer size){
        return ResponseEntity.ok(clothesService.getClothesBySize(size));
    }
}
