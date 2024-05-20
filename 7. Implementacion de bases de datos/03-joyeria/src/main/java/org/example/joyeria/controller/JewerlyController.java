package org.example.joyeria.controller;

import org.example.joyeria.dto.JewelRequestDTO;
import org.example.joyeria.dto.JewelResponseDTO;
import org.example.joyeria.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    @Autowired
    IJewerlyService jewerlyService;

    @PostMapping("/new")
    public ResponseEntity<Long> createJewel(@RequestBody JewelRequestDTO jewel) {
        Long id = jewerlyService.saveJewel(jewel);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<JewelResponseDTO>> getJewels() {
        return ResponseEntity.ok(jewerlyService.getJewerly());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewel(@PathVariable Long id) {
        jewerlyService.deleteJewel(id);
        return ResponseEntity.ok("The jewel " + id + " has been deleted.");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateJewel(@PathVariable Long id, @RequestBody JewelRequestDTO jewelUpdate) {
        JewelResponseDTO jewel = jewerlyService.updateJewel(id, jewelUpdate);
        return ResponseEntity.ok(jewel.toString());
    }


}
