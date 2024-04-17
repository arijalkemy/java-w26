package com.example.starwars_vivo.repository;
import com.example.starwars_vivo.entity.Character;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StarWarsRepository implements IStarWarsRepository {

    public List<Character> readCharactersFromJson(){
        List<Character> characters = null;
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/static/starwars.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            characters = objectMapper.readValue(jsonContent, objectMapper.getTypeFactory().constructCollectionType(List.class, Character.class));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}