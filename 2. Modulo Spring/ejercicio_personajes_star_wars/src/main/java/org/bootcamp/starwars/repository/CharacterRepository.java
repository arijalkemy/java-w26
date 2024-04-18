package org.bootcamp.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.starwars.entity.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {

    private List<Character> characterList;

    public CharacterRepository() {
        characterList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Se carga el archivo con la lista de los personajes
            File file = ResourceUtils.getFile("classpath:starwars.json");
            InputStream inputStream = new FileInputStream(file);

            // Se instancia el tipo de referencia
            TypeReference<List<Character>> typeReference = new TypeReference<List<Character>>() {};

            // Se realiza el mapeo del json a la lista
            characterList = objectMapper.readValue(inputStream, typeReference);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Character> getAll() {
        return characterList;
    }

    public List<Character> getByName(String name) {
        return characterList.stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
