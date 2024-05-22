package com.implementaciondb.ejercicio11_showroom_elasticsearch.controller;

import com.implementaciondb.ejercicio11_showroom_elasticsearch.model.dto.Garment.GarmentRequestDto;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.model.dto.Garment.GarmentResponseDto;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.service.interfaces.IGarmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class GarmentController {

    @Autowired
    private IGarmentService garmentService;

    @PostMapping
    public ResponseEntity<GarmentResponseDto> createGarment(@RequestBody GarmentRequestDto garmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(garmentService.saveGarment(garmentRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<GarmentResponseDto>> getAllClothes() {
        return ResponseEntity.status(HttpStatus.OK).body(garmentService.findAllClothes());
    }

    @GetMapping("/{code}")
    public ResponseEntity<GarmentResponseDto> getGarmentByCode(@PathVariable String code) {
        return ResponseEntity.status(HttpStatus.OK).body(garmentService.findGarmentByCode(code));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<GarmentResponseDto> deleteGarmentByCode(@PathVariable String code) {
        return ResponseEntity.status(HttpStatus.OK).body(garmentService.deleteGarmentByCode(code));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<GarmentResponseDto>> getClothesBySize(@PathVariable Integer size) {
        return ResponseEntity.status(HttpStatus.OK).body(garmentService.findGarmentBySize(size));
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<GarmentResponseDto>> getClothesByKeyWordName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(garmentService.findClothesByKeyWordName(name));
    }

}
