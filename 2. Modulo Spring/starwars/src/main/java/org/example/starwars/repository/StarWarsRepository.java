package org.example.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.model.StarWarCharacter;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StarWarsRepository {
    public StarWarsRepository() {
        // Crear instancias de los personajes y agregarlos al ArrayList
        //starWarCharacters.add(new StarWarCharacter("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male, Tatooine, Human"));
    }


    public List<StarWarCharacter> getStarWarCharacters() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarWarCharacter>> typeRef = new TypeReference<>() {};
        List<StarWarCharacter> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    // Otros métodos de la clase StarWarsRepository...
}
