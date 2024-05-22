package org.example.showroom.controller;


import org.example.showroom.DTO.RequestClothesDTO;
import org.example.showroom.DTO.ResponseClothesDTO;
import org.example.showroom.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    private IClothesService clothesService;

    @PostMapping
    public ResponseEntity<ResponseClothesDTO> createClothes(@RequestBody RequestClothesDTO requestClothesDTO) {
        return new ResponseEntity<>(clothesService.createClothes(requestClothesDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseClothesDTO>> getAllClothes(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(clothesService.getAllClothes(name), HttpStatus.OK);
    }

    @GetMapping("code/{code}")
    public ResponseEntity<ResponseClothesDTO> getClothesByCode(@PathVariable Long code) {
        return new ResponseEntity<>(clothesService.getClothesByCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ResponseClothesDTO> updateClothes(@PathVariable Long code, @RequestBody RequestClothesDTO requestClothesDTO) {
        return new ResponseEntity<>(clothesService.updateClothes(code, requestClothesDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteClothes(@PathVariable Long code) {
        clothesService.deleteClothes(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("size/{size}")
    public ResponseEntity<List<ResponseClothesDTO>> getClothesBySize(@PathVariable float size) {
        return new ResponseEntity<>(clothesService.getClothesBySize(size), HttpStatus.OK);
    }

}
