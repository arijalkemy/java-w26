package org.example._07covid19.Controllers;

import org.example._07covid19.DTOs.PersonaConSintomasDTO;
import org.example._07covid19.DTOs.SintomaDTO;
import org.example._07covid19.Persona;
import org.example._07covid19.Repositories.RepositorioSintomas;
import org.example._07covid19.Services.IPersonasDeRiesgoService;
import org.example._07covid19.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class CovidController {

    @Autowired
    IPersonasDeRiesgoService personasDeRiesgoService;

    @GetMapping("/findSymptom")
    public ResponseEntity<ArrayList<SintomaDTO>> getSintomas() {
        List<Sintoma> sintomas = RepositorioSintomas.obtenerTodos();
        if (sintomas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
        }
        ArrayList<SintomaDTO> sintomasDTO = new ArrayList<>();
        sintomas.forEach(s -> sintomasDTO.add(new SintomaDTO(s.getCodigo(), s.getNombre(), s.getNivelDeGravedad())));
        return ResponseEntity.status(HttpStatus.OK).body(sintomasDTO);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSintoma(@PathVariable String name) {
        Sintoma sintoma = RepositorioSintomas.obtenerPorNombre(name);
        if (sintoma == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el síntoma");
        }
        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(sintoma.getNivelDeGravedad()));
    }

    @PostMapping("/symptoms")
    public ResponseEntity<String> guardarSintoma(@RequestBody SintomaDTO sintomaDTO) {
        Sintoma sintoma = new Sintoma(sintomaDTO.getCodigo(), sintomaDTO.getNombre(), sintomaDTO.getNivelDeGravedad());
        RepositorioSintomas.guardar(sintoma);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sintoma guardado con éxito");
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaConSintomasDTO>> getRiskPersons() {
        List<Persona> personasDeRiesgo = personasDeRiesgoService.obtener(RepositorioSintomas.obtenerPersonas());
        List<PersonaConSintomasDTO> personasDeRiesgoDTO = new ArrayList<>();
        personasDeRiesgo.forEach(p -> personasDeRiesgoDTO.add(new PersonaConSintomasDTO(p.getId(), p.getNombre(), p.getApellido(), p.getEdad(), p.getSintomas())));
        return ResponseEntity.status(HttpStatus.OK).body(personasDeRiesgoDTO);
    }

    @PostMapping("/persons")
    public ResponseEntity<String> guardarPersona(@RequestBody PersonaConSintomasDTO personaDTO) {
        Persona persona = new Persona(personaDTO.getId(), personaDTO.getNombre(), personaDTO.getApellido(), personaDTO.getEdad());
        persona.setSintomas(personaDTO.getSintomas());
        RepositorioSintomas.guardar(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body("Persona con síntomas guardada con éxito");
    }
}
