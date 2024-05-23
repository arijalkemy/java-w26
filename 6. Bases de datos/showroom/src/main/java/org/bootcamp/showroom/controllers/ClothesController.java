package org.bootcamp.showroom.controllers;

import lombok.RequiredArgsConstructor;
import org.bootcamp.showroom.dtos.ClotheResponseDto;
import org.bootcamp.showroom.dtos.ClotheUpdateDto;
import org.bootcamp.showroom.dtos.ClothesRequestDto;
import org.bootcamp.showroom.dtos.MessageResponseDTO;
import org.bootcamp.showroom.services.IClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class ClothesController {

    private final IClothesService clothesService;

    @PostMapping()
    public ResponseEntity<ClotheResponseDto> createNewClothe(@RequestBody ClothesRequestDto clothe){
        return ResponseEntity.status(HttpStatus.CREATED).body(clothesService.create(clothe));
    }

    @GetMapping()
    public ResponseEntity<List<ClotheResponseDto>> getAllClothesOrByName(@RequestParam String name){
        if(name != null && !name.isEmpty()) return ResponseEntity.ok(clothesService.getAllClothesByName(name));
        return ResponseEntity.ok(clothesService.getAllClothes());
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ClotheResponseDto> getByCode(@PathVariable String code){
        return ResponseEntity.ok(clothesService.getByCode(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClotheResponseDto> updateClothe(@PathVariable String code, @RequestBody ClotheUpdateDto clothe){
        return ResponseEntity.ok(clothesService.update(code, clothe));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageResponseDTO> deleteClothe(@PathVariable String code){
        return ResponseEntity.ok(clothesService.delete(code));
    }

    @GetMapping("/waist/{waist}")
    public ResponseEntity<List<ClotheResponseDto>> getAllByWaist(@PathVariable String waist){
        return ResponseEntity.ok(clothesService.getAllClothesByWaist(waist));
    }

}
