package org.example.showroomsql.controller;

import org.example.showroomsql.dto.RequestClothesDTO;
import org.example.showroomsql.dto.ResponseClothesDTO;
import org.example.showroomsql.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clothes")
public class ClothesController {

    @Autowired
    IClothesService service;

    @PostMapping()
    private ResponseEntity<ResponseClothesDTO> createClothes(@RequestBody RequestClothesDTO request){
        return ResponseEntity.ok(service.createClothes(request));
    }

    @GetMapping()
    private ResponseEntity<List<ResponseClothesDTO>> getAllClothes(){
        return ResponseEntity.ok(service.getAllClothes());
    }

    @GetMapping("/{code}")
    private ResponseEntity<ResponseClothesDTO> getClothesByCode(@PathVariable Long code){
        return ResponseEntity.ok(service.getClothesByCode(code));
    }

    @PutMapping("/{code}")
    private ResponseEntity<ResponseClothesDTO> updateClothes(@PathVariable Long code, @RequestBody RequestClothesDTO request){
        return ResponseEntity.ok(service.updateClothes(code, request));
    }

    @DeleteMapping("/{code}")
    private ResponseEntity<String> deleteClothes(@PathVariable Long code){
        return ResponseEntity.ok(service.deleteClothes(code));
    }

    @GetMapping("/bySize/{size}")
    private ResponseEntity<List<ResponseClothesDTO>> getClothesBySize(@PathVariable String size){
        return ResponseEntity.ok(service.getClothesBySize(size));
    }

    @GetMapping(params = "name")
    private ResponseEntity<List<ResponseClothesDTO>> getClothesByName(@RequestParam String name){
        return ResponseEntity.ok(service.getClothesByName(name));
    }
}
