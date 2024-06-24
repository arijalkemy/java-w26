package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.RequestClothes;
import com.mercadolibre.showroom.dto.ResponseClothes;
import com.mercadolibre.showroom.service.IClothesService;
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
    private ResponseEntity<ResponseClothes> createClothes(@RequestBody RequestClothes request){
        return ResponseEntity.ok(service.createClothes(request));
    }

    @GetMapping()
    private ResponseEntity<List<ResponseClothes>> listResponseClothes(){
        return ResponseEntity.ok(service.listResponseClothes());
    }

    @GetMapping("/{code}")
    private ResponseEntity<ResponseClothes> responseClothes(@PathVariable Long code){
        return ResponseEntity.ok(service.responseClothes(code));
    }

    @PutMapping("/{code}")
    private ResponseEntity<ResponseClothes> updateClothes(@PathVariable Long code, @RequestBody RequestClothes request){
        return ResponseEntity.ok(service.updateClothes(code, request));
    }

    @DeleteMapping("/{code}")
    private ResponseEntity<String> deleteClothes(@PathVariable Long code){
        return ResponseEntity.ok(service.deleteClothes(code));
    }

    @GetMapping("/bySize/{size}")
    private ResponseEntity<List<ResponseClothes>> listResponseClothesBySize(@PathVariable String size){
        return ResponseEntity.ok(service.listResponseClothesBySize(size));
    }

    @GetMapping(params = "name")
    private ResponseEntity<List<ResponseClothes>> listResponseClothesByName(@RequestParam String name){
        return ResponseEntity.ok(service.listResponseClothesByName(name));
    }
}
