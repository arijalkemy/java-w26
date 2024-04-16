package com.example.demo.controller;

import com.example.demo.model.TranslationResponse;
import com.example.demo.service.MorseTranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("translate")
public class MorseController {


    private final MorseTranslatorService translatorService;

    @Autowired
    public MorseController(MorseTranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    @PostMapping("/toSpanish")
    public ResponseEntity<TranslationResponse> translateMorseToSpanish(String morseCode) {
        String translation = translatorService.translateMorseToSpanish(morseCode);
        TranslationResponse response = new TranslationResponse(morseCode, translation);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/toMorse")
    public ResponseEntity<TranslationResponse> translateSpanishToMorse(String morseCode) {
        String translation = translatorService.translateSpanishToMorse(morseCode);
        TranslationResponse response = new TranslationResponse(morseCode, translation);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
