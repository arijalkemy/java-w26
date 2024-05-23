package com.demospring.joyerialasperlas.controller;

import com.demospring.joyerialasperlas.dto.JoyaRequestDTO;
import com.demospring.joyerialasperlas.dto.ResponseCreatedJoyaDTO;
import com.demospring.joyerialasperlas.model.Joya;
import com.demospring.joyerialasperlas.service.JoyaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
@RequiredArgsConstructor
public class JoyaController {
    private final JoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<?> createJoya(@RequestBody JoyaRequestDTO joya){
        return new ResponseEntity<>(new ResponseCreatedJoyaDTO(joyaService.createJoya(joya)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJoyas(){
        return ResponseEntity.ok(joyaService.getAllJoyas());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable
                                            @Valid
                                            @Positive(message = "El id  debe ser mayor a cero.")
                                            Long id){
        joyaService.deleteJoya(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJoya(@PathVariable
                                            @Valid
                                            @Positive(message = "El id  debe ser mayor a cero.")
                                            Long id,
                                            @RequestBody JoyaRequestDTO joya){
        joyaService.updateJoya(id, joya);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
