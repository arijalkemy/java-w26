package com.starwars.Personajes.de.starwar.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.Personajes.de.starwar.entity.Personaje;
import com.starwars.Personajes.de.starwar.repository.IRepository;


import org.springframework.stereotype.Repository;



import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Repository
public class IRepositoryPersonajeImpl implements IRepository<Personaje> {

    private List<Personaje> personajesList;

    public IRepositoryPersonajeImpl() {
       this.personajesList = loadDataBase();
    }

    @Override
    public Optional<Personaje> findByName(String name) {
        return personajesList.stream()
                .filter(e->e.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Personaje> findAll() {
        return personajesList;
    }

    private List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
