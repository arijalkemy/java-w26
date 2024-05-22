package com.example.ejerciciocrudconjpa.controller;

import com.example.ejerciciocrudconjpa.dto.request.CreateJewelRequestDto;
import com.example.ejerciciocrudconjpa.dto.request.UpdateJewelRequestDto;
import com.example.ejerciciocrudconjpa.dto.response.JewelResponseDto;
import com.example.ejerciciocrudconjpa.dto.response.ResponseDto;
import com.example.ejerciciocrudconjpa.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {
    @Autowired
    IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDto> createJewel(
        @RequestBody CreateJewelRequestDto createJewelRequestDto
    ) {
        return new ResponseEntity<>(
            jewelService.createJewel(createJewelRequestDto),
            HttpStatus.OK
        );
    }

    @GetMapping("")
    public ResponseEntity<List<JewelResponseDto>> getAllJewels() {
        return new ResponseEntity<>(
            jewelService.findAllJewels(),
            HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteJewel(
        @PathVariable Integer id
    ) {
        jewelService.deleteJewel(id);
        return new ResponseEntity<>(
            ResponseDto.builder().message("Jewel with id '" + id + "' deleted successfully.").build(),
            HttpStatus.OK
        );
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<ResponseDto> updateJewel(
        @PathVariable Integer id_modificar,
        @RequestBody UpdateJewelRequestDto updateJewelRequestDto
    ) {
        JewelResponseDto jewelResponseDto = jewelService.updateJewel(id_modificar, updateJewelRequestDto);
        return new ResponseEntity<>(
            ResponseDto.builder()
                .message("Updated jewel data: " + jewelResponseDto.toString())
                .build(),
            HttpStatus.OK
        );
    }
}
