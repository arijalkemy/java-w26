package com.practicaSpring.dtosYResponseEntities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DtosYResponseEntitiesController {
    List<Deporte> deportes = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    @PostMapping(path = "/register")
    public void register(@RequestBody Persona persona) {
        if(!deportes.contains(persona.getDeporte())){
            deportes.add(persona.getDeporte());
        }
        personas.add(persona);
    }

    @GetMapping(path = "/findSports")
    public List<Deporte> findSports(){
        return deportes;
    }

    @GetMapping(path = "/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        Deporte deporte = deportes.stream().filter(sport -> sport.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
        if(deporte != null){
            return new ResponseEntity<>(deporte.getNivel(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/findSportsPersons")
    public List<PersonaDTO> findSportsPersons(){
        List<PersonaDTO> dtos = new ArrayList<>();
        for(Persona persona : personas){
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setNombre(persona.getNombre());
            personaDTO.setApellido(persona.getApellido());
            personaDTO.setNombreDeporte(persona.getDeporte().getNombre());
            dtos.add(personaDTO);
        }
        return dtos;
    }
}
