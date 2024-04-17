package meli.bootcamp.star_wars.controller;

import java.util.List;
import meli.bootcamp.star_wars.domain.Personaje;
import meli.bootcamp.star_wars.dto.PersonajeDto;
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
  public ResponseEntity<List<PersonajeDto>> buscarPersonajePorNombre(@PathVariable String name) {
    List<Personaje> personajes = personajeService.buscarPersonajePorNombre(name);
    List<PersonajeDto> personajseDto = personajes.stream().map(this::crearPersonajeDto).toList();

    return ResponseEntity.ok().body(personajseDto);
  }

  @GetMapping
  public ResponseEntity<List<PersonajeDto>> obtenerPersonajes() {
    List<Personaje> personajes = personajeService.obtenerPersonajes();
    List<PersonajeDto> personajesDto = personajes.stream().map(this::crearPersonajeDto).toList();
    return ResponseEntity.ok().body(personajesDto);
  }

  public PersonajeDto crearPersonajeDto(Personaje personaje) {
    return new PersonajeDto(
        personaje.getName(),
        personaje.getHeight(),
        personaje.getMass(),
        personaje.getHairColor(),
        personaje.getBirthYear()
    );
  }
}
