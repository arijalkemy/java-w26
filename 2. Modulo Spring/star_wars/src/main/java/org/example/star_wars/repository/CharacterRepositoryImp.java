package org.example.star_wars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import org.example.star_wars.entity.Character;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryImp implements ICharacterRepository {
    private List<Character> characters;

    public CharacterRepositoryImp() {
        this.characters = loadDatabase();
    }

    private List<Character> loadDatabase() {
        List<Character> characters = new ArrayList<>();
        try{
            File file = ResourceUtils.getFile("classpath:starwars.json");
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Character>> typeReference = new TypeReference<>() {};
            try {
                characters = mapper.readValue(file, typeReference);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public List<Character> getAllCharacters() {
        return characters;
    }
}
