package com.mercadolibre.codigomorse.controller;

import com.mercadolibre.codigomorse.service.IMorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "morsecode")
public class MorseCodeController {

    @Autowired
    private IMorseCodeService morseCodeService;

    @GetMapping(path = "from-text/{text}")
    public String fromText(@PathVariable String text) {
        return morseCodeService.convertToMorse(text);
    }
    @GetMapping(path = "to-text/{morse}")
    public String toText(@PathVariable String morse) {
        return morseCodeService.convertFromMorse(morse);
    }
}
