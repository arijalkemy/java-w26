package org.ggomezr.showroommysql.application.controller;

import org.ggomezr.showroommysql.application.service.interfaces.IClothingService;
import org.ggomezr.showroommysql.domain.dto.ClothingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothingController {

    private final IClothingService clothingService;

    public ClothingController(IClothingService clothingService) {
        this.clothingService = clothingService;
    }

    @PostMapping()
    public ResponseEntity<?> createClothing(@RequestBody ClothingDTO clothingDTO){
        return new ResponseEntity<>(clothingService.createClothing(clothingDTO), HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createClothingBatch(@RequestBody List<ClothingDTO> clothingDTOList){
        return new ResponseEntity<>(clothingService.createClothingBatch(clothingDTOList), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClothing(){
        return new ResponseEntity<>(clothingService.getAllClothing(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getClothingById(@PathVariable Long code){
        return new ResponseEntity<>(clothingService.getClothingById(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateClothing(@PathVariable Long code, @RequestBody ClothingDTO clothingDTO){
        return new ResponseEntity<>(clothingService.updateClothing(code, clothingDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothing(@PathVariable Long code){
        return new ResponseEntity<>(clothingService.deleteClothing(code), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getClothingBySize(@PathVariable String size){
        return new ResponseEntity<>(clothingService.getClothingBySize(size), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getClothingByName(@RequestParam String name){
        return new ResponseEntity<>(clothingService.getClothingByName(name), HttpStatus.OK);
    }
}
