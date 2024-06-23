package org.example.joyeria.controller;

import org.example.joyeria.dto.JoyaDTO;
import org.example.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @GetMapping
    public ResponseEntity<?> getJoya() {
        return new ResponseEntity<>(joyaService.getAllJoyas(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createJoya(@RequestBody JoyaDTO joya) {
        return new ResponseEntity<>(joyaService.create(joya), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.delete(id), HttpStatus.OK);

    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id_modificar, @RequestBody JoyaDTO joya) {
        return new ResponseEntity<>(joyaService.update(joya, id_modificar), HttpStatus.OK);
    }

}
