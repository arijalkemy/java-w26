package org.example.starswars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.example.starswars.Model.Personaje;

import java.util.ArrayList;

@Repository
public class StarWarsRepository {
    private List<Personaje> listPersonajes;

    public StarWarsRepository() {
        this.listPersonajes =this.loadDataBase();
    }

    private List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {
        };
        List<Personaje> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

    public List<Personaje> allCharacters() {
        return new ArrayList<>(this.listPersonajes);
    }

    public List<Personaje> buscarPersonajePorNombre(String nombre) {
        return this.listPersonajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(nombre.toLowerCase()))
                .toList();
    }
}

