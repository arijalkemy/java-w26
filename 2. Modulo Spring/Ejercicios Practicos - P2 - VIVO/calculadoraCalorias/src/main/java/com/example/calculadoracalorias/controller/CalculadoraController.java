package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.DTO.PlatoRensposeDTO;
import com.example.calculadoracalorias.service.ICalculadoraCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @Autowired
    private ICalculadoraCaloriasService calculadoraService;

    @GetMapping("/calorias/{name}")
    public ResponseEntity<PlatoRensposeDTO> obtenerInfoPlato(@PathVariable String name){
        return ResponseEntity.ok(calculadoraService.calcularCalorias(name));
    }


}
