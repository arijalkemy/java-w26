package com.codigo_morse.codigo_morse.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/conversion")
public class ConversionControllador {

    @Autowired
    IConversionCodigo conversionCodigo;

    @PostMapping("/{morse}")
    public String decodeMorseString(@PathVariable String morse){
        return conversionCodigo.decifrarCadenaMorse(morse);
    }

    @GetMapping("/letter/{morse}")
    public String decodeLettersToString(@PathVariable String morse){
        return conversionCodigo.convertirAMorse(morse);
    }
}

