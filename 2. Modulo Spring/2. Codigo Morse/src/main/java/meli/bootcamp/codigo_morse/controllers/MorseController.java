package meli.bootcamp.codigo_morse.controllers;

import meli.bootcamp.codigo_morse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
  MorseService morseService;

  @Autowired
  public MorseController(MorseService morseService) {
    this.morseService = morseService;
  }

  @GetMapping("morse/{morseCode}")
  public String translateToText(@PathVariable String morseCode) {
    return morseService.morseToText(morseCode);
  }

  @GetMapping("/text/{text}")
  public String translateToMorse(@PathVariable String text) {
    return morseService.textToMorse(text);
  }

}
