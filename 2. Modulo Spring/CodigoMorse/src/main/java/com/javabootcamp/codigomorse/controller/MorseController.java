package com.javabootcamp.codigomorse.controller;

import com.javabootcamp.codigomorse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    MorseService morseService;

    @GetMapping("/morseToText/{text}")
    public String morse(@PathVariable String text) {
        return "El codigo morse traducido: " + morseService.translateMtoT(text);
    }

    @GetMapping("textToMorse/{text}")
    public String text(@PathVariable String text){
        return "El text en morse es: " + morseService.translateTtoM(text);
    }
}
