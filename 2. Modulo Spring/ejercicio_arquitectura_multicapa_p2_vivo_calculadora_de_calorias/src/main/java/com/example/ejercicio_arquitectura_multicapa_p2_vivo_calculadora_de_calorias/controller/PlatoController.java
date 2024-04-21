package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.controller;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto.InformacionPlatoResponseDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto.IngredienteDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto.ResponseDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platos")
public class PlatoController {
    @Autowired
    private IPlatoService platoService;

    @GetMapping("/informacion")
    public ResponseEntity<InformacionPlatoResponseDto> obtenerInformacion(
            @RequestParam String nombre,
            @RequestParam Integer peso
    ) {
        return new ResponseEntity<>(
            platoService.searchInformacion(nombre, peso),
            HttpStatus.OK
        );
    }
}
