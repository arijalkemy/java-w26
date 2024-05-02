package org.example.starwars.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.entity.Personaje;
import org.example.starwars.repository.PersonajeRepositoryImpl;
import org.example.starwars.service.interfaces.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    private List<Personaje> personajesList;

    private PersonajeServiceImpl() {
        PersonajeRepositoryImpl personajeRepository = new PersonajeRepositoryImpl();
        personajesList = personajeRepository.getPersonajes();
    }

    @Override
    public List<PersonajeDTO> getPersonaje(String name) {

        List<Personaje> personajeFilter = personajesList.stream().filter(v -> v.getName()
                .toLowerCase().contains(name.toLowerCase())).toList();
        
        if (personajeFilter.isEmpty()) {
            return List.of();
        }

        List<PersonajeDTO> personajesDTO = personajeFilter.stream()
                .map(perDTO -> new PersonajeDTO(perDTO.getName(), perDTO.getHeight(), perDTO.getMass(),
                        perDTO.getGender(), perDTO.getHomeworld(), perDTO.getSpecies()))
                .collect(Collectors.toList());

        return personajesDTO;
    }
}
