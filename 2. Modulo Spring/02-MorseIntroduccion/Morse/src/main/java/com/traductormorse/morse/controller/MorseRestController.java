package com.traductormorse.morse.controller;

import com.traductormorse.morse.service.IConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/convertir")
public class MorseRestController{

    @Autowired
    IConversion ConvertirCadena;

    @GetMapping("/morse/{morse}")
    public String convertirMorse(@PathVariable String morse){
        return ConvertirCadena.convertirAAlfabetico(morse);
    }

    @GetMapping("/alfabeto/{alfabeto}")
    public String convertirAlfabeto(@PathVariable String alfabeto){
        return ConvertirCadena.convertirAMorse(alfabeto);
    }

}
