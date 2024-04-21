package com.example.demo.controller;

import com.example.demo.dto.PlatoResponseDTO;
import com.example.demo.service.IPlatoService;
import com.example.demo.service.PlatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    private final IPlatoService platoService;

    @Autowired
    public PlatoController(PlatoServiceImpl platoService) {
        this.platoService = platoService;
    }

    @GetMapping("detalles/{nombrePlato}/{pesoGramos}")
    public ResponseEntity<?> obtenerDetallesPlato(@PathVariable String nombrePlato,
                                               @PathVariable double pesoGramos) {
        return new ResponseEntity<>(platoService.obtenerDetallesPlato(nombrePlato, pesoGramos), HttpStatus.OK);
    }
}
