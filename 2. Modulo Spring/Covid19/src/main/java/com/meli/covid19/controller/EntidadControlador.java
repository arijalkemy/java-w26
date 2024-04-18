package com.meli.covid19.controller;

import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.dto.SintomaDTO;
import com.meli.covid19.service.IEntidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entidad")

public class EntidadControlador {

    private final IEntidad entidadServicio;

    public EntidadControlador(IEntidad entidadServicio) {
        this.entidadServicio = entidadServicio;
    }

    @GetMapping("/findSymptom")
    ResponseEntity<List<SintomaDTO>> findSymptom() {
        return ResponseEntity.ok(entidadServicio.findSymptom());
    }

    @GetMapping("/findSymptom/{name}")
    ResponseEntity<SintomaDTO> findSymptom(@PathVariable String name) {
        return ResponseEntity.ok(entidadServicio.findSymptom(name));
    }

    @GetMapping("/findRiskPerson/{name}")
    ResponseEntity<List<PersonaDTO>> findRiskPerson(@PathVariable String name){
        return ResponseEntity.ok(entidadServicio.findRiskPerson(name));
    }

}
