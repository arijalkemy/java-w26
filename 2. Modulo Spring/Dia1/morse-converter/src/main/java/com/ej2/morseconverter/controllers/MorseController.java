package com.ej2.morseconverter.controllers;

import com.ej2.morseconverter.services.IMorseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    private IMorseConverter morseConverter;

    @GetMapping("/convert/morsetospanish/{morseCode}")
    public String convertToSpanish(@PathVariable String morseCode) {
        return morseConverter.convertToSpanish(morseCode);
    }

    @GetMapping("/convert/spanishtomorse/{text}")
    public String convertToMorse(@PathVariable String text) {
        return morseConverter.convertToMorse(text);
    }
}
