package org.meli.ejercicio6_p2_d1_joyeria_las_perlas.controller;

import org.meli.ejercicio6_p2_d1_joyeria_las_perlas.dto.JoyaDTO;
import org.meli.ejercicio6_p2_d1_joyeria_las_perlas.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joyas")
public class JoyaController {
    @Autowired
    private JoyaService joyaService;

    @PostMapping
    public ResponseEntity<JoyaDTO> guardarJoya(@RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<>(joyaService.guardarJoya(joyaDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JoyaDTO> modificarJoya(
            @PathVariable Long id,
            @RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<>(joyaService.modificarJoya(id,joyaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JoyaDTO> eliminarJoya(
            @PathVariable Long id){
        return new ResponseEntity<>(joyaService.eliminarJoya(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaDTO> obtenerJoya(
            @PathVariable Long id){
        return new ResponseEntity<>(joyaService.obtenerJoyaPorId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JoyaDTO>> obtenerJoyas(){
        return new ResponseEntity<>(joyaService.obtenerListaJoyas(), HttpStatus.OK);
    }

}
