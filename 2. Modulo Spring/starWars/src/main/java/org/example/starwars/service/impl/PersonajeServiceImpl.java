package org.example.starwars.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.entity.Personaje;
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
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<PersonajeDTO> getPersonaje(String name) {

        try {
            Resource resource = resourceLoader.getResource("classpath:static/personajes.json");
            InputStream inputStream = resource.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            List<Personaje> personajes = Arrays.asList(objectMapper.readValue(inputStream, Personaje[].class));

            List<Personaje> personajeFilter = personajes.stream().filter(v -> v.getName()
                    .toLowerCase().contains(name.toLowerCase())).toList();


            if (personajeFilter.isEmpty()) {
                return List.of();
            }

            List<PersonajeDTO> personajesDTO = personajeFilter.stream()
                    .map(perDTO -> new PersonajeDTO(perDTO.getName(), perDTO.getHeight(), perDTO.getMass(),
                            perDTO.getGender(), perDTO.getHomeworld(), perDTO.getSpecies()))
                    .collect(Collectors.toList());

            return personajesDTO;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }
}
