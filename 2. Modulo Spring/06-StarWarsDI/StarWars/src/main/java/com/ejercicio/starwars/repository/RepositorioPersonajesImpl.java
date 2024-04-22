package com.ejercicio.starwars.repository;

import com.ejercicio.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class RepositorioPersonajesImpl implements IRepositorioPersonajes{
    @Override
    public List<Personaje> getPersonajes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:StarWarsPersonajes.json");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {
        };
        List<Personaje> personajes = new ArrayList<>();
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(personajes.size());
        return personajes;
    }
}
