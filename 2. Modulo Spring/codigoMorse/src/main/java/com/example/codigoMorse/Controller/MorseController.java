package com.example.codigoMorse.Controller;

import com.example.codigoMorse.Service.MorseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MorseController {

    @Autowired
    MorseServiceImpl morseService;

    @GetMapping("/morse/{morse}")
    public String morseToWords(@PathVariable String morse){
        return morseService.morseToWords(morse);
    }

    @GetMapping("/words/{text}")
    public String textToMorse(@PathVariable String text){
        return morseService.textToMorse(text);
    }
}
