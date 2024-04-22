package com.example.starWars.service;

import com.example.starWars.dto.PersonajeDto;
import com.example.starWars.model.Personaje;
import com.example.starWars.repository.IStarWarsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private IStarWarsRepository repository;

    @Override
    public List<PersonajeDto> findAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> personajes = repository.obtenerPersonajes();
        return personajes.stream().map(p -> objectMapper.convertValue(personajes, PersonajeDto.class)).toList();
    }

    @Override
    public PersonajeDto findByName(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<Personaje> personaje = repository.obtenerPersonajes()
                .stream()
                .filter(p -> p.nameContains(name))
                .findFirst();
        return objectMapper.convertValue(personaje, PersonajeDto.class);
    }
}
