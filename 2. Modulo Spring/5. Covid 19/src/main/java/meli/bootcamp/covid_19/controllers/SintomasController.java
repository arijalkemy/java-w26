package meli.bootcamp.covid_19.controllers;

import java.util.List;
import meli.bootcamp.covid_19.dto.SintomaDto;
import meli.bootcamp.covid_19.services.SintomasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findSymptom")
public class SintomasController {

  SintomasService sintomasService;

  @Autowired
  public SintomasController(SintomasService sintomasService) {
    this.sintomasService = sintomasService;
  }

  @GetMapping
  public ResponseEntity<List<SintomaDto>> getAll() {
    return ResponseEntity.ok(this.sintomasService.obtenerSintomas());
  }

  @GetMapping("/{name}")
  public ResponseEntity<List<SintomaDto>> getByName(@PathVariable String name) {
    return ResponseEntity.ok(this.sintomasService.obtenerSintomaPorNombre(name));
  }

}
