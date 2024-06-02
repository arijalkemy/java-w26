package com.mercadolibre.deportes_n.controller;

import com.mercadolibre.deportes_n.dtos.DTOPersonaDeporte;
import com.mercadolibre.deportes_n.service.ServicioBusquedaDeportePersona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deporte_persona")
public class ControladorDeportePersona {

    private ServicioBusquedaDeportePersona servicioBusquedaDeportePersona;

    public ControladorDeportePersona(ServicioBusquedaDeportePersona servicioBusquedaDeportePersona) {
        this.servicioBusquedaDeportePersona = servicioBusquedaDeportePersona;
    }

    @GetMapping("/encontrar")
    public ResponseEntity<List<DTOPersonaDeporte>> encontrarDeportePersona() {
        List<DTOPersonaDeporte> personasDeportistas = servicioBusquedaDeportePersona.buscarDeportePersona();
        return new ResponseEntity<>(personasDeportistas, HttpStatus.OK);
    }
}
