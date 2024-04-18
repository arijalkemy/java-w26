package com.codigo_morse.codigo_morse.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/conversion")
public class ConversionControllador {

    @Autowired
    IConversionCodigo conversionCodigo;

    @GetMapping("/decode/{morse}")
    public String decodeMorseToLetters(@PathVariable String morse){
        return conversionCodigo.decifrarCadenaMorse(morse);
    }

    @GetMapping("/code/{morse}")
    public String decodeLettersToMorse(@PathVariable String morse){
        return conversionCodigo.convertirAMorse(morse);
    }
}

