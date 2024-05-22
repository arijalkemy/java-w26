package com.example.showroomelastic.controller;

import com.example.showroomelastic.dto.PrendaRequestDto;
import com.example.showroomelastic.dto.PrendaResponseDto;
import com.example.showroomelastic.service.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClotheController {

    @Autowired
    IClotheService clotheService;

    @GetMapping
    public ResponseEntity<List<PrendaResponseDto>> getAll()
    {
        return new ResponseEntity<>(
                clotheService.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<PrendaResponseDto> getClotheById(@PathVariable String id)
    {
        return new ResponseEntity<>(
                clotheService.getClotheById(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<PrendaResponseDto> createClothe(@RequestBody PrendaRequestDto prendaRequestDto)
    {
        return new ResponseEntity<>(
                clotheService.createClothe(prendaRequestDto),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrendaResponseDto> updateClothe(@PathVariable String id, @RequestBody PrendaRequestDto prendaRequestDto)
    {
        return new ResponseEntity<>(
                clotheService.updateClothe(id, prendaRequestDto),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClothe(@PathVariable String id)
    {
        ;
        return new ResponseEntity<>(
                clotheService.deleteClothe(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<PrendaResponseDto>> getClothesBySize(@PathVariable String size)
    {
        return new ResponseEntity<>(
                clotheService.getClothesBySize(size),
                HttpStatus.OK
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<PrendaResponseDto>> searchClothes(@RequestParam String name)
    {
        return new ResponseEntity<>(
                clotheService.searchClothes(name),
                HttpStatus.OK
        );
    }


}
