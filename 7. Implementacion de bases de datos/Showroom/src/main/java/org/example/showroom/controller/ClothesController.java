package org.example.showroom.controller;

import jakarta.validation.Valid;
import org.example.showroom.dto.clothe.ClotheRequestDto;
import org.example.showroom.dto.clothe.ClotheResponseDto;
import org.example.showroom.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {
    private final IClothesService clothesService;

    public ClothesController(@Autowired IClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @GetMapping
    public ResponseEntity<List<ClotheResponseDto>> getAllClothes(@RequestParam(defaultValue = "") String name) {
        return new ResponseEntity<>(clothesService.getAll(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClotheResponseDto> createClothe(@RequestBody @Valid ClotheRequestDto requestDto) {
        return new ResponseEntity<>(clothesService.save(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClotheResponseDto> getClotheById(@PathVariable Long id) {
        return new ResponseEntity<>(clothesService.getClotheById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClotheResponseDto> putClotheById(@PathVariable Long id, @RequestBody ClotheRequestDto requestDto) {
        return new ResponseEntity<>(clothesService.putClotheById(id, requestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClotheById(@PathVariable Long id) {
        clothesService.deleteClotheById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClotheResponseDto>> getClotheBySize(@PathVariable String size) {
        return new ResponseEntity<>(clothesService.getClotheBySize(size), HttpStatus.OK);
    }
}
