package org.example.starwars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.StarWarsApplication;
import org.example.starwars.entity.Personaje;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class PersonajeRepositoryImpl implements IPersonajeRepository {
    @Override
    public List<Personaje> getPersonajes() {
        try {
            InputStream inputStream = StarWarsApplication.class.getResourceAsStream("/personajes.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Personaje> personajesList = Arrays.asList(objectMapper.readValue(inputStream, Personaje[].class));
            return personajesList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
