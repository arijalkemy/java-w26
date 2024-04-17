package com.DTO.ejercicio.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.ejercicio.persistence.Sintoma;
import com.DTO.ejercicio.service.ISintomaService;

import java.util.List;

@RestController
public class SintomaController {
    @Autowired
    private static ISintomaService sintomaService;

    @GetMapping("/findSymptom")
    public @NotNull ResponseEntity<List<Sintoma>> obtenerSintomas(){
        return new ResponseEntity<>(sintomaService.getSintomas(), HttpStatus.OK);
    }

}
