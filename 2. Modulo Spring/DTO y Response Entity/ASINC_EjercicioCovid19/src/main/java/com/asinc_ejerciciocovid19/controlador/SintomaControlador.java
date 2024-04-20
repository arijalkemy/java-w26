package com.asinc_ejerciciocovid19.controlador;

import com.asinc_ejerciciocovid19.dto.SintomaDTO;
import com.asinc_ejerciciocovid19.servicio.ISintomaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaControlador {

    @Autowired
    private ISintomaServicio iSintomaServicio;

    @GetMapping(path = "/findSymptom")
    public List<SintomaDTO> buscarTodosLosSintomas() {
        return iSintomaServicio.buscarTodosLosSintomas();
    }
    //prueba: localhost:8080/findSymptom

    @GetMapping(path = "/findSymptom/{nombre}")
    public ResponseEntity<String> buscarSintomaPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok()
                             .body(iSintomaServicio.buscarSintomaPorNombre(nombre).getNivelDeGravedad());
    }
    //prueba: localhost:8080/findSymptom/tos


}
