package org.responseentity.lasperlas.controller;

import jakarta.validation.Valid;
import org.responseentity.lasperlas.dto.JoyaDTO;
import org.responseentity.lasperlas.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    @Autowired
    IJewerlyService jewerlyService;

    @GetMapping
    public ResponseEntity<?> listAllJewels(){
        return new ResponseEntity<>(jewerlyService.listAllJewels(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveJewerly(@Valid @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(jewerlyService.createJewerly(joyaDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable("id") Long id){
        return new ResponseEntity<>(jewerlyService.deleteJewerly(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewelry(@PathVariable("id") Long id, @Valid @RequestBody JoyaDTO joyaDto){
        return new ResponseEntity<>(jewerlyService.updateJewel(id, joyaDto), HttpStatus.OK);
    }
}
