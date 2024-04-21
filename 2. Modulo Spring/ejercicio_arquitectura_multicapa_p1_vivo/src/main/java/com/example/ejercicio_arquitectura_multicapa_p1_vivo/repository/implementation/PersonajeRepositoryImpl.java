package com.example.ejercicio_arquitectura_multicapa_p1_vivo.repository.implementation;

import com.example.ejercicio_arquitectura_multicapa_p1_vivo.entity.Personaje;
import com.example.ejercicio_arquitectura_multicapa_p1_vivo.repository.IPersonajeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {
    private final List<Personaje> database;

    public PersonajeRepositoryImpl() {
        this.database = cargarDatabase();
    }
    @Override
    public List<Personaje> buscarPersonajesPorNombre(String name) {
        return database.stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());
    }

    private List<Personaje> cargarDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }
}
