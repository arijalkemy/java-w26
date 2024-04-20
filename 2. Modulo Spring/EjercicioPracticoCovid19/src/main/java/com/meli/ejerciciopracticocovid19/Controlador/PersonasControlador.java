package com.meli.ejerciciopracticocovid19.Controlador;


import com.meli.ejerciciopracticocovid19.DTO.PersonaDTO;
import com.meli.ejerciciopracticocovid19.DTO.SintomaDTO;
import com.meli.ejerciciopracticocovid19.Repository.Sintoma;
import com.meli.ejerciciopracticocovid19.Service.ISintomas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sintomas")
public class PersonasControlador {

    @Autowired
    private ISintomas sintomasServicio;

    @GetMapping("/findSymptom")
    ResponseEntity<List<SintomaDTO>> sintomasList() {
        return ResponseEntity.ok(sintomasServicio.listaSintomas());
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<?> findSymptom(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok(sintomasServicio.sintoma(nombre.toUpperCase()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/findRiskPerson")
    ResponseEntity<List<PersonaDTO>> findRiskPerson() {
        return ResponseEntity.ok(sintomasServicio.listaPersonas());
    }



}
