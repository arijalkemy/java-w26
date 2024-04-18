package meli.bootcamp.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.starwars.dto.CharacterDto;
import meli.bootcamp.starwars.entity.Character;
import meli.bootcamp.starwars.repository.interfaces.ICrud;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepository implements ICrud<Character> {
    private List<Character> characters;

    public StarWarsRepository() {
        populate();
    }

    private void populate() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Resource resource = new ClassPathResource("data/starwars.json");
            characters = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Character>>() {
            });

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Character> findAll(){
        return this.characters;
    }
}
