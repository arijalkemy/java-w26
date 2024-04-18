package starwars.starwars.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import starwars.starwars.model.Character;
import starwars.starwars.repository.ICharacterRepository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

@Repository

public class CharacterRepository implements ICharacterRepository {
    List<Character> characters;

    public CharacterRepository() {
        this.searchAllCharacters();
    }

    public void searchAllCharacters() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClassPathResource resource = new ClassPathResource("static/starwars.json");
            this.characters = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Character>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Character> searchCharactersByName(String name) {
        return this.characters.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

}
