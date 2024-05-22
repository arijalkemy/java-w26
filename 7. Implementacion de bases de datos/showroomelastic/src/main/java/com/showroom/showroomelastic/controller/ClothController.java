package com.showroom.showroomelastic.controller;

import com.showroom.showroomelastic.dto.ClothResponseDTO;
import com.showroom.showroomelastic.model.Cloth;
import com.showroom.showroomelastic.service.IClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothController {

    @Autowired
    IClothService clothService;

    @PostMapping
    public ResponseEntity<String> addCloth(@RequestBody Cloth cloth) {
        return new ResponseEntity<>(clothService.save(cloth), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClothResponseDTO>> getAllClothes() {
        return new ResponseEntity<>(clothService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothResponseDTO> getCloth(@PathVariable String code) {
        return new ResponseEntity<>(clothService.getById(code),HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClothResponseDTO> updateCloth(@PathVariable String code,@RequestBody Cloth cloth) {
        return new ResponseEntity<>(clothService.update(code, cloth),HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCloth(@PathVariable String code) {
        return new ResponseEntity<>(clothService.delete(code),HttpStatus.OK);
    }

    @GetMapping("size/{size}")
    public ResponseEntity<List<ClothResponseDTO>> getClothBySize(@PathVariable String size) {
        return new ResponseEntity<>(clothService.getClothBySize(size),HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<ClothResponseDTO>> getClothByName(@RequestParam String name) {
        return new ResponseEntity<>(clothService.getClothByName(name),HttpStatus.OK);
    }
}
