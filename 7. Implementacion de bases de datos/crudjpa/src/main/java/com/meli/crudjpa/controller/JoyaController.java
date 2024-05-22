package com.meli.crudjpa.controller;


import com.meli.crudjpa.model.DTO.JoyaDTO;
import com.meli.crudjpa.service.impl.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    JoyaService joyaService;
    @GetMapping()
    public ResponseEntity<?> obtenerJoyas(){
        return ResponseEntity.ok().body(joyaService.buscarTodasLasJoyas());
    }

    @PostMapping("/new")
    public ResponseEntity<?> crearJoya(@RequestBody JoyaDTO joyaDTO)
    {
        return ResponseEntity.ok().body(joyaService.crearJoya(joyaDTO));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> borrarJoya(@PathVariable int id)
    {
        return ResponseEntity.ok().body(joyaService.eliminarJoya(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerJoya(@PathVariable int id)
    {
        return ResponseEntity.ok().body(joyaService.buscarJoyaPorId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarJoya(@PathVariable int id, @RequestBody JoyaDTO joyaDTO)
    {
        return ResponseEntity.ok().body(joyaService.actualizarJoya(id, joyaDTO));
    }
}
