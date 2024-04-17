package com.starwars.personajes.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.personajes.dto.CharacterDTO;
import com.starwars.personajes.entity.Character;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository {
    @Override
    public List<Character> getCharacters() {
        String jsonFilePath = "src/main/resources/starwars.json";

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            List<Character> characters = mapper.readValue(json, new TypeReference<List<Character>>(){});

            return characters;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
