package com.example.joyeria.controller;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    IJoyaService joyaService;

    @GetMapping
    public ResponseEntity<?> getAllJoyas(){
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.getAllJoyas());
    }

    @PostMapping("/new")
    public ResponseEntity<?> postCreateJoya(@RequestBody JoyaDTO joya){
        return  ResponseEntity.status(HttpStatus.CREATED).body(joyaService.createJoya(joya));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.deleteJoya(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> postUpdateJoya(@PathVariable Long id, @RequestBody JoyaDTO joya){
        return  ResponseEntity.status(HttpStatus.OK).body(joyaService.updateJoya(id, joya));
    }
}
