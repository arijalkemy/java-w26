package com.spring.personajes_star_wars.Repository.PersonajeRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.personajes_star_wars.Models.Personaje;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    private List<Personaje> personajes;

    public PersonajeRepositoryImpl() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("data/starwars.json").getFile();
            personajes = objectMapper.readValue(file, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> personajesStarWars = personajes
                .stream()
                .filter(d -> d.getName().toLowerCase().startsWith(name.toLowerCase()))
                .toList();

        return personajesStarWars;
    }
}
