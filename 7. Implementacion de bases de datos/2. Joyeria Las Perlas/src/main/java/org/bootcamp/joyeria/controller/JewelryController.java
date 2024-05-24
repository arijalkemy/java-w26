package org.bootcamp.joyeria.controller;

import org.bootcamp.joyeria.dto.RequestJewelryDTO;
import org.bootcamp.joyeria.dto.ResponseJewelryDTO;
import org.bootcamp.joyeria.service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {
    @Autowired
    private IJewelryService jewelryService;

    @PostMapping("/new")
    public ResponseEntity<ResponseJewelryDTO> createJewelry(@RequestBody RequestJewelryDTO requestJewelryDTO) {
        return ResponseEntity.ok(jewelryService.createJewelry(requestJewelryDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseJewelryDTO>> getAllJewelry() {
        return ResponseEntity.ok(jewelryService.getAllJewelry());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJewelry(@PathVariable int id) {
        return ResponseEntity.ok(jewelryService.deleteJewelry(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseJewelryDTO> updateJewelry(@PathVariable int id,@RequestBody RequestJewelryDTO requestJewelryDTO) {
        return ResponseEntity.ok(jewelryService.updateJewelry(id, requestJewelryDTO));
    }
}
