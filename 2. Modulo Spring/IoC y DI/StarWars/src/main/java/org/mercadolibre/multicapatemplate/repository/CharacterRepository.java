package org.mercadolibre.multicapatemplate.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.multicapatemplate.entity.Character;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepository {
    List<Character> characters;

    public CharacterRepository(ResourceLoader resourceLoader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = resourceLoader.getResource("classpath:static/starwars.json");
        this.characters = objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<List<Character>>() {
                });
    }

    public List<Character> findAll(){
        return this.characters;
    }
}
