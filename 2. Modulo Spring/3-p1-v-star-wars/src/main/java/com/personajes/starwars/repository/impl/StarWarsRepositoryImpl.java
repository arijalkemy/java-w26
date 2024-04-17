package com.personajes.starwars.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personajes.starwars.model.PersonajeStarWars;
import com.personajes.starwars.repository.StarWarsRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {

    private List<PersonajeStarWars> personajeStarWars;

    public StarWarsRepositoryImpl() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("data/starwars.json").getFile();
            personajeStarWars = objectMapper.readValue(file, new TypeReference<List<PersonajeStarWars>>() {});
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    @Override
    public List<PersonajeStarWars> getPersonajeByName(String nombre) {

        return this.personajeStarWars.stream()
                .filter(x -> x.getName().toLowerCase().contains(nombre.toLowerCase()))
                .toList();
    }
}
