package org.example.codigo_morse.controllers;

import org.example.codigo_morse.services.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("api/")
public class MorseController {
    @Autowired
    IMorseService morseService;

    @GetMapping("text/{code}")
    public ResponseEntity<String> translateFromMorse(@PathVariable String code) {
        try {
            return ResponseEntity.ok( morseService.translateToWords(code));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("morse/{text}")
    public ResponseEntity<String> translateToMorse(@PathVariable String text) {
        try{
            return ResponseEntity.ok(morseService.translateToMorse(text));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
