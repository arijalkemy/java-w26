package com.bootcamjava.starwars.repositories;

import com.bootcamjava.starwars.dto.CharacterDTO;
import com.bootcamjava.starwars.entity.Character;
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
public class CharacterRepository {

    private List<Character> characterDb = new ArrayList<Character>();

    private  void loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        try {
            this.characterDb = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Character> getAllCharacter(){

        return characterDb;
    }

    public CharacterRepository() {
        loadDataBase();
    }
}
