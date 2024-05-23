package org.ggomezr.joyerialasperlas.application.controller;

import org.ggomezr.joyerialasperlas.application.service.impl.JoyaService;
import org.ggomezr.joyerialasperlas.domain.dto.JoyaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private final JoyaService joyaService;

    public JoyaController(JoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.createJoya(joyaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJoyaById(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.getJoyaById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(joyaService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.updateJoya(id, joyaDTO), HttpStatus.OK);
    }
}
