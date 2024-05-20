package com.example.joyeria.controller;

import com.example.joyeria.dto.request.JoyaRequestDto;
import com.example.joyeria.dto.response.ResponseDto;
import com.example.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    IJoyaService iJoyaService;

    @PostMapping("/new")
    public ResponseEntity<?> agregarJoya(@RequestBody JoyaRequestDto joyaRequestDto){
        return new ResponseEntity<>(iJoyaService.agregarJoya(joyaRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> obtenerJoyas(){
        return new ResponseEntity<>(iJoyaService.obtenerJoyas(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarJoya(@PathVariable int id){
        iJoyaService.eliminarJoya(id);
        return new ResponseEntity<>(new ResponseDto("Joya de id " + id + " eliminada con exito"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> editarJoya(@PathVariable int id,
            @RequestBody JoyaRequestDto joyaRequestDto){
        return new ResponseEntity<>(iJoyaService.editarJoya(id, joyaRequestDto), HttpStatus.OK);
    }
}
