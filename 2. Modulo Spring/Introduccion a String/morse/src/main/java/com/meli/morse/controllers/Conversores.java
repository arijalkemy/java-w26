package com.meli.morse.controllers;

import com.meli.morse.servicies.TraductorMorseImp;
import com.meli.morse.servicies.TraductorRomanosImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Conversores {

    @Autowired
    private TraductorMorseImp traductorMorseImp;

    @Autowired
    private  TraductorRomanosImp traductorRomanosImp;

    @GetMapping("/aMorse/{cadena}")
    public String convertirAMorse(@PathVariable String cadena) {
        return traductorMorseImp.convertirAMorse(cadena.toUpperCase(Locale.ROOT));
    }

    @GetMapping("/aString/{morseStg}")
    public String convertirAString(@PathVariable String morseStg) {
        return traductorMorseImp.convertirACaracter(morseStg);
    }


    @GetMapping("/aRomano/{numeroDecimal}")
    public String deDecimalARomano(@PathVariable Integer numeroDecimal) {
        return traductorRomanosImp.deDecimalARomano(numeroDecimal);
    }


    @GetMapping("/aDecimal/{morseStg}")
    public Integer deRomanoADecimal(@PathVariable String morseStg) {
        return traductorRomanosImp.deRomanoADecimal(morseStg.toUpperCase(Locale.ROOT));
    }

}

