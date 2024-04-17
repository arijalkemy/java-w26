package com.starWars.personajesStarWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starWars.personajesStarWars.dto.CharacterDTO;
import com.starWars.personajesStarWars.model.Character;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class CharacterRepository {
    private final List<Character> characters;

    public CharacterRepository() {
        this.characters = loadDataBase();
    }

    public List<Character> findByName(String name){
        return characters.stream()
                .filter(c -> c.getName().toUpperCase().contains(name.toUpperCase()))
                .toList();
    }

    private List<Character> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
