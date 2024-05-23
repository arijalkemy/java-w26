package com.ejercicio.showroomnosql.controller;

import com.ejercicio.showroomnosql.dto.ClotheDTO;
import com.ejercicio.showroomnosql.dto.MessageResponseDTO;
import com.ejercicio.showroomnosql.entity.Clothe;
import com.ejercicio.showroomnosql.service.interfaces.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClotheController {
    @Autowired
    private IClotheService clotheService;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> createClothe(@RequestBody ClotheDTO postRequestDTO) {
        return ResponseEntity.ok(
                clotheService.createClothe(postRequestDTO)
        );
    }

    @GetMapping
    public ResponseEntity<List<Clothe>> getAllClothes(Pageable pageable) {
        return ResponseEntity.ok(
                clotheService.getAllClothes(pageable)
        );
    }

    @GetMapping("/{code}")
    public ResponseEntity<Clothe> getClotheByCode(@PathVariable String code) {
        return ResponseEntity.ok(
                clotheService.getClotheByCode(code)
        );
    }
}
