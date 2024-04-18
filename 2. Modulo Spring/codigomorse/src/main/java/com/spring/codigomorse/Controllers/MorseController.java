package com.spring.codigomorse.Controllers;


import com.spring.codigomorse.Services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    private MorseService morseService;

    @GetMapping("/morseToText/{morseString}")
    public String morseToText(@PathVariable String morseString){
        return morseService.morseToText(morseString);
    }

    @GetMapping("/textToMorse/{text}")
    public String textToMorse(@PathVariable String text){
        return morseService.textToMorse(text);
    }
}
