package com.example.ejerciciomorse.controller;

import com.example.ejerciciomorse.service.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {

    @Autowired
    IMorseService morseService;

    @GetMapping("/convert/text/{value}")
    public String convert( @PathVariable String value ){
        return morseService.convertToWord(value);
    }

    @GetMapping("/convert/morse/{value}")
    public String convertToText( @PathVariable String value ){
        return morseService.convertToMorse(value);
    }
}
