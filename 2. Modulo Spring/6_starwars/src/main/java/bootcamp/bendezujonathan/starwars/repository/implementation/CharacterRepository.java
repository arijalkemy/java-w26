package bootcamp.bendezujonathan.starwars.repository.implementation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.bendezujonathan.starwars.StarwarsApplication;
import bootcamp.bendezujonathan.starwars.model.Character;
import bootcamp.bendezujonathan.starwars.repository.interfaces.ICharacterRepository;

@Repository
public class CharacterRepository implements ICharacterRepository {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private List<Character> characters;

    CharacterRepository() {
        InputStream inputStream = StarwarsApplication.class.getResourceAsStream("/starwars.json");

        try {
            characters = MAPPER.readValue(inputStream, new TypeReference<List<Character>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Character> findAll() {
        return characters;
    }
    
}
