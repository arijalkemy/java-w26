package meli.bootcamp.covid_19.controllers;

import java.util.List;
import meli.bootcamp.covid_19.dto.PersonaDto;
import meli.bootcamp.covid_19.services.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findRiskPerson")
public class PersonasController {
  PersonasService personasService;

  @Autowired
  public PersonasController(PersonasService personasService) {
    this.personasService = personasService;
  }

  @GetMapping
  public ResponseEntity<List<PersonaDto>> getAll() {
    return ResponseEntity.ok(this.personasService.obtenerPersonasConRiesgo());
  }

}
