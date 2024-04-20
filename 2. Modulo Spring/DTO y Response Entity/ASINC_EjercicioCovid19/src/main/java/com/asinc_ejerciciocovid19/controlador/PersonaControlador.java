package com.asinc_ejerciciocovid19.controlador;

import com.asinc_ejerciciocovid19.dto.PersonaSintomaDTO;
import com.asinc_ejerciciocovid19.servicio.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaControlador {

    @Autowired
    IPersonaServicio iPersonaServicio;

    @GetMapping(path = "/findRiskPerson")
    ResponseEntity<List<PersonaSintomaDTO>> mostrarPersonasMayoresConSintomas () {
        return new ResponseEntity<>(iPersonaServicio.obtenerPersonasDeRiesgo(), HttpStatus.OK);
    }
    //prueba: localhost:8080/findRiskPerson

}
