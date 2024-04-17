package org.example.starwars.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.repository.PersonajeRepository;
import org.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;


    @Override
    public List<PersonajeDTO> buscarPersonajes(String nombre) throws IOException {
        List<PersonajeDTO> personajes = new ArrayList<>();

        personajeRepository.findAll().stream()
                .filter(p -> p.getName().toLowerCase().contains(nombre.toLowerCase()))
                .forEach(p -> {
                    personajes.add(new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(),
                            p.getHomeworld(), p.getSpecies()));
                });

        return personajes;
    }
}
