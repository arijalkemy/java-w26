package meli.bootcamp.deportistas.controllers;

import dto.PersonaDto;
import java.util.List;
import meli.bootcamp.deportistas.services.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findSportsPersons")
public class PersonasController {
  PersonaService personaService;

  public PersonasController(PersonaService personaService) {
    this.personaService = personaService;
  }

  @GetMapping
  public ResponseEntity<List<PersonaDto>> findSportsPersons() {
    return ResponseEntity.ok(personaService.findSportsPersons());
  }
}
