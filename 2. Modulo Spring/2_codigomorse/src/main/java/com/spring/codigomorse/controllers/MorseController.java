package com.spring.codigomorse.controllers;

import com.spring.codigomorse.services.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    IMorseService morseService;

    @GetMapping("/translateMorse/{morse}")
    public String translateMorse(@PathVariable String morse) {
        return morseService.translateMorse(morse);
    }

    @GetMapping("/translateText/{text}")
    public String translateText(@PathVariable String text) {
        return morseService.translateText(text.toUpperCase());
    }


}
