package org.example.apitest.controllers;

import org.example.apitest.services.IMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/morse")
public class MorseController {
    private final IMorse morseImpl;

    public MorseController(@Autowired IMorse morseImpl) {
        this.morseImpl = morseImpl;
    }

    @GetMapping("/decode/{phrase}")
    public Map<String, Object> decodeMorse(@PathVariable String phrase) {
        return Map.of("word", this.morseImpl.decodeMorse(phrase));
    }

    @GetMapping("/encode/{phrase}")
    public Map<String, Object> encodeMorse(@PathVariable String phrase) {
        return Map.of("morse", this.morseImpl.encodeMorse(phrase));
    }
}
