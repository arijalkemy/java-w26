package com.codigo_morse.codigo_morse.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/conversion")
public class ConversionControllador {

    @Autowired
    IConversionCodigo conversionCodigo;

    @GetMapping("{morse}")
    public String decodeMorseString(@PathVariable String morse){
        return conversionCodigo.decifrarCadenaMorse(morse);
    }
}

