package com.bootcamp.starwars.repository.implementations;

import com.bootcamp.starwars.StarwarsApplication;
import com.bootcamp.starwars.entity.StarWarsCharacter;
import com.bootcamp.starwars.repository.ICharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {
    private List<StarWarsCharacter> starWarsCharactersList;

    public CharacterRepositoryImpl() {
        this.starWarsCharactersList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream starWarsJsonStream = StarwarsApplication.class.getResourceAsStream("/starwars.json");
            StarWarsCharacter[] characters = mapper.readValue(starWarsJsonStream, StarWarsCharacter[].class);
            for (StarWarsCharacter character :
                    characters) {
                this.starWarsCharactersList.add(character);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<StarWarsCharacter> getAllCharacters() {
        return this.starWarsCharactersList;
    }

}
