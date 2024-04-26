package org.example.codigomorse.controller;

import org.example.codigomorse.interfaces.IConvertMorseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/morse")
public class MorseController {

    @Autowired
    private IConvertMorseCode iConvertMoreseCode;


    @GetMapping("/v1/convertstring/{morse}")
    public String convertToString(@PathVariable String morse) {

        return iConvertMoreseCode.convertMorseToString(morse);
    }

    @GetMapping("/v1/convertmorse/{words}")
    public String convertToMorse(@PathVariable String words) {
        return iConvertMoreseCode.convertStringToMorse(words);
    }
}
