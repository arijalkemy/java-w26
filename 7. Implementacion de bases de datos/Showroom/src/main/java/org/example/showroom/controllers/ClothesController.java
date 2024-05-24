package org.example.showroom.controllers;

import org.example.showroom.models.DTO.ClothesRequestDTO;
import org.example.showroom.models.DTO.ClothesResponseDTO;
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
    IClothesService clothesService;

    @PostMapping
    ResponseEntity<ClothesResponseDTO> postNewClothes(@RequestBody ClothesRequestDTO clothes){
        return new ResponseEntity<>(clothesService.createNewClothes(clothes), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<ClothesResponseDTO>> getAllClothes(){
        return new ResponseEntity<>(clothesService.findAllClothes(),HttpStatus.OK);
    }

    @GetMapping("/{code}")
    ResponseEntity<ClothesResponseDTO> getClotheByCode(@PathVariable Long code){
        return new ResponseEntity<>(clothesService.findByCode(code),HttpStatus.OK);
    }

    @PutMapping("/{code}")
    ResponseEntity<ClothesResponseDTO> putClotheByCode(@PathVariable Long code, @RequestBody ClothesRequestDTO clothe){
        return new ResponseEntity<>(clothesService.updateClotheByCode(code, clothe),HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    ResponseEntity<String> deleteClotheByCode(@PathVariable Long code){
        return new ResponseEntity<>(clothesService.deleteClotheByCode(code),HttpStatus.OK);
    }
    @GetMapping("/{size}")
    ResponseEntity<List<ClothesResponseDTO>> getAllClothesBySize(@PathVariable String size){
        return new ResponseEntity<>(clothesService.findClothesBySize(size),HttpStatus.OK);
    }
    @GetMapping( name = "searchName", params = "name")
    ResponseEntity<List<ClothesResponseDTO>> getAllClothesByName(@RequestParam String name){
        return new ResponseEntity<>(clothesService.findClothesByName(name),HttpStatus.OK);
    }

}
