package meli.bootcamp.deportistas.controllers;

import java.util.List;
import meli.bootcamp.deportistas.domain.Persona;
import meli.bootcamp.deportistas.services.PersonaService;
import org.apache.coyote.Response;
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
  public ResponseEntity<List<Persona>> findSportsPersons() {
    return ResponseEntity.ok(personaService.findSportsPersons());
  }
}
