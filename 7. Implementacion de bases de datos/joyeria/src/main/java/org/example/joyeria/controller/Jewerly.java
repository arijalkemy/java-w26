package org.example.joyeria.controller;

import jakarta.validation.Valid;
import org.example.joyeria.dto.SuccessResponseDto;
import org.example.joyeria.dto.jewel.JewelRequestDto;
import org.example.joyeria.dto.jewel.JewelResponseDto;
import org.example.joyeria.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class Jewerly {
    private final IJewerlyService jewerlyService;

    public Jewerly(@Autowired IJewerlyService jewerlyService) {
        this.jewerlyService = jewerlyService;
    }

    @GetMapping
    public ResponseEntity<List<JewelResponseDto>> getAllupdateJewelJewels() {
        return new ResponseEntity<>(jewerlyService.getAllJewels(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewelResponseDto> updateJewel(@Valid @RequestBody JewelRequestDto jewelRequestDto,
                                                        @PathVariable Long id) {
        return new ResponseEntity<>(jewerlyService.updateJewel(id, jewelRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewelById(@PathVariable Long id) {
        jewerlyService.deleteJewelById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessResponseDto> postNewJewel(@RequestBody @Valid JewelRequestDto jewelRequestDto) {
        return new ResponseEntity<>(jewerlyService.postCreateJewel(jewelRequestDto), HttpStatus.CREATED);
    }
}
