package org.example.joyerialasperlas.controller;
import jakarta.validation.Valid;
import org.example.joyerialasperlas.DTO.JoyaResquestDTO;
import org.example.joyerialasperlas.service.IJoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/joyeria")
@Validated
public class JayeriaController {

    @Autowired
    IJoyeriaService joyeriaService;

    @GetMapping()
    public ResponseEntity<List<JoyaResquestDTO>> getAllJoyeria() {
        return new ResponseEntity<>(joyeriaService.listAllJoyeria(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<UUID> createJoya(@Valid @RequestBody JoyaResquestDTO jayaResquestDTO){;
        return new ResponseEntity<>(joyeriaService.saveJoyeria(jayaResquestDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable UUID id) {
        joyeriaService.deleteJoyeria(id);
        return new ResponseEntity<>("Joya eliminada con exito", HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaResquestDTO> updateJoya(@PathVariable UUID id_modificar, @RequestBody JoyaResquestDTO joyaResquestDTO) {
        return new ResponseEntity<>(joyeriaService.updateJoyeria(id_modificar, joyaResquestDTO), HttpStatus.OK);
    }

}
