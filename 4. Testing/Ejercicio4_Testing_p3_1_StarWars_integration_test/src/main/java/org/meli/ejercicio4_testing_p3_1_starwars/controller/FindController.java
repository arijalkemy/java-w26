package org.meli.ejercicio4_testing_p3_1_starwars.controller;

import jakarta.validation.constraints.Pattern;
import org.meli.ejercicio4_testing_p3_1_starwars.dto.CharacterDTO;
import org.meli.ejercicio4_testing_p3_1_starwars.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class FindController {
  @Autowired
  private FindService findService;

  @GetMapping("/{query}")
  public List<CharacterDTO> find(
          @PathVariable
          @Pattern(regexp = "^[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
                  message = "El campo no puede poseer caracteres especiales.")
          String query) {
    return findService.find(query);
  }


}
