package com.example.codigoMorse.controllers;

import com.example.codigoMorse.services.IMorseParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class morseCodeController {

    @Autowired
    IMorseParserService morseParserService;

    @GetMapping("/{code}")
    public String translateCode(@PathVariable String code) {
        return morseParserService.translation(code);
    }
}
