package com.ejercicio.starwars.repository.implementations;

import com.ejercicio.starwars.entity.Character;
import com.ejercicio.starwars.repository.interfaces.ICharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {
    private List<Character> characterList;

    public CharacterRepository() {
        loadDataBase();
    }

    public List<Character> findByName(String nameSubstring) {
        return characterList
                .stream()
                .filter(character -> character.getName().toUpperCase().contains(nameSubstring.toUpperCase()))
                .toList();
    }

    private void loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        try {
            characterList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Character> createCharacters() {
        List<Character> characterList = new ArrayList<Character>();

        characterList.add(new Character(
                "Luke Skywalker",
                80,
                70,
                "Rubio",
                "Blanco",
                "Celeste",
                "1985",
                "Masculino",
                "Tierra",
                "Labrador"
        ));
        characterList.add(new Character(
                "Darth Vader",
                90,
                80,
                "Castaño",
                "Blanco",
                "Marron",
                "1970",
                "Masculino",
                "Marte",
                "Labrador"
        ));
        characterList.add(new Character(
                "Darth Maul",
                90,
                80,
                "Negro",
                "Negro",
                "Marron",
                "19875",
                "Masculino",
                "Jupiter",
                "Labrador"
        ));

        return characterList;
    }
}
