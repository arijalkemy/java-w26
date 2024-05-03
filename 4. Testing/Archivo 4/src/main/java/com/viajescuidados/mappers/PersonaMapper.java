package com.viajescuidados.mappers;

import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;
import com.viajescuidados.entities.Persona;

public class PersonaMapper {

    public static Persona crearPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        return persona;
    }

    public static PersonaResponseDTO crearPersonaResponseDTO(Persona persona) {
        return new PersonaResponseDTO(persona.getId(), persona.getNombre(), persona.getApellido());
    }
}
