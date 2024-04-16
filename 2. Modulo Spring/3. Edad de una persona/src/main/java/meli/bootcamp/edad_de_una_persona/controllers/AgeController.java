package meli.bootcamp.edad_de_una_persona.controllers;

import meli.bootcamp.edad_de_una_persona.services.AgeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
  AgeService ageService;

  public AgeController(AgeService ageService) {
    this.ageService = ageService;
  }

  @RequestMapping("/{year}/{month}/{day}")
  public int calculateAge(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
    return ageService.calculateAge(year, month, day);
  }

}


