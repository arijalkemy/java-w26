package com.example.EjercicioDeporte.controllers;

import com.example.EjercicioDeporte.dto.DeporteDTO;
import com.example.EjercicioDeporte.services.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deportes")
public class DeporteController {
    @Autowired
    private IDeporteService deporteService;

    @GetMapping("/")
    public ResponseEntity<List<DeporteDTO>> buscarTodosDeportes(){
        return ResponseEntity.ok(deporteService.buscarTodosDeportes());
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> buscarDeporte(@PathVariable String name){
        return ResponseEntity.ok(deporteService.buscarPorNombre(name));
    }
}
