package org.ggomezr.codigomorse.controller;

import org.ggomezr.codigomorse.service.imp.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    @Autowired
    private CodigoMorseService codigoMorseService;

    @GetMapping("decodificar/{mensaje}")
    public String decodificarCodigoMorse(@PathVariable String mensaje){
        return codigoMorseService.decodificarCodigoMorse(mensaje);
    }

    @GetMapping("codificar/{mensaje}")
    public String codificarMensajeACodigoMorse(@PathVariable String mensaje){
        return codigoMorseService.codificarACodigoMorse(mensaje);
    }
}
