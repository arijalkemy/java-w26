package org.ggomezr.starwars.domain.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ggomezr.starwars.domain.entity.Character;
import org.ggomezr.starwars.domain.repository.interfaces.ICharacterRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {
    private final String FILE_PATH = "starwars.json";

    public List<Character> getAllCharacters() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource(FILE_PATH).getInputStream();
        Character[] characters = objectMapper.readValue(inputStream, Character[].class);
        return Arrays.asList(characters);
    }
}
