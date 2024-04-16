package com.example.morse.controllers;

import com.example.morse.services.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    IMorseService morseService;

    @GetMapping("/{morse}")
    public String traducir(@PathVariable String morse) {
        try {
            return morseService.traducirFraseMorse(morse);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
