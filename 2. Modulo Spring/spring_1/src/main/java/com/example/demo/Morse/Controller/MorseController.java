package com.example.demo.Morse.Controller;

import com.example.demo.Morse.Domain.Service.IMorseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/morse")
public class MorseController {

    private final IMorseService morseService;


    @GetMapping("/parseToWord")
    public ResponseEntity<?> parseToWord(@RequestParam("morseCode") String morseCode) {
        String response = morseService.morseToWord(morseCode);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/parseToMorse")
    public ResponseEntity<?> parseToMorse(@RequestParam("word") String word) {
        String response = morseService.wordToMorse(word);
        return ResponseEntity.ok(response);
    }

}
