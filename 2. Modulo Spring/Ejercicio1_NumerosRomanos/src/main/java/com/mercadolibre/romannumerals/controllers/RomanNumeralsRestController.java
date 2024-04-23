package com.mercadolibre.romannumerals.controllers;

import com.mercadolibre.romannumerals.service.IRomanNumerals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralsRestController {
  @Autowired
  IRomanNumerals romanNumeralsService;

  @GetMapping("/{number}")
  public ResponseEntity<String> toRoman(@PathVariable Integer number) {
    String romanNumber = "";
    if (number >=0 && number < 4000) {
      romanNumber = romanNumeralsService.getRomanNumerals(number);
      return ResponseEntity.status(HttpStatus.OK).body(romanNumber);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El dato ingresado no es valido");
    }
  }
}
