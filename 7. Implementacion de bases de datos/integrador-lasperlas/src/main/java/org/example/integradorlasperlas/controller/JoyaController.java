package org.example.integradorlasperlas.controller;

import lombok.RequiredArgsConstructor;
import org.example.integradorlasperlas.model.dto.JoyaRequestDTO;
import org.example.integradorlasperlas.model.dto.JoyaUpdateDTO;
import org.example.integradorlasperlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/joya")
@RequiredArgsConstructor
public class JoyaController {
    private final IJoyaService joyaService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getAllJewels(){
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.getAllJewels());
    }

    @GetMapping("/logical/")
    @ResponseBody
    public ResponseEntity<?> logicalGetAllJewels(){
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.logicalGetAllJewels());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getJewelById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.getJewel(id));
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> createJewel(@RequestBody JoyaRequestDTO joyaRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(joyaService.createJewel(joyaRequestDTO));
    }

    @PutMapping("/")
    @ResponseBody
    public ResponseEntity<?> updateJewel(@RequestBody JoyaUpdateDTO joyaUpdateDTO){
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.updateJewel(joyaUpdateDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.deleteJewel(id));
    }

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> logicalDeleteJewel(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.logicalDeleteJewel(id));
    }

}
