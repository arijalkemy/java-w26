package com.covi.covid_19.Controllers;

import com.covi.covid_19.Classes.Persona;
import com.covi.covid_19.Classes.Sintoma;
import com.covi.covid_19.DTO.PersonaSistemaDTO;
import com.covi.covid_19.Services.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class SymptonController {

    private final SistemaService sistemaService;

    @Autowired
    public SymptonController(SistemaService sistemaService) {
        this.sistemaService = sistemaService;
    }

    @GetMapping("/findSymptoms")
    ResponseEntity<List<Sintoma>> conseguirTodosLosSintomas() {
        return ResponseEntity.ok(sistemaService.conseguirTodosLosSintomas());
    }

    @PostMapping("/addSymptom")
    ResponseEntity<String> agregarSintoma(@RequestBody Sintoma sintoma) {
        sistemaService.agregarSintoma(sintoma);
        return ResponseEntity.ok("Sintoma añadido correctamente");
    }

    @GetMapping("/findSymptom/{name}")
    public String conseguirSintomaPorNombre(@PathVariable String name) {
        return sistemaService.conseguirSintomaPorNombre(name);
    }

}
