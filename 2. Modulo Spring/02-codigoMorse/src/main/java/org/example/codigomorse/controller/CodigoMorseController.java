package org.example.codigomorse.controller;

import org.example.codigomorse.services.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigoMorse")
public class CodigoMorseController {

    @Autowired
    ICodigoMorseService codigoMorseService;

    @GetMapping("/convertirAtexto/{codigoMorse}")
    public String convertirCodigoMorseATexto(@PathVariable String codigoMorse) {
        return codigoMorseService.convertirCodigoMorseATexto(codigoMorse);
    }

    @GetMapping("/convertirAmorse/{texto}")
    public String convertirTextoACodigoMorse(@PathVariable String texto) {
        return codigoMorseService.convertirTextoACodigoMorse(texto);
    }

}
