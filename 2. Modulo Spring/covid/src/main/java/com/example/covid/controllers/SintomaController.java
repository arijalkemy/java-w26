package com.example.covid.controllers;

import com.example.covid.DTOs.SintomaDTO;
import com.example.covid.modelo.Sintoma;
import com.example.covid.servicios.ISintomasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SintomaController {

    private ISintomasService sintomasService;

    public SintomaController(ISintomasService sintomasService) {
        this.sintomasService = sintomasService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> obtenerSintomas() {
        return new ResponseEntity<>(
                sintomasService
                        .obtenerTodos()
                        .stream().map(
                                s -> new SintomaDTO(s.getNombre(), s.getNivelDeGravedad())
                        )
                        .toList(), HttpStatus.OK
        );
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<SintomaDTO> obtenerSintomaConElNombre(@PathVariable String nombre){
        Optional<Sintoma> sintomaOptional = sintomasService.obtenerSintomaDadoElNombre(nombre);
        if(sintomaOptional.isPresent()){
            SintomaDTO sintomaDTO = new SintomaDTO(
                    sintomaOptional.get().getNombre(),
                    sintomaOptional.get().getNivelDeGravedad()
            );
            return new ResponseEntity<>(sintomaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
