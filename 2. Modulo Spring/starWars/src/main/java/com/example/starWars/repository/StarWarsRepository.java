package com.example.starWars.repository;

import com.example.starWars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository{

    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Personaje> personajes;

    public StarWarsRepository() {

        InputStream inputStream = StarWarsRepository.class.getResourceAsStream("/starwars.json");

        try {
            personajes = objectMapper.readValue(inputStream, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> obtenerPersonajes() {
        return personajes;
    }
}
