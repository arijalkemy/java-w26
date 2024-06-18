package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @PostMapping("/translateToText")
    public String translateToText(@RequestParam String morse) {
        return MorseTranslator.translateToText(morse);
    }

    @PostMapping("/translateToMorse")
    public String translateToMorse(@RequestParam String text) {
        return MorseTranslator.translateToMorse(text);
    }
}
