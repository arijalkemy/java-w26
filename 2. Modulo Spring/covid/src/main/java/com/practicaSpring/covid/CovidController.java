package com.practicaSpring.covid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class CovidController {
    private HashSet<Persona> registrados = new HashSet<>();
    private HashSet<Sintoma> sintomas = new HashSet<>();

    @GetMapping("/findSymptoms")
    public HashSet<Sintoma> findSymptom() {
        return sintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Integer> findSymptom(@PathVariable String name) {
        Sintoma sintoma = sintomas.stream().filter(symptom -> symptom.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
        if(sintoma != null) {
            return new ResponseEntity<Integer>(sintoma.getNivelDeGravedad(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public void registrarPersona(@RequestBody Persona persona) {
        sintomas.addAll(persona.getSintomas());
        registrados.add(persona);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findRiskPerson(){
        List<PersonaDTO> personas = new ArrayList<>();
        registrados.forEach(persona -> {
            if(!persona.getSintomas().isEmpty() && persona.getEdad() >= 60) {
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setNombre(persona.getNombre());
                personaDTO.setApellido(persona.getApellido());
                personas.add(personaDTO);
            }
        }
        );
        return personas;
    }
}
