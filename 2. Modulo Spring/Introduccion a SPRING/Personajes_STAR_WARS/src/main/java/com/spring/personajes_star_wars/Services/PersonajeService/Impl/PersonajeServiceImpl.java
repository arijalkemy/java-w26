package com.spring.personajes_star_wars.Services.PersonajeService.Impl;

import com.spring.personajes_star_wars.Dtos.PersonajeDto;
import com.spring.personajes_star_wars.Models.Personaje;
import com.spring.personajes_star_wars.Repository.PersonajeRepository.IPersonajeRepository;
import com.spring.personajes_star_wars.Services.PersonajeService.IPersonajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonajeServiceImpl implements IPersonajesService {

        @Autowired
        IPersonajeRepository personajeRepository;

        @Override
        public List<PersonajeDto> findPersonajes(String nombre) {
            List<PersonajeDto> personajesFiltrados = personajeRepository.findByName(nombre)
                    .stream()
                    .map(this::mapToDto)
                    .toList();

            return personajesFiltrados;
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

