package com.example.JoyeriaLasPerlas.controller;

import com.example.JoyeriaLasPerlas.dto.jewel.JewelCompleteResponseDto;
import com.example.JoyeriaLasPerlas.dto.jewel.JewelRequestDto;
import com.example.JoyeriaLasPerlas.dto.jewel.JewelResponseDto;
import com.example.JoyeriaLasPerlas.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    @Autowired
    IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<JewelResponseDto> addJewel(@RequestBody JewelRequestDto jewelRequestDto) {
        return new ResponseEntity<>(
                jewelService.addJewel(jewelRequestDto),
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public ResponseEntity<List<JewelCompleteResponseDto>> getAllJewels() {
        return new ResponseEntity<>(
                jewelService.getAllJewels(),
                HttpStatus.OK
        );
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewel(@PathVariable Long id) {
        return new ResponseEntity<>(
                jewelService.deleteJewel(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewelCompleteResponseDto> updateJewel(@PathVariable Long id, @RequestBody JewelRequestDto jewelRequestDto) {
        return new ResponseEntity<>(
                jewelService.updateJewel(id, jewelRequestDto),
                HttpStatus.OK
        );
    }
}
