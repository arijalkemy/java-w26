package com.example.demo.controller;

import com.example.demo.model.dto.clothesDTO.ClothesRequestDTO;
import com.example.demo.model.dto.clothesDTO.ClothesResponseDTO;
import com.example.demo.service.clothesService.ClothesServiceImpl;
import com.example.demo.service.clothesService.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clothes")
public class ClothesController {

    private final IClothesService clothesService;

    @Autowired
    public ClothesController(ClothesServiceImpl clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping
    public ResponseEntity<ClothesResponseDTO> addClothes(@RequestBody ClothesRequestDTO clothes) {
        return new ResponseEntity<>(clothesService.createClothes(clothes), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClothesResponseDTO>> getAllClothes() {
        return new ResponseEntity<>(clothesService.getAllClothes(), HttpStatus.OK);
    }

    @GetMapping("{code}")
    public ResponseEntity<ClothesResponseDTO> getClothesByCode(@PathVariable Long code) {
        return new ResponseEntity<>(clothesService.getClothesByCode(code), HttpStatus.OK);
    }

    @PutMapping("{code}")
    public ResponseEntity<ClothesResponseDTO> updateClothes(@PathVariable Long code, ClothesRequestDTO clothes) {
        return new ResponseEntity<>(clothesService.updateClothes(code, clothes), HttpStatus.OK);
    }

    @DeleteMapping("{code}")
    public ResponseEntity<String> deleteClothes(@PathVariable Long code) {
        return new ResponseEntity<>( clothesService.deleteClothes(code), HttpStatus.OK);
    }

    @GetMapping("size/{size}")
    public ResponseEntity<List<ClothesResponseDTO>> getClothesBySize(@PathVariable String size) {
        return new ResponseEntity<>(clothesService.getClothesBySize(size), HttpStatus.OK);
    }

    @GetMapping("type")
    public ResponseEntity<List<ClothesResponseDTO>> getClothesByType(@RequestParam String type) {
        return new ResponseEntity<>(clothesService.getClothesByType(type), HttpStatus.OK);
    }
}
