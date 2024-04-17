package com.practicaSpring.starWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practicaSpring.starWars.model.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {
    private final List<Character> db;

    public CharacterRepositoryImpl() {
        db = loadDb();
    }

    private List<Character> loadDb() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<List<Character>>() {};
        List<Character> resp = null;
        try{
            resp = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public List<Character> findAll(){
        return db;
    }

    public List<Character> findByString(String substring) {
        try{
            return findAll().stream().filter(character -> character.getName().toLowerCase().contains(substring.toLowerCase()))
                .collect(Collectors.toList());
        } catch (NullPointerException e){
            return null;
        }
    }
}
