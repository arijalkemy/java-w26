package com.example.ejercicio_lasperlas.controller;

import com.example.ejercicio_lasperlas.dto.JewelDTO;
import com.example.ejercicio_lasperlas.dto.MessageResponseDTO;
import com.example.ejercicio_lasperlas.model.Jewel;
import com.example.ejercicio_lasperlas.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {

    @Autowired
    private IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<MessageResponseDTO> createJewel(@RequestBody JewelDTO jewelDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MessageResponseDTO(
                    String.valueOf(jewelService.saveJewel(jewelDTO).getId())
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<Jewel>> getAllJewels() {
        return ResponseEntity.status(HttpStatus.OK).body(
                jewelService.getAllJewels()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJewel(@PathVariable long id) {
        jewelService.deleteJewel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewelDTO> updateJewel(@RequestBody JewelDTO jewelDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                jewelService.updateJewel(jewelDTO)
        );
    }
}