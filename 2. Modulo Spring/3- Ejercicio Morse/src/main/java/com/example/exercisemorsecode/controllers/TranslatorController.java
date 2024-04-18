package com.example.exercisemorsecode.controllers;

import com.example.exercisemorsecode.services.ITranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translator")
public class TranslatorController {

    @Autowired
    ITranslatorService translatorService;

    @GetMapping("/alphanumericToMorse")
    public String alphanumericToMorse (@RequestParam String alphanumericText) {
        return translatorService.alphanumericToMorse(alphanumericText);
    }

    @GetMapping("/morseToAlphanumeric")
    public String morseToAlphanumeric (@RequestParam String morseText) {
        return translatorService.morseToAlphanumeric(morseText);
    }
}
