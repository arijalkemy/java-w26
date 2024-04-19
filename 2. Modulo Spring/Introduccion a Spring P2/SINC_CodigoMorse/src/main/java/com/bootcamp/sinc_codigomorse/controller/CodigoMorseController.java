package com.bootcamp.sinc_codigomorse.controller;

import com.bootcamp.sinc_codigomorse.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    @Autowired
    ICodigoMorseService codigoMorseService;

    @GetMapping("/convertirAEspaniol/{textoAConvertir}")
    public String convertirAEspaniol(@PathVariable String textoAConvertir) {
        return codigoMorseService.convertirAEspaniol(textoAConvertir);
    }

    @GetMapping("/convertirAMorse/{textoAConvertir}")
    public String convertirAMorse(@PathVariable String textoAConvertir) {
        return codigoMorseService.convertirAMorse(textoAConvertir);
    }

    //pruebas
    //localhost:8080/convertirAMorse/hola, marcos!
    //localhost:8080/convertirAEspaniol/.... --- .-.. .- --..--   -- .- .-. -.-. --- ... -.-.--
}
