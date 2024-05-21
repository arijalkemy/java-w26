package org.example.joyeria.controller;

import org.example.joyeria.dto.JoyaDTO;
import org.example.joyeria.dto.JoyaDTOReq;
import org.example.joyeria.service.IJoyasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyasController {

    @Autowired
    IJoyasService service;

    @GetMapping
    public ResponseEntity<List<JoyaDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaDTO> update(@PathVariable Long id, @RequestBody JoyaDTOReq joya){
        return ResponseEntity.ok(service.update(id,joya));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<JoyaDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping("/new")
    public ResponseEntity<JoyaDTO> create(@RequestBody JoyaDTOReq joyaDTO){
        return ResponseEntity.ok(service.create(joyaDTO));
    }
}
