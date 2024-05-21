package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.JewelryDto;
import com.example.joyerialasperlas.service.JewelryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jewelry")
public class JewelryController {

    @Autowired
    private JewelryServiceImpl jewelryService;

    @PostMapping("/new")
    public ResponseEntity<?> createJewelry(@RequestBody JewelryDto jewelryDto) {
        return new ResponseEntity<>(jewelryService.createJewelry(jewelryDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllJewelry() {
        return new ResponseEntity<>(jewelryService.getAllJewelry(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Long id) {
        return new ResponseEntity<>(jewelryService.deleteJewelry(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewelry(@PathVariable Long id, @RequestBody JewelryDto updatedJewelry) {
        return new ResponseEntity<>(jewelryService.updateJewelry(id, updatedJewelry), HttpStatus.OK);
    }

}
