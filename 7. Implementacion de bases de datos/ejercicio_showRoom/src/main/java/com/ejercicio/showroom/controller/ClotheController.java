package com.ejercicio.showroom.controller;

import com.ejercicio.showroom.dto.MessageResponseDTO;
import com.ejercicio.showroom.dto.ClotheDTO;
import com.ejercicio.showroom.entities.Clothe;
import com.ejercicio.showroom.service.interfaces.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClotheController {
    @Autowired
    private IClotheService clotheService;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> createClothe(@RequestBody ClotheDTO postRequestDTO) {
        return ResponseEntity.ok(
                clotheService.createClothe(postRequestDTO)
        );
    }

    @GetMapping
    public ResponseEntity<List<Clothe>> getAllClothes() {
        return ResponseEntity.ok(
            clotheService.getAllClothes()
        );
    }

    @GetMapping("/{code}")
    public ResponseEntity<Clothe> getClotheByCode(@PathVariable long code) {
        return ResponseEntity.ok(
                clotheService.getClotheByCode(code)
        );
    }

    @PutMapping("/{code}")
    public ResponseEntity<Clothe> updateClothe(@PathVariable long code, @RequestBody ClotheDTO clotheDTO) {
        return ResponseEntity.ok(
                clotheService.updateClothe(code, clotheDTO)
        );
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageResponseDTO> deleteClothe(@PathVariable long code) {
        return ResponseEntity.ok(
                clotheService.deleteClothe(code)
        );
    }

    @GetMapping("/bySize/{waist}")
    public ResponseEntity<List<Clothe>> getAllByWaist(@PathVariable String waist) {
        return ResponseEntity.ok(
                clotheService.getAllClothesByWaist(waist)
        );
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Clothe>> getAllByName(@RequestParam String name) {
        return ResponseEntity.ok(
                clotheService.getAllClothesByName(name)
        );
    }
}
