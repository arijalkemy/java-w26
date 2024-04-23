package org.bootcamp.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.starwars.dto.CharacterDTO;
import org.bootcamp.starwars.model.Character;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {
    private final List<Character> characters;

    public CharacterRepositoryImpl() {
        characters = loadDatabase();
    }

    @Override
    public List<CharacterDTO> getCharactersByContains(String query) {
        return characters.stream()
                .filter(character -> character.getName().contains(query))
                .map(character -> new CharacterDTO(character.getName(), character.getGender(), character.getHomeworld(), character.getSpecies(), character.getHeight(), character.getMass()))
                .toList();
    }

    private List<Character> loadDatabase() {
        File file = null;
        try {
            file = new File("src/main/resources/static/starwars.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
