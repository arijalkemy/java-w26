package com.calculadora.calorias.controller;

import com.calculadora.calorias.dto.PlatoInputDTO;
import com.calculadora.calorias.dto.PlatoResponseDTO;
import com.calculadora.calorias.service.CaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CaloriasController {


    @Autowired
    CaloriasService caloriasService;

    @GetMapping("/totalCalorias")
    public ResponseEntity<List<PlatoResponseDTO>> getTotalCaloriasDelPlato(@RequestBody List<PlatoInputDTO> platoInputDTO){
        return new ResponseEntity<>( caloriasService.calcularTotalCalorias(platoInputDTO), HttpStatus.OK);
    }

    @GetMapping("/calorias")
    public ResponseEntity<PlatoResponseDTO> calcular(@RequestBody PlatoInputDTO platoInputDTO){
        return new ResponseEntity<>(caloriasService.calcularCalorias(platoInputDTO), HttpStatus.OK);
    }

}
