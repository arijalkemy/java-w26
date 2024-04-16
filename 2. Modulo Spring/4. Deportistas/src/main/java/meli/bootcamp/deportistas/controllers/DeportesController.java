package meli.bootcamp.deportistas.controllers;

import java.util.List;
import meli.bootcamp.deportistas.domain.Deporte;
import meli.bootcamp.deportistas.services.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findSports")
public class DeportesController {
  DeporteService deporteService;

  @Autowired
  public DeportesController(DeporteService deporteService) {
    this.deporteService = deporteService;
  }

  @GetMapping
  public ResponseEntity<List<Deporte>> findSports() {
    List<Deporte> deportes = deporteService.findSports();
    return new ResponseEntity<>(deportes, HttpStatus.OK);
  }

  @GetMapping("/{name}")
  public ResponseEntity<Deporte> findSportsByName(@PathVariable String name) {
    Deporte deporte = deporteService.obtenerPorNombre(name);
    return new ResponseEntity<>(deporte, HttpStatus.NOT_FOUND);
  }

}
