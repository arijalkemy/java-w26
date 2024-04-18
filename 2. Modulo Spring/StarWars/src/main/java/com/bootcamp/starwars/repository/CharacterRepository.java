package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharacterRepository {

    private static List<Character> listCharacters = new ArrayList<>();

    static{
        loadDataBase();
    }

    private static  void loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characters = null;
        try {
            listCharacters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Character> getAllCharacters(){
        return listCharacters;
    }
}
