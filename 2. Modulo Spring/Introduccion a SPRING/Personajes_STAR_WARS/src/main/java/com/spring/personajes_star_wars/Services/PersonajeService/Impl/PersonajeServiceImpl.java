package com.spring.personajes_star_wars.Services.PersonajeService.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.personajes_star_wars.Dtos.PersonajeDto;
import com.spring.personajes_star_wars.Models.Personaje;
import com.spring.personajes_star_wars.Services.PersonajeService.IPersonajesService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Service
public class PersonajeServiceImpl implements IPersonajesService {

    private List<Personaje> personajes;
    ObjectMapper objectMapper = new ObjectMapper();
    public PersonajeServiceImpl() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("data/starwars.json").getFile();
            personajes = objectMapper.readValue(file, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            throw new IOException(e);
        }
    }


        @Override
        public List<PersonajeDto> findPersonajes(String nombre) {
            List<PersonajeDto> personajesFiltrados = personajes.stream()
                    .filter(p -> p.getName().toLowerCase().startsWith(nombre.toLowerCase()))
                    .map(this::mapToDto)
                    .toList();

            return personajesFiltrados;
        }

    @Override
    public List<Personaje> findAll() {
        return personajes;
    }

    private PersonajeDto mapToDto(Personaje personaje) {
            PersonajeDto personajeDto = new PersonajeDto();
            personajeDto.setName(personaje.getName());
            personajeDto.setHomeworld(personaje.getHomeWorld());
            personajeDto.setMass(personaje.getMass());
            personajeDto.setGender(personaje.getGender());
            personajeDto.setSpecies(personaje.getSpecies());
            personajeDto.setHeight(personaje.getHeight());
            return personajeDto;
        }
}

