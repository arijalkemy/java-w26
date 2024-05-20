package com.bootcamp.joyeriacrud.controller;

import com.bootcamp.joyeriacrud.model.dto.JewelryRequestDTO;
import com.bootcamp.joyeriacrud.model.dto.JewelryListResponseDTO;
import com.bootcamp.joyeriacrud.model.dto.JewelryResponseDTO;
import com.bootcamp.joyeriacrud.model.dto.MessageResponseDTO;
import com.bootcamp.joyeriacrud.service.IJewelryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/jewelry")
public class JewelryController {
    private final IJewelryService jewelryService;

    @PostMapping("/new")
    public ResponseEntity<MessageResponseDTO> createJewelry(@RequestBody JewelryRequestDTO jewelryRequestDTO) {
        return ResponseEntity.ok(jewelryService.saveJewelry(jewelryRequestDTO));
    }

    @GetMapping
    public ResponseEntity<JewelryListResponseDTO> getJewelry() {
        return ResponseEntity.ok(jewelryService.getJewelry());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponseDTO> deleteJewelry(@PathVariable Long id) {
        return ResponseEntity.ok(jewelryService.deleteJewelry(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewelryResponseDTO> updateJewelry(@PathVariable Long id,
                                                            @RequestBody JewelryRequestDTO jewelryRequestDTO) {
        return ResponseEntity.ok(jewelryService.updateJewelry(id, jewelryRequestDTO));
    }
}
