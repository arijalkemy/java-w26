package com.example.joyeriaLasPerlas.controller;

import com.example.joyeriaLasPerlas.dto.JewerlyRequestDTO;
import com.example.joyeriaLasPerlas.dto.JewerlyResponseDTO;
import com.example.joyeriaLasPerlas.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewerlyController {

    @Autowired
    IJewerlyService jewerlyService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<String> saveJoya (@RequestBody JewerlyRequestDTO jewerlyRequestDTO) {
        jewerlyService.createJewerly(jewerlyRequestDTO);
        return new ResponseEntity<>("Save successfully", HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JewerlyResponseDTO>> getJoyas () {

        return new ResponseEntity<>(jewerlyService.getAllRegisteredJewerlies(), HttpStatus.OK);
    }

    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> deleteJoya (@PathVariable Long id) {
        jewerlyService.deleteJewerlyById(id);
        return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<JewerlyResponseDTO> updateJoya (@PathVariable Long id,
                            @RequestBody JewerlyRequestDTO jewerlyRequestDTO) {

        return new ResponseEntity<>(jewerlyService.updateJewerly(id, jewerlyRequestDTO), HttpStatus.OK);
    }
}
