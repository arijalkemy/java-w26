package com.example.personasdeportistas.controllers;

import com.example.personasdeportistas.dto.PersonaDTO;
import com.example.personasdeportistas.models.Deporte;
import com.example.personasdeportistas.models.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonasController {
    private final List<Persona> personas = Arrays.asList(
            new Persona("Juan", "Perez", 30, new Deporte("Futbol", "Profesional")),
            new Persona("Maria", "Gomez", 25, new Deporte("Natacion", "Intermedio")),
            new Persona("Pedro", "Martinez", 35, new Deporte("Tenis", "Amateur"))
    );

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> buscarPersonaDeportista(){
        List<PersonaDTO> listaPersonasDTO = personas.stream().map(this::convertirADTO).collect(Collectors.toList());
        return ResponseEntity.ok(listaPersonasDTO);
    }

    private PersonaDTO convertirADTO(Persona persona){
        PersonaDTO dto = new PersonaDTO();
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setNombreDeporte(persona.getDeporte().getNombre());
        return dto;
    }
}
