package com.example.showroom.controller;

import com.example.showroom.model.dto.RequesUpdateClotheDTO;
import com.example.showroom.model.dto.RequestAddClotheDTO;
import com.example.showroom.service.IClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class ClothesController {

    private final IClothesService clothesService;

    @PostMapping
    public ResponseEntity<?> addClothe(@RequestBody RequestAddClotheDTO clothe){
        return ResponseEntity.status(HttpStatus.CREATED).body(clothesService.createClothes(clothe));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.getAllClothes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.getClothes(id));
    }

    @PutMapping
    public ResponseEntity<?> editClothe(@RequestBody RequesUpdateClotheDTO clothe) {
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.updateClothes(clothe));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteClothe(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.deleteClothes(id));
    }

    @GetMapping("/asdasd/{size}")
    public ResponseEntity<?> getAllBySize(@PathVariable String size) {
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.getAllClothesBySize(size));
    }

    @GetMapping("/byname")
    public ResponseEntity<?> getAllByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.getAllClothesByName(name));
    }

}
