package com.example.showroom_vivo.controller;

import com.example.showroom_vivo.dto.ClothesDTO;
import com.example.showroom_vivo.dto.ResponseDTO;
import com.example.showroom_vivo.service.IClothesService;
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
    public ResponseEntity<ResponseDTO> postCreateClothes(@RequestBody ClothesDTO clothes){
        return ResponseEntity.status(HttpStatus.CREATED).body(clothesService.createClothes(clothes));
    }

    @GetMapping
    public ResponseEntity<List<ClothesDTO>> getAllClothes(){
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.getAllClothes());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothesDTO> getClothesByCode(@PathVariable Long code){
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.getClothesById(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ResponseDTO> putUpdateClothes(@PathVariable Long code, @RequestBody ClothesDTO clothes){
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.updateClothes(code, clothes));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<ResponseDTO> deleteClothes(@PathVariable Long code){
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.deleteClothes(code));
    }

    @GetMapping("/filter/{size}")
    public ResponseEntity<List<ClothesDTO>> getClothesBySize(@PathVariable Double size){
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.getClothesBySize(size));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ClothesDTO>> getClothesByName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(clothesService.getClothesByName(name));
    }

}
