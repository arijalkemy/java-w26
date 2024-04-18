package com.spring.calculadoracalorias.controller;

import com.spring.calculadoracalorias.dto.PlatoDTO;
import com.spring.calculadoracalorias.dto.PlatoRequestDTO;
import com.spring.calculadoracalorias.service.interfaces.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatoController {
    @Autowired
    IPlatoService platoService;

    @GetMapping("/getTotalCalsByNameAndWeight")
    public ResponseEntity<PlatoDTO> getPlatoByNameAndWeight(@RequestParam String name, @RequestParam double peso){

        return new ResponseEntity<>(platoService.getPlatoByNameAndPeso(name, peso), HttpStatus.OK);
    }

    @PostMapping("/getListTotalCalsByNameAndWeight")
    public ResponseEntity<List<PlatoDTO>> getPlatoByNameAndWeight(@RequestBody List<PlatoRequestDTO> listPlatos){
        System.out.println(listPlatos);
        return new ResponseEntity<>(platoService.getListOfPlatosByNameAndPeso(listPlatos), HttpStatus.OK);
    }

}
