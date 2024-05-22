package com.example.showroom.controller;

import com.example.showroom.dto.request.ClothRequestDTO;
import com.example.showroom.dto.response.ClothDTO;
import com.example.showroom.dto.response.MessageDTO;
import com.example.showroom.service.IClothesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clothes")
public class ClothesController {
    private final IClothesService clothesService;

    @PostMapping()
    public ResponseEntity<MessageDTO> addNewClothe(@RequestBody ClothRequestDTO clothe){
        MessageDTO message = clothesService.addNewCloth(clothe);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ClothDTO>> getAllClothes(
            @RequestParam(required = false, name = "name") String name
    ){
        List<ClothDTO> clothes = clothesService.showAllClothes(name);
        return ResponseEntity.ok().body(clothes);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothDTO> getClotheByCode(
            @PathVariable Long code
    ) {
        return new ResponseEntity<>(
                clothesService.searchClothByCode(code),
                HttpStatus.OK
        );
    }

    @PutMapping("/{code}")
    public ResponseEntity<MessageDTO> putClotheByCode(
            @PathVariable Long code,
            @RequestBody ClothRequestDTO clothe
    ) {
        return new ResponseEntity<>(
                clothesService.updateClothByCode(code,clothe),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageDTO> deleteClothe(
            @PathVariable Long code
    ) {
        clothesService.deleteCloth(code);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{size}")
    public ResponseEntity<List<ClothDTO>> getClothesBySize(@PathVariable Integer size) {
        return ResponseEntity.ok().body(clothesService.getClothesBySize(size));
    }
}
