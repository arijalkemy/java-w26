package com.asinc_ejerciciocalculadoracalorias.controlador;

import com.asinc_ejerciciocalculadoracalorias.dto.PlatoRequestDTO;
import com.asinc_ejerciciocalculadoracalorias.dto.PlatoResponseDTO;
import com.asinc_ejerciciocalculadoracalorias.servicio.IPlatoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatoControlador {

    @Autowired
    private IPlatoServicio iPlatoServicio;

    @PostMapping(path = "/calcularCalorias")
    PlatoResponseDTO calcularCalorias(@RequestBody PlatoRequestDTO plato) {
        return iPlatoServicio.calcularCalorias(plato);
    }
    //prueba: localhost:8080/calcularCalorias
    /*{
    "nombre": "ESPECIAL DE LA CASA",
    "peso": 132
    }
    */

    @PostMapping(path = "/calcularCaloriasPlatos")
    List<PlatoResponseDTO> calcularCalorias(@RequestBody List<PlatoRequestDTO> platos) {
        return iPlatoServicio.calcularCalorias(platos);
    }
    //ejemplo: localhost:8080/calcularCaloriasPlatos
    /*[
    {
        "nombre": "ESPECIAL DE LA CASA",
            "peso": 132
    },
    {
        "nombre": "menu del dia",
            "peso": 250
    }
    ]*/

}
