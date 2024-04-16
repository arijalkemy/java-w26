package com.practicaSpring.dtosYResponseEntities;

import com.practicaSpring.dtosYResponseEntities.deporte.Deporte;
import com.practicaSpring.dtosYResponseEntities.persona.Persona;
import com.practicaSpring.dtosYResponseEntities.persona.dtos.PersonaInDTO;
import com.practicaSpring.dtosYResponseEntities.persona.dtos.PersonaOutDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DtosYResponseEntitiesController {
    List<Deporte> sports = new ArrayList<>();
    List<Persona> people = new ArrayList<>();

    @PostMapping(path = "/register")
    public void register(@RequestBody PersonaInDTO persona) {
        Deporte sport = sports.stream().filter(deporte ->
                deporte.getNombre().equalsIgnoreCase(persona.getNombreDeporte()) &&
                        deporte.getNivel().equalsIgnoreCase(persona.getNivelDeporte())).findAny().orElse(null);

        if(sport == null){
            sport = new Deporte(persona.getNombreDeporte(), persona.getNivelDeporte());
            sports.add(sport);
        }

        people.add(new Persona(persona.getNombre(), persona.getApellido(), persona.getEdad(), sport));
    }

    @GetMapping(path = "/findSports")
    public List<Deporte> findSports(){
        return sports;
    }

    @GetMapping(path = "/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        Deporte deporte = sports.stream().filter(sport ->
                sport.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
        if(deporte != null){
            return new ResponseEntity<>(deporte.getNivel(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/findSportsPersons")
    public List<PersonaOutDTO> findSportsPersons(){
        List<PersonaOutDTO> dtos = new ArrayList<>();
        for(Persona persona : people){
            PersonaOutDTO personaDTO = new PersonaOutDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre());
            dtos.add(personaDTO);
        }
        return dtos;
    }
}
