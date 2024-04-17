package com.personajes.starwars.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personajes.starwars.dto.PersonajeDTO;
import com.personajes.starwars.model.PersonajeStarWars;
import com.personajes.starwars.repository.StarWarsRepository;
import com.personajes.starwars.service.StarWarsPersonajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsPersonajesImpl implements StarWarsPersonajes {

    @Autowired
    StarWarsRepository starWarsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<PersonajeDTO> getPersonajeByName(String nombre){

        List<PersonajeStarWars> personajeStarWarsList =  starWarsRepository.getPersonajeByName(nombre);

        return personajeStarWarsList.stream()
                .map(this::convertirAPersonajeDTO).toList();

    }

    private PersonajeDTO mapearPersonajDTO(PersonajeStarWars personajeStarWars){
        return objectMapper.convertValue(personajeStarWars, PersonajeDTO.class);
    }

    private PersonajeDTO convertirAPersonajeDTO(PersonajeStarWars personaje) {
        PersonajeDTO dto = new PersonajeDTO();
        dto.setName(personaje.getName());
        dto.setHeight(personaje.getHeight());
        dto.setMass(personaje.getMass());
        dto.setGender(personaje.getGender());
        dto.setHomeWorld(personaje.getHomeworld());
        dto.setSpecies(personaje.getSpecies());
        return dto;
    }
}
