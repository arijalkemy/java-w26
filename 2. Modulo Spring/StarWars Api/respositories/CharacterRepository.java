package org.example.starwars.respositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.entities.Character;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {
    private List<Character> listCharacters;

    public CharacterRepository() {
        try {
            Resource resource = new ClassPathResource("static/starwars.json");
            InputStream input = resource.getInputStream();
            File file = resource.getFile();
            ObjectMapper objectMapper = new ObjectMapper();
            listCharacters = Arrays.asList(objectMapper.readValue(file, Character[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Character> listCharacters() {
        return this.listCharacters;
    }
}
