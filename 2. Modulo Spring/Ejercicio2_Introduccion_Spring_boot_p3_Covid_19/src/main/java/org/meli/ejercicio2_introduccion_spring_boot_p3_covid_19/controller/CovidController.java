package org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.controller;

import jakarta.validation.constraints.Pattern;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.dto.SymptomDTO;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.dto.SymptomPersonDTO;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.service.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/findSymptom")
@Validated
public class CovidController {
    @Autowired
    private ICovidService covidService;

    @GetMapping()
    public ResponseEntity<Set<SymptomDTO>> getAllSymptoms() {
        return new ResponseEntity<>(covidService.getAllSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Set<SymptomDTO>> findSymptom(
            @PathVariable @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters") String name) {
        return new ResponseEntity<>(covidService.getSymptomById(name), HttpStatus.OK);
    }

    /*
    visualizar un listado con el nombre y el apellido de aquellas personas mayores de 60 años que puedan poseer al
        menos un síntoma asociado
     */

    @GetMapping("/findRiskPerson")
    public ResponseEntity<Set<SymptomPersonDTO>> findRiskPerson() {
        return new ResponseEntity<>(covidService.listSymptomsAssociatedPeople(), HttpStatus.OK);
    }

}
