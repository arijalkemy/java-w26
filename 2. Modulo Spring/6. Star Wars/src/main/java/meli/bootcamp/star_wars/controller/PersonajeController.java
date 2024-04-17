package meli.bootcamp.star_wars.controller;

import java.util.List;
import meli.bootcamp.star_wars.domain.Personaje;
import meli.bootcamp.star_wars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {
  IPersonajeService personajeService;

  @Autowired
  public PersonajeController(IPersonajeService personajeService) {
    this.personajeService = personajeService;
  }

  @GetMapping("/{name}")
  public ResponseEntity<Personaje> buscarPersonajePorNombre(@PathVariable String name) {
    return ResponseEntity.ok().body(personajeService.buscarPersonajePorNombre(name));
  }

  @GetMapping
  public ResponseEntity<List<Personaje>> obtenerPersonajes() {
    return ResponseEntity.ok().body(personajeService.obtenerPersonajes());
  }
}
