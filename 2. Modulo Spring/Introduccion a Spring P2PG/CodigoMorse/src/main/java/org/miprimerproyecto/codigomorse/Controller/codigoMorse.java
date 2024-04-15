package org.miprimerproyecto.codigomorse.Controller;

import org.miprimerproyecto.codigomorse.MorseTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class codigoMorse {

    @GetMapping("/codigoMorse/{palabra}")
    public String traductor(@PathVariable("palabra") String palabra) {

        return "la palabra enviada: "+palabra+" significa: "+ MorseTranslator.translateToMorseOrSpanish(palabra);

    }

}
