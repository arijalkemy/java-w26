package org.example.covid.controller;

import org.example.covid.dto.GravedadSintomaDTO;
import org.example.covid.dto.PersonaNombresDTO;
import org.example.covid.model.Sintoma;
import org.example.covid.service.ISintomaService;
import org.example.covid.service.imp.SintomaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SintomasController {
    @Autowired
    private ISintomaService sintomaService;
    @GetMapping("/findBySymptom")
    public ResponseEntity<List<Sintoma>> getSintomas(){
        return sintomaService.getSintomas();
    }
    @GetMapping("findSymptom/{name}/{sintoma}")
    public ResponseEntity<GravedadSintomaDTO> getSintoma(@PathVariable String sintoma){
        return sintomaService.getGravedadSintoma(sintoma);
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaNombresDTO>> getPersonasDeRiesgo(){
        return sintomaService.getPersonasDeRiesgo();
    }
}
