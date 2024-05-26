package org.example.joyerialasperlas.controller;

import org.example.joyerialasperlas.dto.JoyaRequestDTO;
import org.example.joyerialasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<?> postJoya(@RequestBody JoyaRequestDTO joya) {
        return ResponseEntity.status(HttpStatus.CREATED).body("nro identificatorio: " + joyaService.create(joya));
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id_modificar, @RequestBody JoyaRequestDTO joya) {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.update(id_modificar, joya));
    }

    @GetMapping()
    public ResponseEntity<?> getJoyas() {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJoya(@PathVariable Long id) {
        joyaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
