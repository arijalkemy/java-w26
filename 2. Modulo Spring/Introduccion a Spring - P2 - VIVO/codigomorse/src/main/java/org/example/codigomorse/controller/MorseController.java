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

    @GetMapping("/v1/convertstring/{words}")
    public String convertString(@PathVariable String words) {
        return iConvertMoreseCode.convertMorseToString(words);
    }

    @GetMapping("/v1/convertmorse/{words}")
    public String convertMorse(@PathVariable String words) {
        return iConvertMoreseCode.convertStringToMorse(words);
    }
}
