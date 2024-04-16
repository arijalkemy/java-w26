package org.example.morse.controllers;

import org.example.morse.services.MorseServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {

    private final MorseServiceImpl morseService;

    public MorseController(MorseServiceImpl morseService) {
        this.morseService = morseService;
    }


    @GetMapping("/aLatino/{mensajeMorse}")
    public String convertirMensajeMorse(@PathVariable String mensajeMorse) {

        return this.morseService.convertirMorseALatino(mensajeMorse);
    }

    @GetMapping("/aMorse/{mensajeLatino}")
    public String convertirMensajeLatino(@PathVariable String mensajeLatino) {

        return this.morseService.convertirLatinoAMorse(mensajeLatino);
    }
}
